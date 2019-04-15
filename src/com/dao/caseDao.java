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
import java.util.Date;

import com.bean.StaticFile;
import com.config.OracleUtil;
import com.service.TxtSer;

import jdk.internal.dynalink.beans.StaticClass;
 

/**
 * 统计图数据
 * 
 * 逻辑：
 *     一个球：纵轴球的数量，横轴时间
 *     两个球：纵轴第一个球的数量，横轴第二个球的数量
 *     三个球：纵轴第一个球的数量，横轴最后一个球的数量，第二个球横着堆柱子
 *     四个球：纵轴第一个球的数量，横轴最后一个球的数量，第二个球横着堆柱子，第三个球竖着堆柱子
 *     
 * mxxxxx：需要在main里运行的方法，用来采集数据库数据，逻辑处理后放到文件里
 * sgetxxxxx：接口调用的方法
 * txtWrixxxxx：写数据到‘结果数据文件’
 * getxxxxxFromDB：读数据库，一个球的数据
 * getxxxxx：逻辑处理
 * groupbyxxxxx：读数据库，两个球的数据
 * findby：度数据库，两个球的具体数据（具体：二次点击需要的数据）
 * 
 * @author zhaoyu
 *
 */
public class caseDao {
	/**
	 * <年-月，数量>
	 */
	HashMap<String, Integer> mapNumYM=new HashMap<String, Integer>();
	
//	StaticFile 
	static String pathOut=StaticFile.PATH;
	
	public static void main(String[] args) {
//        caseDao caseDao=new caseDao();      
        
        //一个球
//		mOne("处罚案件","2018");
//		mOne("执法人员","all");
//		mOne("执法机关","all");
//		mOne("执法主体","all");
//		mOne("职权","all");
//		mOne("法律法规","all");
        
        
        //两个球
//        mTwo("处罚案件-执法人员");
//        mTwo("执法人员-处罚案件");
//        mTwo("处罚案件-执法主体");
//        mTwo("执法主体-处罚案件");
//        mTwo("执法机关-处罚案件");
//        mTwo("处罚案件-执法机关");
//        mTwo("处罚案件-职权");       
//        mTwo("职权-处罚案件");
//        mTwo("处罚案件-法律法规");
//        mTwo("法律法规-处罚案件");

//        mTwo("法律法规-职权");  
//        mTwo("职权-法律法规");
//
//        mTwo("执法机关-执法人员");
//        mTwo("执法人员-执法机关");
//
//        mTwo("执法机关-执法主体");
//        mTwo("执法主体-执法机关");
//        
//        mTwo("执法人员-执法主体");
//        mTwo("执法主体-执法人员");
//
//        mTwo("职权-执法主体");
//        mTwo("执法主体-职权");
        
        //两个球--具体
//        mTwoDe("法律法规-职权"); 
//        mTwoDe("执法机关-执法人员");
//        mTwoDe("执法人员-执法机关");
//        mTwoDe("执法机关-执法主体");
//        mTwoDe("执法主体-执法机关");
//        mTwoDe("执法人员-执法主体");
//        mTwoDe("执法主体-执法人员");
//        mTwoDe("执法主体-职权");
		
		//两个球--属性
//		mTwoAtt("执法人员-性别");
//		mTwoAtt("执法人员-最高学历");
		
		//两个球--属性--具体
//		mTwoAttDe("执法人员-性别");
//		mTwoAttDe("执法人员-最高学历");
		
		//三个球
//		mThree("执法人员-性别-执法机关");
//		mThree("执法人员-最高学历-执法机关");

		
		System.out.println(pathOut);
        System.out.println("ok");
	}
	/**
	 * 一个球
	 * @param name
	 * @param year
	 */
	public static void mOne(String name,String year) {
		caseDao caseDao=new caseDao(); 
		
        caseDao.txtWriOne(name);//读数据库，写两个文件：一个每年具体月份的数据；一个年份+每年总数
        
        System.out.println(caseDao.sgetYearName(name));//读结果数据文件，获取横轴数据
        System.out.println(caseDao.sgetYear(name));//读结果数据文件，获取柱状图数据
        System.out.println(caseDao.sgetMonth(year, name));//读结果数据文件，获取每年具体数据
	}

	/**
	 * 两个球的组合
	 * @param name
	 */
	public static void mTwo(String name) {
		caseDao caseDao=new caseDao(); 
		
        caseDao.groupby(name);//读数据库，获取原始数据
        caseDao.txtWriTwo(name);//根据原始数据，拼接横轴数据和柱状图数据，写到结果数据文件
        
        System.out.println(caseDao.sgetYearName(name));//读结果数据文件，获取横轴数据
        System.out.println(caseDao.sgetYear(name));//读结果数据文件，获取柱状图数据
	}
	/**
	 * 两个球的组合,具体
	 * @param name
	 */
	public static void mTwoDe(String name) {
		caseDao caseDao=new caseDao(); 
		
        caseDao.txtWriTwoDetail(name);//读数据库，写到结果数据文件
        
        System.out.println(caseDao.sgetMonthName("8",name));//读结果数据文件，获取横轴数据
	}
	/**
	 * 两个球的组合--属性
	 * @param name
	 */
	public static void mTwoAtt(String name) {
		caseDao caseDao=new caseDao(); 
		
        caseDao.groupbyAtt(name);//读数据库，获取原始数据//////////////////////////////////////////////////////
        caseDao.txtWriTwo(name);//根据原始数据，拼接横轴数据和柱状图数据，写到结果数据文件
        
        System.out.println(caseDao.sgetYearName(name));//读结果数据文件，获取横轴数据
        System.out.println(caseDao.sgetYear(name));//读结果数据文件，获取柱状图数据
	}
	/**
	 * 两个球的组合--属性,具体
	 * @param name
	 */
	public static void mTwoAttDe(String name) {
		caseDao caseDao=new caseDao(); 
		
        caseDao.txtWriTwoDetailAtt(name);//读数据库，写到结果数据文件
        
        System.out.println(caseDao.sgetMonthName("0 ",name));//读结果数据文件，获取横轴数据
	}
	/**
	 * 三个球的组合
	 * @param name
	 */
	public static void mThree(String name) {
		caseDao caseDao=new caseDao(); 
		
        caseDao.groupbyThree(name);//读数据库，获取原始数据
        caseDao.txtWriThree(name);//根据原始数据，拼接横轴数据和柱状图数据，写到结果数据文件

        System.out.println(caseDao.sgetYearName(name));//读结果数据文件，获取横轴数据
        System.out.println(caseDao.sgetYear(name));//读结果数据文件，获取柱状图数据
        System.out.println(caseDao.sgetYearCate(name));//第三行
	}
	
	
	
	
	/**
	 * 一个球的月份数据
	 * @param year 具体的年份
	 * @param name 球的名字
	 * @return
	 */
	public String sgetMonth(String year,String name) {
		String r="";
		if(year.equalsIgnoreCase("all")) {
			return r;
		}
		HashMap<String, String> map=new HashMap<String, String>();//用来获取文件里的数据
		TxtSer txtSer=new TxtSer();
		
//		String path=pathOut+"\\结果数据文件\\E-"+name+"-细节.txt";
		String path=pathOut+"\\结果数据文件\\E-"+name+"-细节.txt";
		
		String num=txtSer.txtReMore(path);//结果：多行以###连接
		String[] ym=num.split("###");//获取每行数据
		for(int i=0;i<ym.length;i++) {
			String[] arr=ym[i].split("-");
			map.put(arr[0],arr[1]);//<年，每月案件数量>
		}
		r=map.get(year);

		return r;
	}
	/**
	 * 两个球的‘月份’（例如：机关的名字）
	 * @param year 具体的‘年份’（例如：有2个人员的机关，year='2'）
	 * @param name 球的名字
	 * @return
	 */
	public String sgetMonthName(String year,String name) {
		String r="";

		HashMap<String, String> map=new HashMap<String, String>();//用来获取文件里的数据
		TxtSer txtSer=new TxtSer();
		
		String path=pathOut+"\\结果数据文件\\E-"+name+"-细节.txt";
		
		String num=txtSer.txtReMore(path);//结果：多行以###连接
		String[] ym=num.split("###");//获取每行数据
		for(int i=0;i<ym.length;i++) {
			String[] arr=ym[i].split("-");
			map.put(arr[0],arr[1]);//例如：<人员数量，具体执法机关名字[]>
		}
		r=map.get(year);

		return r;
	}

	/**
	 * 两个球的柱状图数据，一个球的年份数据，三个球的柱状图数据（文件第二行：数据）
	 * @param name
	 * @return
	 */
	public String sgetYear(String name) {
		String r="";
		TxtSer txtSer=new TxtSer();
		
		String path=pathOut+"\\结果数据文件\\E-"+name+".txt";
		r=txtSer.txtReN(path,2);
		return r;
	}
	/**
	 * 两个球的横轴，一个球的横轴年份，三个球的横轴（文件第一行：横轴）
	 * @param name
	 * @return
	 */
	public String sgetYearName(String name) {
		String r="";
		TxtSer txtSer=new TxtSer();

		String path=pathOut+"\\结果数据文件\\E-"+name+".txt";
		r=txtSer.txtReN(path,1);
		return r;
	}
	/**
	 * 三个球的类别（文件第三行：类别）
	 * @param name
	 * @return
	 */
	public String sgetYearCate(String name) {
		String r="";
		TxtSer txtSer=new TxtSer();

		String path=pathOut+"\\结果数据文件\\E-"+name+".txt";
		r=txtSer.txtReN(path,3);
		return r;
	}

	
	/**
	 * 三个球：根据原始数据，拼接横轴数据和柱状图数据，写到结果数据文件
	 * @param name
	 */
	public void txtWriThree(String name) {
        String pathFrom=pathOut+"\\原始数据文件\\E-"+name+".csv";
        String num1="[";//横轴
        String num2="[";//数据 [[ ], [ ], [ ]]
        String num3="[";//类别 [ ]
        
        StringBuffer num1B=new StringBuffer(num1);
        StringBuffer num2B=new StringBuffer(num2);
        StringBuffer num3B=new StringBuffer(num3);

		try (BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(pathFrom),"UTF-8"));) {
	        String line;
	        int n=0;
			while ((line = br.readLine()) != null) {// 一次读入一行数据
				n++;//行数
				//"北京市","0 ","0","1 ","1","2 ","0"
				line=line.replace("\"", "");
				String[] arr=line.split(",");

				num1B.append("\"").append(arr[0]).append("\",");
				
				num2B.append("[");
				for(int i=1;i<arr.length;i=i+2) {
					num2B.append("\"").append(arr[i+1]).append("\",");
					if(1==n) {//第一行
						num3B.append("\"").append(arr[i]).append("\",");
					}
				}
				num2B.setLength(num2B.length()-1);
				num2B.append("],");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		num1=num1B.toString();
		num2=num2B.toString();
		num3=num3B.toString();
		num1=num1.substring(0,num1.length()-1);
		num2=num2.substring(0,num2.length()-1);
		num3=num3.substring(0,num3.length()-1);
		num1=num1+"]";
		num2=num2+"]";
		num3=num3+"]";
        
		String pathTo=pathOut+"\\结果数据文件\\E-"+name+".txt";
		 try { // 防止文件建立或读取失败，用catch捕捉错误并打印，也可以throw  
			 /* 写入Txt文件 */  
	        File writename = new File(pathTo); 
	        writename.createNewFile(); // 创建新文件  
	        BufferedWriter out = new BufferedWriter(new FileWriter(writename));  
	        out.write(num1+"\r\n"); // \r\n即为换行 
	        out.write(num2+"\r\n");
	        out.write(num3);
	        out.flush(); // 把缓存区内容压入文件  
	        out.close(); // 最后记得关闭文件  
	
	    } catch (Exception e) {  
	        e.printStackTrace();  
	    }  
	}

	/**
	 * 两个球：根据原始数据，拼接横轴数据和柱状图数据，写到结果数据文件
	 * @param name
	 */
	public void txtWriTwo(String name) {
        String pathFrom=pathOut+"\\原始数据文件\\E-"+name+".csv";
        String num1="[";//横轴
        String num2="[";//数据

		try (BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(pathFrom),"UTF-8"));) {
	        String line;
			while ((line = br.readLine()) != null) {// 一次读入一行数据
				line=line.replace("\"", "");
				String[] arr=line.split(",");
				num1=num1+arr[0]+",";
				num2=num2+arr[1]+",";
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		num1=num1.substring(0,num1.length()-1);
		num2=num2.substring(0,num2.length()-1);
		num1=num1+"]";
		num2=num2+"]";
        
		String pathTo=pathOut+"\\结果数据文件\\E-"+name+".txt";
		 try { // 防止文件建立或读取失败，用catch捕捉错误并打印，也可以throw  
			 /* 写入Txt文件 */  
	        File writename = new File(pathTo); 
	        writename.createNewFile(); // 创建新文件  
	        BufferedWriter out = new BufferedWriter(new FileWriter(writename));  
	        out.write(num1+"\r\n"); // \r\n即为换行 
	        out.write(num2);
	        out.flush(); // 把缓存区内容压入文件  
	        out.close(); // 最后记得关闭文件  
	
	    } catch (Exception e) {  
	        e.printStackTrace();  
	    }  
	}

	/**
	 * 一个球的数据（年份+月份数量）
	 * 写两个文件：一个每年具体月份的数据；一个年份+每年总数
	 * @param name
	 */
	public void txtWriOne(String name) {
		TxtSer txtSer=new TxtSer();
		//获取当前年份
		Date date=new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy");
		int yearNow=Integer.parseInt(df.format(date));
        
        String path=pathOut+"\\结果数据文件\\E-";
        String yMonthNum="";
        String year="[";
        String yearNum="[";

		if(name.equals("处罚案件")) {
			getYMNumFromDB(name);//读取数据库，获取全部<年-月，数量>
		}else {
			//没有日期的
			getAllNumFromDB(name);//读取数据库，获取<all，数量>
			String key="all";
			txtSer.txtWriMore("[\""+key+"\"]"+"###"+"["+mapNumYM.get(key)+"]", path+name+".txt");//两行（行与行之间###连接）			
			return;
		}

        //只展示过去15年的数据
		for(int i=yearNow-15;i<=yearNow;i++) {
			String num=getMonthNum(i);//[1,22,12,11]--(12个月的数量)
			yMonthNum=yMonthNum+i+"-"+num+"###";//每行数据：2019-[22,11,23,23]
			
			year=year+i+",";
        	yearNum=yearNum+getYearSum(i)+",";
		}
		yMonthNum=yMonthNum.substring(0, yMonthNum.length()-3);
		year=year.substring(0, year.length()-1)+"]";
		yearNum=yearNum.substring(0, yearNum.length()-1)+"]";
      
		txtSer.txtWriMore(yMonthNum, path+name+"-细节.txt");//多行（行与行之间###连接）
		txtSer.txtWriMore(year+"###"+yearNum, path+name+".txt");//两行（行与行之间###连接）
	}

	/**
	 * 根据年份，获取当年总数（每月相加）
	 * @param year
	 * @return
	 */
	private int getYearSum(int year) {
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
	 * @return [1,22,12,11]--(12个月的数量)
	 */
	private String getMonthNum(int year) {
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

	/**
	 * 读取数据库，获取数量
	 * @param name 一个球的名字（例如：处罚案件）
	 * @return 返回<年-月，数量>
	 */
	private void getYMNumFromDB(String name) {
		Connection conn=null;
		Statement  stmt=null;
		ResultSet  rst=null;
		OracleUtil db=new OracleUtil();
		
		String tableName="";
		String fieldDate="";
		String fieldCount="";
		if(name.equals("处罚案件")) {
			tableName="TBL_CASE_COMMON_BASIC";
			fieldDate="ENFORCEMENT_DATE";//日期
			fieldCount="id";//count(fieldCount)
		}
		
		try {
			conn=db.getConnection();
			String sql="select to_char("+fieldDate+",'yyyy-mm') d, count("+fieldCount+") c " + 
					" from "+tableName + 
					" GROUP BY to_char("+fieldDate+",'yyyy-mm')" + 
					" ORDER BY to_char("+fieldDate+",'yyyy-mm')";

		    stmt=conn.createStatement();
		    rst=stmt.executeQuery(sql);
		    while(rst.next()){
		    	String date=rst.getString("d");
		    	int count=rst.getInt("c");
		    	
		    	mapNumYM.put(date, count);
		    }
		} catch (SQLException e) {
			//System.out.println("连接失败"+e);
			e.printStackTrace();
		}finally{
			db.closeAll(rst, stmt, conn);
		}
//		System.out.println(mapNumYM);
	}
	/**
	 * 读取数据库，获取数量（没有日期）
	 * @param name 一个球的名字（例如：处罚案件）
	 * @return 返回<年-月，数量>
	 */
	private void getAllNumFromDB(String name) {
		Connection conn=null;
		Statement  stmt=null;
		ResultSet  rst=null;
		OracleUtil db=new OracleUtil();
		
		String tableName="";
		String fieldCount="";
		if(name.equals("执法人员")) {
			tableName="TBL_BASIC_PERSON"
					+ " where IS_DELETE='0' and PERSON_TYPE='01'";
			fieldCount="id";
		}else if(name.equals("执法机关")) {
			tableName="TBL_SYSTEM_ORGANIZATION" + 
					" where IS_DELETE='0' and IS_STOP='0' and IS_SUPERVISE='0'";
			fieldCount="id";
		}else if(name.equals("执法主体")) {
			tableName="TBL_BASIC_SUBJECT" + 
					" where IS_DELETE='0' and IS_DEPUTE='0'";
			fieldCount="id";
		}else if(name.equals("职权")) {
			tableName="TBL_POWER_LIST" + 
					" where IS_DELETE='0' ";
			fieldCount="id";
		}else if(name.equals("法律法规")) {//名字
			tableName="TBL_BASIC_GIST" + 
					" where IS_DELETE='0' ";
			fieldCount="DISTINCT(LAW_NAME)";
		}
		
		try {
			conn=db.getConnection();
			String sql="select count("+fieldCount+") c" + 
					" from "+tableName ;

		    stmt=conn.createStatement();
		    rst=stmt.executeQuery(sql);
		    while(rst.next()){
		    	String date="all";
		    	int count=rst.getInt("c");
		    	
		    	mapNumYM.put(date, count);
		    }
		} catch (SQLException e) {
			//System.out.println("连接失败"+e);
			e.printStackTrace();
		}finally{
			db.closeAll(rst, stmt, conn);
		}
		System.out.println(mapNumYM);
	}
	
	/**
	 * 统计图的查询(两个组合)
	 */
	private void groupby(String name) {
		Connection conn=null;
		Statement  stmt=null;
		ResultSet  rst=null;
		OracleUtil db=new OracleUtil();

		String tableName="";
//		String tableName1="";
		String fieldId1="";
		String fieldId2="";
		if(name.equals("处罚案件-执法人员")) {
			tableName="TBL_CASE_COMMON_STAFF";//案件的执法人员表
			fieldId1="CASE_ID";//案件id
			fieldId2="IDENTITY_ID";//人员id
		}else if(name.equals("执法人员-处罚案件")) {
			tableName="TBL_CASE_COMMON_STAFF";//案件的执法人员表
			fieldId1="IDENTITY_ID";//
			fieldId2="CASE_ID";//
		}else if(name.equals("执法主体-处罚案件")) {
			tableName="TBL_CASE_COMMON_BASIC";//处罚一般案件表
			fieldId1="SUBJECT_ID";//
			fieldId2="ID";//
		}else if(name.equals("处罚案件-执法主体")) {
			tableName="TBL_CASE_COMMON_BASIC";//处罚一般案件表
			fieldId1="ID";//
			fieldId2="SUBJECT_ID";//
		}else if(name.equals("执法机关-处罚案件")) {
			tableName="TBL_CASE_COMMON_BASIC";//处罚一般案件表
			fieldId1="DEPARTMENT_ID";//
			fieldId2="ID";//
		}else if(name.equals("处罚案件-执法机关")) {
			tableName="TBL_CASE_COMMON_BASIC";//处罚一般案件表
			fieldId1="ID";//
			fieldId2="DEPARTMENT_ID";//
		}else if(name.equals("处罚案件-职权")) {
			tableName="TBL_CASE_COMMON_POWER";//
			fieldId1="CASE_ID";//
			fieldId2="POWER_ID";//
		}else if(name.equals("职权-处罚案件")) {
			tableName="TBL_CASE_COMMON_POWER";//
			fieldId1="POWER_ID";//
			fieldId2="CASE_ID";//
		}else if(name.equals("处罚案件-法律法规")) {
			tableName="(select c.case_id,g.LAW_NAME from TBL_CASE_COMMON_GIST c" + 
					" LEFT JOIN TBL_BASIC_GIST g on c.GIST_ID=g.id) ";//
//			tableName1="(select c.case_id,g.LAW_NAME from TBL_CASE_COMMON_PUNISH c" + 
//					" LEFT JOIN TBL_BASIC_GIST g on c.GIST_ID=g.id) ";//暂时没用~~~
			fieldId1="case_id";//
			fieldId2="LAW_NAME";//
		}else if(name.equals("法律法规-处罚案件")) {
			tableName="(select c.case_id,g.LAW_NAME from TBL_CASE_COMMON_GIST c" + 
					" LEFT JOIN TBL_BASIC_GIST g on c.GIST_ID=g.id) ";//
//			tableName1="(select c.case_id,g.LAW_NAME from TBL_CASE_COMMON_PUNISH c" + 
//					" LEFT JOIN TBL_BASIC_GIST g on c.GIST_ID=g.id) ";//暂时没用~~~
			fieldId1="LAW_NAME";//
			fieldId2="case_id";//
		}

		else if(name.equals("法律法规-职权")) {
			tableName="TBL_BASIC_GIST";//
			fieldId1="LAW_NAME";//
			fieldId2="POWER_ID";//
		}else if(name.equals("职权-法律法规")) {
			tableName="TBL_BASIC_GIST";//
			fieldId1="POWER_ID";//
			fieldId2="LAW_NAME";//
		}else if(name.equals("执法机关-执法人员")) {
			tableName="TBL_BASIC_ORGANIZATION_PERSON";//
			fieldId1="ORGANIZATION_ID";//
			fieldId2="PERSON_ID";//
		}else if(name.equals("执法人员-执法机关")) {
			tableName="TBL_BASIC_ORGANIZATION_PERSON";//
			fieldId1="PERSON_ID";//
			fieldId2="ORGANIZATION_ID";//
		}else if(name.equals("执法机关-执法主体")) {
			tableName="TBL_BASIC_ORGANIZATION_SUBJECT";//
			fieldId1="ORGANIZATION_ID";//
			fieldId2="SUBJECT_ID";//
		}else if(name.equals("执法主体-执法机关")) {
			tableName="TBL_BASIC_ORGANIZATION_SUBJECT";//
			fieldId1="SUBJECT_ID";//
			fieldId2="ORGANIZATION_ID";//
		}else if(name.equals("执法人员-执法主体")) {
			tableName="TBL_BASIC_SUBJECT_PERSON";//
			fieldId1="PERSON_ID";//
			fieldId2="SUBJECT_ID";//
		}else if(name.equals("执法主体-执法人员")) {
			tableName="TBL_BASIC_SUBJECT_PERSON";//
			fieldId1="SUBJECT_ID";//
			fieldId2="PERSON_ID";//
		}else if(name.equals("职权-执法主体")) {
			tableName="TBL_BASIC_SUBJECT_POWER";//
			fieldId1="POWER_ID";//
			fieldId2="SUBJECT_ID";//
		}else if(name.equals("执法主体-职权")) {
			tableName="TBL_BASIC_SUBJECT_POWER";//
			fieldId1="SUBJECT_ID";//
			fieldId2="POWER_ID";//
		}
		
		try {
			conn=db.getConnection();
			String sql="select B.num2,count(B.id) num1 from " + 
					" (" + 
					" select count(DISTINCT(A."+fieldId2+")) num2,A."+fieldId1+" id" + 
					" from "+tableName+" A" + 
					" GROUP BY A."+fieldId1 + 
					" ) B" + 
					" GROUP BY B.num2" + 
					" ORDER BY B.num2";
		    stmt=conn.createStatement();
		    rst=stmt.executeQuery(sql);
		    
		    String path=pathOut+"\\原始数据文件\\E-"+name+".csv";
		    File writename = new File(path); 
	        writename.createNewFile(); // 创建新文件  
	        BufferedWriter out = new BufferedWriter(new FileWriter(writename));  
	        
		    while(rst.next()){
		    	int num1=rst.getInt("num1");
		    	int num2=rst.getInt("num2");

		    	
		    	//"2","1341961" 执法人员数量，案件数量
		    	out.write("\""+num2+"\",\""+num1+"\"\r\n");  
		    }
		    
		    out.flush();
	        out.close(); 
		    
		} catch (SQLException e) {
			//System.out.println("连接失败"+e);
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();  
		}finally{
			db.closeAll(rst, stmt, conn);
		}
	}
	
	/**
	 * 统计图的查询(三个组合)
	 */
	private void groupbyThree(String name) {
		Connection conn=null;
		Statement  stmt=null;
		ResultSet  rst=null;
		ResultSet  rstCa=null;
		OracleUtil db=new OracleUtil();

		String tableName1="";
		String tableName2="";
		String tableName3="";
		String field11="";
		String field12="";
		String field21="";
		String field22="";
		String field31="";
		String field32="";
		if(name.equals("执法人员-性别-执法机关")) {
			tableName1="TBL_BASIC_ORGANIZATION_PERSON";
			tableName2="TBL_SYSTEM_ORGANIZATION";
			tableName3="TBL_BASIC_PERSON";
			field11="ORGANIZATION_ID";
			field12="person_id";
			field21="name";
			field22="ID";
			field31="sex";
			field32="ID";
		}else if(name.equals("执法人员-最高学历-执法机关")) {
			tableName1="TBL_BASIC_ORGANIZATION_PERSON";
			tableName2="TBL_SYSTEM_ORGANIZATION";
			tableName3="TBL_BASIC_PERSON";
			field11="ORGANIZATION_ID";
			field12="person_id";
			field21="name";
			field22="ID";
			field31="EDUCATION";
			field32="ID";
		}
		
		try {
			conn=db.getConnection();
			stmt=conn.createStatement();
			
			ArrayList<String> cateList=new ArrayList<String>();
			ArrayList<String> numList=new ArrayList<String>();
			String sqlCa="select C."+field31+" cate from "+tableName3+" C " + 
					" group by C."+field31 + 
					" ORDER BY C."+field31;
		    rstCa=stmt.executeQuery(sqlCa);
		    while(rstCa.next()){
		    	String cate=rstCa.getString("cate");
		    	if(null==cate || cate.equals("") || cate.equals(" ") || cate.equals("null")) {
		    		cate="  ";
		    	}
		    	cateList.add(cate);
		    	numList.add("0");
		    }
		    
			String sql="select B."+field21+" name,C."+field31+" cate,count(A."+field12+") num from "+tableName1+" A " + 
					" LEFT JOIN "+tableName2+" B ON A."+field11+"=B."+field22 + 
					" LEFT JOIN "+tableName3+" C ON A."+field12+"=C."+field32 + 
					" group by B."+field21+",C."+field31 + 
					" ORDER BY B."+field21+",C."+field31;
		    rst=stmt.executeQuery(sql);
		    
		    String path=pathOut+"\\原始数据文件\\E-"+name+".csv";
		    File writename = new File(path); 
	        writename.createNewFile(); // 创建新文件  
	        BufferedWriter out = new BufferedWriter(new FileWriter(writename));  
	        
	        String naStr="";
	        StringBuffer outSB=new StringBuffer();
	        //拼接结果："北京市","0 ","0","1 ","1","2 ","176"
		    while(rst.next()){
		    	String na=rst.getString("name");
		    	String cate=rst.getString("cate");
		    	int num=rst.getInt("num");
		    	
		    	//类别为空，不填
		    	if(null==cate || cate.equalsIgnoreCase("null") || cate.equals("")) {
		    		continue;
		    	}
		    	
		    	if(!naStr.equals(na)) {
		    		if(!naStr.equals("")) {
		    			for(int i=0;i<cateList.size();i++) {
		    				outSB.append("\"").append(cateList.get(i)).append("\",")
			    			.append("\"").append(numList.get(i)).append("\",");
		    				
		    				numList.set(i, "0");
		    			}
		    			out.write(outSB.toString().substring(0,outSB.toString().length()-1)
		    					+"\r\n");
		    			outSB.setLength(0);
		    		}
		    		
		    		naStr=na;
		    		outSB.append("\"").append(naStr).append("\",");
		    	}
		    	for(int i=0;i<cateList.size();i++) {
		    		if(cateList.get(i).equals(cate)) {
			    		numList.set(i, num+"");
			    	}
		    	}
		    }
		    
		    out.flush();
	        out.close(); 
		    
		} catch (SQLException e) {
			//System.out.println("连接失败"+e);
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();  
		}finally{
			db.closeAll(rst, stmt, conn);
		}
	}

	/**
	 * 统计图的查询(两个组合)--属性
	 */
	private void groupbyAtt(String name) {
		Connection conn=null;
		Statement  stmt=null;
		ResultSet  rst=null;
		OracleUtil db=new OracleUtil();

		String tableName="";
		String fieldId1="";
		String fieldId2="";
		if(name.equals("执法人员-性别")) {
			tableName="TBL_BASIC_PERSON"//执法人员表
					+ " where IS_DELETE='0' and PERSON_TYPE='01' ";
			fieldId1="name";
			fieldId2="sex";
		}else if(name.equals("执法人员-最高学历")) {
			tableName="TBL_BASIC_PERSON"//执法人员表
					+ " where IS_DELETE='0' and PERSON_TYPE='01' ";
			fieldId1="name";
			fieldId2="EDUCATION";
		}
		
		try {
			conn=db.getConnection();
			String sql="select count("+fieldId1+") num,"+fieldId2+" na" + 
					" from "+tableName + 
					" GROUP BY "+fieldId2+" ORDER BY "+fieldId2;
		    stmt=conn.createStatement();
		    rst=stmt.executeQuery(sql);
		    
		    String path=pathOut+"\\原始数据文件\\E-"+name+".csv";
		    File writename = new File(path); 
	        writename.createNewFile(); // 创建新文件  
	        BufferedWriter out = new BufferedWriter(new FileWriter(writename));  
	        
		    while(rst.next()){
		    	int num=rst.getInt("num");
		    	String na=rst.getString("na");
		    	
		    	if(null==na || na.equals("") || na.equals(" ") || na.equals("null")
		    			|| na.equals("\\")) {
		    		na="  ";
		    	}
		    	
		    	//"2","1341961" 执法人员数量，案件数量
		    	out.write("\""+na+"\",\""+num+"\"\r\n");  
		    }
		    
		    out.flush();
	        out.close(); 
		    
		} catch (SQLException e) {
			//System.out.println("连接失败"+e);
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();  
		}finally{
			db.closeAll(rst, stmt, conn);
		}
	}
	/**
	 * 写文件--例如：具体的机关名字
	 * @param name
	 */
	public void txtWriTwoDetail(String name) {
		TxtSer txtSer=new TxtSer();
		
		String path1=pathOut+"\\结果数据文件\\E-"+name+".txt";
		String[] ym=txtSer.txtReMore(path1).split("###");//获取每行数据
		String num=ym[0];//第一行[1,2,3,4,5,6,7]
		num=num.replace("[", "").replace("]", "");
		String[] numArr=num.split(",");
		
		try {
		    String path=pathOut+"\\结果数据文件\\E-"+name+"-细节.txt";
		    File writename = new File(path); 
	        writename.createNewFile(); // 创建新文件  
	        BufferedWriter out = new BufferedWriter(new FileWriter(writename));  
	
	        String na="[]";
			for(int i=0;i<numArr.length;i++) {
				na=findByNum2(name, numArr[i]);
				out.write(numArr[i]+"-"+na+"\r\n");//2-["name1","name2","name3"]
//				System.out.println(numArr[i]+"-"+na);
			}
			
		    out.flush();
	        out.close(); 
		}catch (Exception e) {
			e.printStackTrace();  
		}
	}
	/**
	 * 统计图的查询(两个组合)---具体
	 * @param name
	 * @param num2
	 * @return ["name1","name2","name3"]
	 */
	private String findByNum2(String name,String num2) {
		String r="[";
		StringBuffer rsb=new StringBuffer(r);
		Connection conn=null;
		Statement  stmt=null;
		ResultSet  rst=null;
		OracleUtil db=new OracleUtil();

		String tableName1="";
		String tableName2="";

		String fieldId11="";
		String fieldId12="";
		String fieldId21="";
		String fieldId22="";
		
		if(name.equals("处罚案件-执法人员")) {
//			tableName1="TBL_CASE_COMMON_STAFF";//案件的执法人员表
//			tableName2="TBL_CASE_COMMON_BASIC";//案件表
//			fieldId11="CASE_ID";//案件id
//			fieldId12="IDENTITY_ID";//人员id
//			fieldId21="ID";//案件id--关联
//			fieldId22="NAME";//案件名称
		}else if(name.equals("执法人员-处罚案件")) {
//			tableName1="TBL_CASE_COMMON_STAFF";
//			tableName2="TBL_BASIC_PERSON";
//			fieldId11="IDENTITY_ID";
//			fieldId12="CASE_ID";
//			fieldId21="ID";
//			fieldId22="NAME";
		}else if(name.equals("执法主体-处罚案件")) {
		}else if(name.equals("处罚案件-执法主体")) {
		}else if(name.equals("执法机关-处罚案件")) {
		}else if(name.equals("处罚案件-执法机关")) {
		}else if(name.equals("处罚案件-职权")) {
		}else if(name.equals("职权-处罚案件")) {
		}else if(name.equals("处罚案件-法律法规")) {
		}

		else if(name.equals("职权-法律法规")) {
		}
		
		else if(name.equals("执法机关-执法人员")) {
			tableName1="TBL_BASIC_ORGANIZATION_PERSON";
			tableName2="TBL_SYSTEM_ORGANIZATION";
			fieldId11="ORGANIZATION_ID";
			fieldId12="PERSON_ID";
			fieldId21="ID";
			fieldId22="NAME";
		}else if(name.equals("执法人员-执法机关")) {
			tableName1="TBL_BASIC_ORGANIZATION_PERSON";
			tableName2="TBL_BASIC_PERSON";
			fieldId11="PERSON_ID";
			fieldId12="ORGANIZATION_ID";
			fieldId21="ID";
			fieldId22="NAME";
		}else if(name.equals("执法机关-执法主体")) {
			tableName1="TBL_BASIC_ORGANIZATION_SUBJECT";
			tableName2="TBL_SYSTEM_ORGANIZATION";
			fieldId11="ORGANIZATION_ID";
			fieldId12="SUBJECT_ID";
			fieldId21="ID";
			fieldId22="NAME";
		}else if(name.equals("执法主体-执法机关")) {
			tableName1="TBL_BASIC_ORGANIZATION_SUBJECT";
			tableName2="TBL_BASIC_SUBJECT";
			fieldId11="SUBJECT_ID";
			fieldId12="ORGANIZATION_ID";
			fieldId21="ID";
			fieldId22="sub_name";
		}else if(name.equals("执法人员-执法主体")) {
			tableName1="TBL_BASIC_SUBJECT_PERSON";
			tableName2="TBL_BASIC_PERSON";
			fieldId11="PERSON_ID";
			fieldId12="SUBJECT_ID";
			fieldId21="ID";
			fieldId22="NAME";
		}else if(name.equals("执法主体-执法人员")) {
			tableName1="TBL_BASIC_SUBJECT_PERSON";
			tableName2="TBL_BASIC_SUBJECT";
			fieldId11="SUBJECT_ID";
			fieldId12="PERSON_ID";
			fieldId21="ID";
			fieldId22="sub_name";
		}
		
		else if(name.equals("职权-执法主体")) {
//			tableName1="TBL_BASIC_SUBJECT_POWER";
//			tableName2="TBL_POWER_LIST";
//			fieldId11="POWER_ID";
//			fieldId12="SUBJECT_ID";
//			fieldId21="ID";
//			fieldId22="NAME";
		}else if(name.equals("执法主体-职权")) {
			tableName1="TBL_BASIC_SUBJECT_POWER";
			tableName2="TBL_BASIC_SUBJECT";
			fieldId11="SUBJECT_ID";
			fieldId12="POWER_ID";
			fieldId21="ID";
			fieldId22="sub_name";
		}
		
		try {
			conn=db.getConnection();
			String sql="select C.num2,D."+fieldId22+" name from (" + 
					" select B.num2,B.id id from " + 
					" (select count(DISTINCT(A."+fieldId12+")) num2,A."+fieldId11+" id " + 
							"from "+tableName1+" A GROUP BY A."+fieldId11+") B" + 
					" where B.num2 = '"+num2+"'" + 
					") C LEFT JOIN "+tableName2+" D on C.id=D."+fieldId21;

			if(name.equals("法律法规-职权")) {
				tableName1="TBL_BASIC_GIST";
				fieldId11="LAW_NAME";
				fieldId12="POWER_ID";
				sql="select B.num2,B.id name from " + 
					" (select count(DISTINCT(A."+fieldId12+")) num2,A."+fieldId11+" id " + 
						"from "+tableName1+" A GROUP BY A."+fieldId11+") B" + 
					" where B.num2 = '"+num2+"'" ;
			}else if(name.equals("法律法规-处罚案件")) {
//				tableName1="(select c.case_id,g.LAW_NAME from TBL_CASE_COMMON_GIST c" + 
//						" LEFT JOIN TBL_BASIC_GIST g on c.GIST_ID=g.id) ";
//				fieldId11="LAW_NAME";
//				fieldId12="case_id";
//				sql="select B.num2,B.id name from " + 
//					" (select count(DISTINCT(A."+fieldId12+")) num2,A."+fieldId11+" id " + 
//						"from "+tableName1+" A GROUP BY A."+fieldId11+") B" + 
//					" where B.num2 = '"+num2+"'" ;
			}
			
			
		    stmt=conn.createStatement();
		    rst=stmt.executeQuery(sql);
	        
		    while(rst.next()){
		    	String na=rst.getString("name"); 
		    	if(null==na || na.equals("") || na.equals(" ") || na.equals("null")
		    			|| na.equals("\\")) {
		    		rsb.append("\"\",");
		    	}else {
		    		na.replace("\"", "'");
		    		rsb.append("\"").append(na).append("\",");
		    	}
		    }
		} catch (SQLException e) {
			//System.out.println("连接失败"+e);
			e.printStackTrace();
		}finally{
			db.closeAll(rst, stmt, conn);
		}
		
		r=rsb.toString();
		if(r.length()>1) {
			r=r.substring(0,r.length()-1);
		}
		r=r+"]";
		return r;
	}
	
	/**
	 * 写文件--属性--例如：具体的机关名字（就改了一个方法）
	 * @param name
	 */
	public void txtWriTwoDetailAtt(String name) {
		TxtSer txtSer=new TxtSer();
		
		String path1=pathOut+"\\结果数据文件\\E-"+name+".txt";
		String[] ym=txtSer.txtReMore(path1).split("###");//获取每行数据
		String num=ym[0];//第一行[1,2,3,4,5,6,7]
		num=num.replace("[", "").replace("]", "");
		String[] numArr=num.split(",");
		
		try {
		    String path=pathOut+"\\结果数据文件\\E-"+name+"-细节.txt";
		    File writename = new File(path); 
	        writename.createNewFile(); // 创建新文件  
	        BufferedWriter out = new BufferedWriter(new FileWriter(writename));  
	
	        String na="[]";
			for(int i=0;i<numArr.length;i++) {
				na=findByNum2Att(name, numArr[i]);////////////////////////////////////////
				out.write(numArr[i]+"-"+na+"\r\n");//2-["name1","name2","name3"]
//				System.out.println(numArr[i]+"-"+na);
			}
			
		    out.flush();
	        out.close(); 
		}catch (Exception e) {
			e.printStackTrace();  
		}
	}
	/**
	 * 统计图的查询(两个组合)--属性---具体
	 * @param name
	 * @param num2
	 * @return ["name1","name2","name3"]
	 */
	private String findByNum2Att(String name,String num2) {
		String r="[";
		StringBuffer rsb=new StringBuffer(r);
		Connection conn=null;
		Statement  stmt=null;
		ResultSet  rst=null;
		OracleUtil db=new OracleUtil();

		String tableName1="";

		String fieldId11="";
		String fieldId12="";
		
		if(name.equals("执法人员-性别")) {
			tableName1="TBL_BASIC_PERSON"
					+" where IS_DELETE='0' and PERSON_TYPE='01' ";
			fieldId11="name";
			fieldId12="sex";
		}else if(name.equals("执法人员-最高学历")) {
			tableName1="TBL_BASIC_PERSON"
					+" where IS_DELETE='0' and PERSON_TYPE='01' ";
			fieldId11="name";
			fieldId12="EDUCATION";
		}
		
		try {
			conn=db.getConnection();
			String sql="select "+fieldId11+" name, "+fieldId12+" att" + 
					" from "+tableName1 + 
					" and "+fieldId12+"='"+num2+"'";
		    stmt=conn.createStatement();
		    rst=stmt.executeQuery(sql);
	        
		    while(rst.next()){
		    	String na=rst.getString("name"); 
		    	if(null==na || na.equals("") || na.equals(" ") || na.equals("null")
		    			|| na.equals("\\")) {
		    		rsb.append("\"\",");
		    	}else {
		    		na.replace("\"", "'");
		    		rsb.append("\"").append(na).append("\",");
		    	}
		    }
		} catch (SQLException e) {
			//System.out.println("连接失败"+e);
			e.printStackTrace();
		}finally{
			db.closeAll(rst, stmt, conn);
		}
		
		r=rsb.toString();
		if(r.length()>1) {
			r=r.substring(0,r.length()-1);
		}
		r=r+"]";
		return r;
	}
	
}

