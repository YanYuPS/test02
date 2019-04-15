package com.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.bean.StaticFile;
import com.config.OracleUtil;

public class TablePeoSer {
	static String pathOut=StaticFile.PATH;
	
	ArrayList<String> orgList=new ArrayList<String>();
	ArrayList<String> subList=new ArrayList<String>();
	ArrayList<String> caseList=new ArrayList<String>();
	
	public static void main(String[] args) {
		
		TablePeoSer tableSer=new TablePeoSer();
		//将原始json的分行，改写成一行数据一行
		tableSer.txtRe();
		//获取99条数据的执法机关、执法主体、案件list
		tableSer.getList();
		//读取原始数据文件，将执法机关、执法主体、案件添加进去
		tableSer.txtRe1();
		
		//输出orgList
//		for(int i=0;i<tableSer.orgList.size();i++) {
//			System.out.println(i+"org:"+tableSer.orgList.get(i));
//		}
//		for(int i=0;i<tableSer.subList.size();i++) {
//			System.out.println(i+"sub:"+tableSer.subList.get(i));
//		}
//		for(int i=0;i<tableSer.caseList.size();i++) {
//			System.out.println(i+"case:"+tableSer.caseList.get(i));
//		}
				
	}
	
	/**
	 * 将原始json的分行，改写成一行数据一行
	 */
	public void txtRe() {
		/**
		 * 导出json之后，删掉开头，改成txt
 select * from TBL_BASIC_PERSON p
 where ROWNUM<100 ORDER BY p.id;
		 */
		String path=pathOut+"\\原始数据文件\\人员-机关主体案件.txt";
		try (BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(path),"UTF-8"));) {
    
			File writename = new File(pathOut+"\\中间结果数据文件\\人员-机关主体案件.txt"); 
	        writename.createNewFile(); // 创建新文件  
	        BufferedWriter out = new BufferedWriter(new FileWriter(writename));
	        
			String line;
			String line1="";//写入
			while ((line = br.readLine()) != null) {// 一次读入一行数据
				line1=line1+line;
				if(line.equals("}") || line.equals("},")) {
					out.write(line1+"\r\n"); // \r\n即为换行
//					System.out.println(line1);
					line1="";
				}
			}
			out.flush(); // 把缓存区内容压入文件  
	        out.close(); // 最后记得关闭文件
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获取99条数据的执法机关、执法主体、案件list
	 */
	public void getList() {
		String path=pathOut+"\\中间结果数据文件\\人员-机关主体案件.txt";
		try (BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(path),"UTF-8"));) {
			String line;
			while ((line = br.readLine()) != null) {// 一次读入一行数据
				String pattern = "\"ID\":\"(.*?)\"";
			    Pattern r = Pattern.compile(pattern);
			    Matcher m = r.matcher(line);
			    if (m.find( )) {
//			    	System.out.println(m.group(1));
			       getOrg(m.group(1));
			       getSub(m.group(1));
			       getCase(m.group(1));
			    } else {
			       System.out.println("NO MATCH");
			    }
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	

	/**
	 * 读取原始数据文件，将执法机关、执法主体、案件添加进去
	 */
	public void txtRe1() {
		String path=pathOut+"\\原始数据文件\\人员-机关主体案件.txt";
		try (BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(path),"UTF-8"));) {
    
			File writename = new File(pathOut+"\\结果数据文件\\人员-机关主体案件.txt"); 
	        writename.createNewFile(); // 创建新文件  
	        BufferedWriter out = new BufferedWriter(new FileWriter(writename));
	        
			String line;
			String line1="";
			int n=0;
			while ((line = br.readLine()) != null) {// 一次读入一行数据
				//替换
				//人员姓名"NAME"--"DEPARTMENT_NAME"
				line=line.replace("\"NAME\"", "\"OFFICE_NAME\"");
				if(line.equals("{")) {
					//"OFFICE_NAME":"",
					String p="\"DEPARTMENT_NAME\":\""+orgList.get(n)+"\",";
					String s="\"SUBJECT_NAME\":\""+subList.get(n)+"\",";
					String c="\"NAME\":\""+caseList.get(n)+"\",";
					line1=line1+line+p+s+c;
				}else {
					line1=line1+line;
				}
				
				if(line.equals("}") || line.equals("},")) {
					out.write(line1+"\r\n"); // \r\n即为换行
					System.out.println(line1);
					line1="";
					n++;
				}
			}
			out.flush(); // 把缓存区内容压入文件  
	        out.close(); // 最后记得关闭文件
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 读取结果数据文件
	 */
	public String txtRe2() {
		String r="[";
		String path=pathOut+"\\结果数据文件\\人员-机关主体案件.txt";
		try (BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(path),"UTF-8"));) {	        
			String line;
			int n=0;
			while ((line = br.readLine()) != null) {// 一次读入一行数据
				r=r+line;
				n++;
				if(n==10) {
					break;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		r=r.substring(0,r.length()-1);
		r=r+"]";
		return r;
	}
	
	
	/**
	 * 查执法人员的执法机关，根据执法人员ID，获取执法人员的执法机关名称
	 * @param id
	 * @return
	 */
	private String getOrg(String id) {
		// TODO Auto-generated method stub
		String org="";
		Connection conn=null;
		Statement  stmt=null;
		ResultSet  rst=null;
		OracleUtil db=new OracleUtil();
		try {
			conn=db.getConnection();
			String sql="select * from TBL_SYSTEM_ORGANIZATION o" + 
					" LEFT JOIN TBL_BASIC_ORGANIZATION_PERSON op on o.id=op.ORGANIZATION_ID" + 
					" where op.PERSON_ID='" + id +
					"' ORDER BY o.id " ;
		    stmt=conn.createStatement();
		    rst=stmt.executeQuery(sql);
		    while(rst.next()){
		    	String orgId=rst.getString("ID");
		    	String orgName=rst.getString("NAME");
		    	
		    	//多个时显示。。。
		    	if(0!=org.length()) {
		    		org = org+"...";
		    		break;
		    	}else {
		    		org = org+orgName;
		    	}
		    }
		} catch (SQLException e) {
			System.out.println("连接失败"+e);
			e.printStackTrace();
		}finally{
			db.closeAll(rst, stmt, conn);
		}
//		if(0!=peo.length()) {
//			peo=peo.substring(0, peo.length()-1);
//		}
		orgList.add(org);
		return org;
	}
	/**
	 * 查执法人员的执法主体，根据执法人员ID，获取执法人员的执法主体名称
	 * @param id
	 * @return
	 */
	private String getSub(String id) {
		// TODO Auto-generated method stub
		String sub="";
		Connection conn=null;
		Statement  stmt=null;
		ResultSet  rst=null;
		OracleUtil db=new OracleUtil();
		try {
			conn=db.getConnection();
			String sql="select * from TBL_BASIC_SUBJECT s" + 
					" LEFT JOIN TBL_BASIC_SUBJECT_PERSON sp on s.id=sp.SUBJECT_ID" + 
					" where sp.PERSON_ID='" + id +
					"' ORDER BY s.id " ;
		    stmt=conn.createStatement();
		    rst=stmt.executeQuery(sql);
		    while(rst.next()){
		    	String subId=rst.getString("ID");
		    	String subName=rst.getString("SUB_NAME");
		    	
		    	//多个时显示。。。
		    	if(0!=sub.length()) {
		    		sub = sub+"...";
		    		break;
		    	}else {
		    		sub = sub+subName;
		    	}
		    }
		} catch (SQLException e) {
			System.out.println("连接失败"+e);
			e.printStackTrace();
		}finally{
			db.closeAll(rst, stmt, conn);
		}
//		if(0!=sub.length()) {
//			sub=sub.substring(0, sub.length()-1);
//		}
		subList.add(sub);
		return sub;
	}
	/**
	 * 查执法人员的案件，根据执法人员ID，获取执法人员的案件名称
	 * @param id
	 * @return
	 */
	private String getCase(String id) {
		// TODO Auto-generated method stub
		String ca="";
		Connection conn=null;
		Statement  stmt=null;
		ResultSet  rst=null;
		OracleUtil db=new OracleUtil();
		try {
			conn=db.getConnection();
			String sql="select * from TBL_CASE_COMMON_STAFF st" + 
					" where st.IDENTITY_ID='" + id +
					"' ORDER BY st.case_id " ;
		    stmt=conn.createStatement();
		    rst=stmt.executeQuery(sql);
		    while(rst.next()){
		    	String caId=rst.getString("ID");
		    	String caName=rst.getString("CASE_ID");
		    	
		    	//多个时显示。。。
		    	if(0!=ca.length()) {
		    		ca = ca+"...";
		    		break;
		    	}else {
		    		ca = ca+caName;
		    	}
		    }
		} catch (SQLException e) {
			System.out.println("连接失败"+e);
			e.printStackTrace();
		}finally{
			db.closeAll(rst, stmt, conn);
		}
//		if(0!=ca.length()) {
//			ca=ca.substring(0, ca.length()-1);
//		}
		caseList.add(ca);
		return ca;
	}
	
	
}
