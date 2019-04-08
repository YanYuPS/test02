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

import com.config.OracleUtil;

public class TableOrgSer {

	ArrayList<String> peoList=new ArrayList<String>();
	ArrayList<String> subList=new ArrayList<String>();
	ArrayList<String> caseList=new ArrayList<String>();
	
	public static void main(String[] args) {
		
		TableOrgSer tableSer=new TableOrgSer();
		//将原始json的分行，改写成一行数据一行
		tableSer.txtRe();
		//获取99条数据的执法人员、执法主体、案件list
		tableSer.getList();
		//读取原始数据文件，将执法人员、执法主体、案件添加进去
		tableSer.txtRe1();
		
		//输出peoList
//		for(int i=0;i<tableSer.peoList.size();i++) {
//			System.out.println(i+"peo:"+tableSer.peoList.get(i));
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
 select * from TBL_SYSTEM_ORGANIZATION o
 where ROWNUM<100 ORDER BY o.id;
		 */
		String path="E:\\workspace\\eclipse\\原始数据文件\\机关-主体人员案件.txt";
		try (BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(path),"UTF-8"));) {
    
			File writename = new File("E:\\workspace\\eclipse\\中间结果数据文件\\机关-主体人员案件.txt"); 
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
	 * 获取99条数据的执法人员、执法主体、案件list
	 */
	public void getList() {
		String path="E:\\workspace\\eclipse\\中间结果数据文件\\机关-主体人员案件.txt";
		try (BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(path),"UTF-8"));) {
			String line;
			while ((line = br.readLine()) != null) {// 一次读入一行数据
				String pattern = "\"ID\":\"(.*?)\"";
			    Pattern r = Pattern.compile(pattern);
			    Matcher m = r.matcher(line);
			    if (m.find( )) {
//			    	System.out.println(m.group(1));
			       getPeo(m.group(1));
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
	 * 读取原始数据文件，将执法人员、执法主体、案件添加进去
	 */
	public void txtRe1() {
		String path="E:\\workspace\\eclipse\\原始数据文件\\机关-主体人员案件.txt";
		try (BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(path),"UTF-8"));) {
    
			File writename = new File("E:\\workspace\\eclipse\\结果数据文件\\机关-主体人员案件.txt"); 
	        writename.createNewFile(); // 创建新文件  
	        BufferedWriter out = new BufferedWriter(new FileWriter(writename));
	        
			String line;
			String line1="";
			int n=0;
			while ((line = br.readLine()) != null) {// 一次读入一行数据
				//替换
				//机关名称"NAME"--"DEPARTMENT_NAME"
				line=line.replace("\"NAME\"", "\"DEPARTMENT_NAME\"");
				if(line.equals("{")) {
					//"OFFICE_NAME":"",
					String p="\"OFFICE_NAME\":\""+peoList.get(n)+"\",";
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
	 * 查执法机关的执法人员，根据执法机关ID，获取执法机关的执法人员姓名
	 * @param id
	 * @return
	 */
	private String getPeo(String id) {
		// TODO Auto-generated method stub
		String peo="";
		Connection conn=null;
		Statement  stmt=null;
		ResultSet  rst=null;
		OracleUtil db=new OracleUtil();
		try {
			conn=db.getConnection();
			String sql="select * from TBL_BASIC_PERSON p" + 
					" LEFT JOIN TBL_BASIC_ORGANIZATION_PERSON op on p.id=op.PERSON_ID" + 
					" where op.ORGANIZATION_ID='" + id +
					"' ORDER BY p.id " ;
		    stmt=conn.createStatement();
		    rst=stmt.executeQuery(sql);
		    while(rst.next()){
		    	String peoId=rst.getString("ID");
		    	String peoName=rst.getString("NAME");
		    	
		    	//多个时显示。。。
		    	if(0!=peo.length()) {
		    		peo = peo+"...";
		    		break;
		    	}else {
		    		peo = peo+peoName;
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
		peoList.add(peo);
		return peo;
	}
	/**
	 * 查执法机关的执法主体，根据执法机关ID，获取执法机关的执法主体名称
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
					" LEFT JOIN TBL_BASIC_ORGANIZATION_SUBJECT os on s.id=os.SUBJECT_ID" + 
					" where os.ORGANIZATION_ID='" + id +
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
	 * 查执法机关的案件，根据执法机关ID，获取执法机关的案件名称
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
			String sql="select * from TBL_CASE_COMMON_BASIC c" + 
					" LEFT JOIN TBL_SYSTEM_ORGANIZATION o ON c.DEPARTMENT_ID=o.id" + 
					" where o.id='" + id +
					"' ORDER BY c.id " ;
		    stmt=conn.createStatement();
		    rst=stmt.executeQuery(sql);
		    while(rst.next()){
		    	String caId=rst.getString("ID");
		    	String caName=rst.getString("NAME");
		    	
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
