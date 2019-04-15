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

public class TableCaseSer {
	static String pathOut=StaticFile.PATH;
	
	ArrayList<String> peoList=new ArrayList<String>();
	ArrayList<String> gistList=new ArrayList<String>();
	ArrayList<String> powerList=new ArrayList<String>();
	
	public static void main(String[] args) {
		
		TableCaseSer tableSer=new TableCaseSer();
		//将原始json的分行，改写成一行数据一行
		tableSer.txtRe();
		//获取99条数据的执法人员、职权list
		tableSer.getList();
		//读取原始数据文件，将执法人员添加进去
		tableSer.txtRe1();
		
//		System.out.println(tableSer.txtRe2());
		
		//输出List
//		for(int i=0;i<tableSer.orgList.size();i++) {
//			System.out.println(i+"org:"+tableSer.orgList.get(i));
//		}
//		for(int i=0;i<tableSer.subList.size();i++) {
//			System.out.println(i+"sub:"+tableSer.subList.get(i));
//		}
//		for(int i=0;i<tableSer.caseList.size();i++) {
//			System.out.println(i+"case:"+tableSer.caseList.get(i));
//		}
		System.out.println("ok");
	}
	
	/**
	 * 将原始json的分行，改写成一行数据一行
	 */
	public void txtRe() {
		/**
		 * 导出json之后，删掉开头，改成txt
 select o.name DEPARTMENT_Name,s.SUB_NAME SUBJECT_Name,c.* from TBL_CASE_COMMON_BASIC c
 LEFT JOIN TBL_SYSTEM_ORGANIZATION o ON c.DEPARTMENT_ID=o.id
 LEFT JOIN TBL_BASIC_SUBJECT s on c.subject_id=s.id
 where ROWNUM<100 ORDER BY c.id;
		 */
		String path=pathOut+"\\原始数据文件\\案件-机关主体人员.txt";
		try (BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(path),"UTF-8"));) {
    
			File writename = new File(pathOut+"\\中间结果数据文件\\案件-机关主体人员.txt"); 
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
	 * 获取99条数据的执法人员list
	 */
	public void getList() {
		String path=pathOut+"\\中间结果数据文件\\案件-机关主体人员.txt";
		try (BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(path),"UTF-8"));) {
			String line;
			while ((line = br.readLine()) != null) {// 一次读入一行数据
				String pattern = "\"ID\":\"(.*?)\"";
			    Pattern r = Pattern.compile(pattern);
			    Matcher m = r.matcher(line);
			    if (m.find( )) {
			       getPeo(m.group(1));
			       getPower(m.group(1));
			    } else {
			       System.out.println("NO MATCH");
			    }
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	


	/**
	 * 读取原始数据文件，将执法人员添加进去
	 */
	public void txtRe1() {
		String path=pathOut+"\\原始数据文件\\案件-机关主体人员.txt";
		try (BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(path),"UTF-8"));) {
    
			File writename = new File(pathOut+"\\结果数据文件\\案件-机关主体人员.txt"); 
	        writename.createNewFile(); // 创建新文件  
	        BufferedWriter out = new BufferedWriter(new FileWriter(writename));
	        
			String line;
			String line1="";
			int n=0;
			while ((line = br.readLine()) != null) {// 一次读入一行数据
				if(line.equals("{")) {
					//"OFFICE_NAME":"",
					String p="\"OFFICE_NAME\":\""+peoList.get(n)+"\",";
					String o="\"POWER_NAME\":\""+powerList.get(n)+"\",";
					line1=line1+line+p+o;
				}else {
					line1=line1+line;
				}
				
				if(line.equals("}") || line.equals("},")) {
					out.write(line1+"\r\n"); // \r\n即为换行
//					System.out.println(line1);
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
		String path=pathOut+"\\结果数据文件\\案件-机关主体人员.txt";
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
	 * 查案件人员表，根据案件ID，获取案件的执法人员姓名
	 * @param caseId
	 * @return
	 */
	private String getPeo(String caseId) {
		// TODO Auto-generated method stub
		String peo="";
		Connection conn=null;
		Statement  stmt=null;
		ResultSet  rst=null;
		OracleUtil db=new OracleUtil();
		try {
			conn=db.getConnection();
			String sql="select * from TBL_CASE_COMMON_STAFF st " + 
					" where st.CASE_ID='" + caseId +
					"' ORDER BY st.IDENTITY_ID " ;

		    stmt=conn.createStatement();
		    rst=stmt.executeQuery(sql);
		    while(rst.next()){
		    	String id=rst.getString("IDENTITY_ID");
		    	String name=rst.getString("OFFICE_NAME");
		    	
		    	peo = peo+name+",";
		    }
		} catch (SQLException e) {
			System.out.println("连接失败"+e);
			e.printStackTrace();
		}finally{
			db.closeAll(rst, stmt, conn);
		}
		if(0!=peo.length()) {
			peo=peo.substring(0, peo.length()-1);
		}
		peoList.add(peo);
		return peo;
	}
	/**
	 * 查案件违法行为表，根据案件ID，获取案件的职权名称
	 * @param caseId
	 * @return
	 */
	private String getPower(String caseId) {
		// TODO Auto-generated method stub
		String power="";
		Connection conn=null;
		Statement  stmt=null;
		ResultSet  rst=null;
		OracleUtil db=new OracleUtil();
		try {
			conn=db.getConnection();
			String sql="select * from TBL_CASE_COMMON_POWER st " + 
					" where st.CASE_ID='" + caseId +
					"' ORDER BY st.POWER_ID " ;

		    stmt=conn.createStatement();
		    rst=stmt.executeQuery(sql);
		    while(rst.next()){
		    	String id=rst.getString("POWER_ID");
		    	String name=rst.getString("POWER_NAME");
		    	
		    	power = power+name+",";
		    }
		} catch (SQLException e) {
			System.out.println("连接失败"+e);
			e.printStackTrace();
		}finally{
			db.closeAll(rst, stmt, conn);
		}
		if(0!=power.length()) {
			power=power.substring(0, power.length()-1);
		}
		powerList.add(power);
		return power;		
	}
	
	
	
}
