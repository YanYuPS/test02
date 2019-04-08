package com.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.config.OracleUtil;
import com.service.TxtSer;
import com.sun.corba.se.impl.oa.poa.ActiveObjectMap.Key;
 
public class caseDao {
	//year,month的list
	HashMap<String, Integer> mapNumYM=new HashMap<String, Integer>();
	HashMap<String, Integer> mapNumY=new HashMap<String, Integer>();
	public static void main(String[] args) {
        caseDao caseDao=new caseDao();
        TxtSer txtSer=new TxtSer();
        
//        //获取全部月份案件数
//        String name="case";
//        caseDao.getNumber(name);
//        
//        String path="E:\\workspace\\eclipse\\结果数据文件\\";
//        String yMonthNum="";
//        String yearNum="[";
//		for(int i=2007;i<2019;i++) {
//			String year=i+"";
//			String num=caseDao.getMonth(year);
//			System.out.println(i);//年：2008
////			System.out.println(num);//每个12个月的案件数：[3,2,3,1,1,3,0,1,3,3,1,0]
////			System.out.println(caseDao.getYearNum(year));//每年案件总数：21
//			yMonthNum=yMonthNum+i+"-"+num+"###";
//			yearNum=yearNum+caseDao.getYearNum(year)+",";
//		}
//		yMonthNum=yMonthNum.substring(0, yMonthNum.length()-3);
//		yearNum=yearNum.substring(0, yearNum.length()-1);
//		yearNum=yearNum+"]";
//		txtSer.txtWriMore(yMonthNum, path+"每年每月案件数.txt");//多行
//		txtSer.txtWri(yearNum, path+"2007-2019每年案件总数.txt");//一行
        
        
        //需要X个执法人员的案件个数
//        caseDao.txtWri();
        //执法机关处理的案件个数的执法机关数
//        caseDao.txtWriCD();
        
        
        System.out.println(caseDao.sgetYearName("casedep"));
        System.out.println(caseDao.sgetYear("casedep"));
	}
	
	public String sgetMonth(String year,String name) {
		String r="";
		HashMap<String, String> map=new HashMap<String, String>();
		TxtSer txtSer=new TxtSer();

		if(name.equalsIgnoreCase("case")) {
			String path="E:\\workspace\\eclipse\\结果数据文件\\每年每月案件数.txt";
			String num=txtSer.txtReMore(path);
			String[] ym=num.split("###");//获取每行数据
			for(int i=0;i<ym.length;i++) {
				String[] arr=ym[i].split("-");
				map.put(arr[0],arr[1]);//<年，每月案件数量>
			}
			r=map.get(year);
		}
		return r;
	}
	public String sgetYear(String name) {
		String r="";
		TxtSer txtSer=new TxtSer();
		if(name.equalsIgnoreCase("case")) {
			String path="E:\\workspace\\eclipse\\结果数据文件\\2007-2019每年案件总数.txt";
			r=txtSer.txtRe(path);
		}else if(name.equalsIgnoreCase("peocase")) {
			String path="E:\\workspace\\eclipse\\结果数据文件\\需要X个执法人员的案件个数.txt";
			r=txtSer.txtRe(path);
		}else if(name.equalsIgnoreCase("casedep")) {
			String path="E:\\workspace\\eclipse\\结果数据文件\\执法机关处理的案件个数的执法机关数.txt";
			r=txtSer.txtRe(path);
		}
		
		return r;
	}
	public String sgetYearName(String name) {
		String r="";
		TxtSer txtSer=new TxtSer();
		if(name.equalsIgnoreCase("case")) {
			String path="E:\\workspace\\eclipse\\结果数据文件\\2007-2019每年案件总数.txt";
			r=txtSer.txtReMore(path);
			r=r.substring(0,r.indexOf("###"));
		}else if(name.equalsIgnoreCase("peocase")) {
			String path="E:\\workspace\\eclipse\\结果数据文件\\需要X个执法人员的案件个数.txt";
			r=txtSer.txtReMore(path);
			r=r.substring(0,r.indexOf("###"));
		}else if(name.equalsIgnoreCase("casedep")) {
			String path="E:\\workspace\\eclipse\\结果数据文件\\执法机关处理的案件个数的执法机关数.txt";
			r=txtSer.txtReMore(path);
			r=r.substring(0,r.indexOf("###"));
		}
		
		return r;
	}	
	/**
	 * 人员-案件
	 */
	public void txtWri() {
		//需要X个执法人员的案件个数
        String pathFrom="E:\\workspace\\eclipse\\原始数据文件\\需要X个执法人员的案件个数.csv";
        String peoNum="[";//需要的执法人员数
        String caseNum="[";//案件个数

		try (BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(pathFrom),"UTF-8"));) {
	        String line;
			while ((line = br.readLine()) != null) {// 一次读入一行数据
				line=line.replace("\"", "");
				String[] arr=line.split(",");
				peoNum=peoNum+arr[0]+",";
				caseNum=caseNum+arr[1]+",";
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		peoNum=peoNum.substring(0,peoNum.length()-1);
		caseNum=caseNum.substring(0,caseNum.length()-1);
		peoNum=peoNum+"]";
		caseNum=caseNum+"]";
        
		String pathTo="E:\\workspace\\eclipse\\结果数据文件\\需要X个执法人员的案件个数.txt";
		 try { // 防止文件建立或读取失败，用catch捕捉错误并打印，也可以throw  
			 /* 写入Txt文件 */  
	        File writename = new File(pathTo); 
	        writename.createNewFile(); // 创建新文件  
	        BufferedWriter out = new BufferedWriter(new FileWriter(writename));  
	        out.write(peoNum+"\r\n"); // \r\n即为换行 
	        out.write(caseNum);
	        out.flush(); // 把缓存区内容压入文件  
	        out.close(); // 最后记得关闭文件  
	
	    } catch (Exception e) {  
	        e.printStackTrace();  
	    }  
	}
	/**
	 * 案件-机关
	 */
	public void txtWriCD() {
		//执法机关处理的案件个数的执法机关数
        String pathFrom="E:\\workspace\\eclipse\\原始数据文件\\执法机关处理的案件个数的执法机关数.csv";
        String caseNum="[";//
        String depNum="[";//

		try (BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(pathFrom),"UTF-8"));) {
	        String line;
			while ((line = br.readLine()) != null) {// 一次读入一行数据
				line=line.replace("\"", "");
				String[] arr=line.split(",");
				caseNum=caseNum+arr[0]+",";
				depNum=depNum+arr[1]+",";
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		caseNum=caseNum.substring(0,caseNum.length()-1);
		depNum=depNum.substring(0,depNum.length()-1);
		caseNum=caseNum+"]";
		depNum=depNum+"]";
        
		String pathTo="E:\\workspace\\eclipse\\结果数据文件\\执法机关处理的案件个数的执法机关数.txt";
		 try { // 防止文件建立或读取失败，用catch捕捉错误并打印，也可以throw  
			 /* 写入Txt文件 */  
	        File writename = new File(pathTo); 
	        writename.createNewFile(); // 创建新文件  
	        BufferedWriter out = new BufferedWriter(new FileWriter(writename));  
	        out.write(caseNum+"\r\n"); // \r\n即为换行 
	        out.write(depNum);
	        out.flush(); // 把缓存区内容压入文件  
	        out.close(); // 最后记得关闭文件  
	
	    } catch (Exception e) {  
	        e.printStackTrace();  
	    }  
	}
	
	public int getYearNum(String year) {
		Integer r=0;
		for(int i=1;i<=12;i++) {
			String key="";
			if(i<10) {
				key=year+"-0"+i;
			}else {
				key=year+"-"+i;
			}
			if(mapNumYM.containsKey(key)) {
				r+=mapNumYM.get(key);
			}
		}
		return r;
	}
	/**
	 * 根据年份获取月份
	 * @param year
	 * @param name
	 * @return
	 */
	public String getMonth(String year) {
		
		ArrayList<Integer> month=new ArrayList<Integer>();
		
		for(int i=1;i<=12;i++) {
			String key="";
			if(i<10) {
				key=year+"-0"+i;
			}else {
				key=year+"-"+i;
			}
			
			if(mapNumYM.containsKey(key)) {
				month.add(mapNumYM.get(key));
			}else {
				month.add(0);
			}
		}
		
		//拼接
		String r="[";
		StringBuffer sBuffer=new StringBuffer(r);
		for(int i=0;i<month.size();i++) {
			sBuffer.append(month.get(i)).append(",");
		}
		r=sBuffer.toString();
		r=r.substring(0,r.length()-1);
		r=r+"]";
		return r;
	}
	public String getYear(String name) {
		getNumber(name);
		
		
		//拼接
		String r="[";
		StringBuffer sBuffer=new StringBuffer(r);

		r=sBuffer.toString();
				r=r.substring(0,r.length()-1);
				r=r+"]";
				return r;
	}
	/**
	 * 读取数据库，获取数量
	 * @param year
	 * @return
	 */
	public void getNumber(String name) {
		if(name.equalsIgnoreCase("case")) {
			getYearAndMonth();
		}
		
	}
	/**
	 * 返回<年-月，数量>
	 * @return
	 */
	public void getYearAndMonth() {
		Connection conn=null;
		Statement  stmt=null;
		ResultSet  rst=null;
		OracleUtil db=new OracleUtil();
		try {
			conn=db.getConnection();
			String sql="select to_char(ENFORCEMENT_DATE,'yyyy-mm') datecase, count(id) countcase " + 
					" from TBL_CASE_COMMON_BASIC \r\n" + 
					" GROUP BY to_char(ENFORCEMENT_DATE,'yyyy-mm')\r\n" + 
					" ORDER BY to_char(ENFORCEMENT_DATE,'yyyy-mm')\r\n";

		    stmt=conn.createStatement();
		    rst=stmt.executeQuery(sql);
		    while(rst.next()){
		    	String datecase=rst.getString("datecase");
		    	int countcase=rst.getInt("countcase");
		    	
		    	mapNumYM.put(datecase, countcase);
		    }
		} catch (SQLException e) {
			//System.out.println("连接失败"+e);
			e.printStackTrace();
		}finally{
			db.closeAll(rst, stmt, conn);
		}
		System.out.println(mapNumYM);
	}
	public void getYear() {
		Connection conn=null;
		Statement  stmt=null;
		ResultSet  rst=null;
		OracleUtil db=new OracleUtil();
		try {
			conn=db.getConnection();
			String sql="select to_char(ENFORCEMENT_DATE,'yyyy') datecase, count(id) countcase " + 
					" from TBL_CASE_COMMON_BASIC \r\n" + 
					" GROUP BY to_char(ENFORCEMENT_DATE,'yyyy')\r\n" + 
					" ORDER BY to_char(ENFORCEMENT_DATE,'yyyy')\r\n";

		    stmt=conn.createStatement();
		    rst=stmt.executeQuery(sql);
		    while(rst.next()){
	    		String datecase=rst.getString("datecase");
		    	int countcase=rst.getInt("countcase");
		    	//if(datecase>"2008" && datecase<2019) {
			    	mapNumY.put(datecase, countcase);
		    	//}
		    }
		} catch (SQLException e) {
			//System.out.println("连接失败"+e);
			e.printStackTrace();
		}finally{
			db.closeAll(rst, stmt, conn);
		}
		System.out.println(mapNumY);
	}


	
	
	
}
