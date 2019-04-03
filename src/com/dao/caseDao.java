package com.dao;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.config.OracleUtil;
import com.sun.corba.se.impl.oa.poa.ActiveObjectMap.Key;
 
public class caseDao {
	//year,month的list
	HashMap<String, Integer> mapNumYM=new HashMap<String, Integer>();
	HashMap<String, Integer> mapNumY=new HashMap<String, Integer>();
	public static void main(String[] args) {
		String name="case";
        caseDao caseDao=new caseDao();
        caseDao.getNumber(name);
		for(int i=2007;i<2019;i++) {
			String year=i+"";
			String num=caseDao.getMonth(year);
//			num=num.replace("null", "0");
			System.out.println(i);
			System.out.println(num);
			System.out.println(caseDao.getYearNum(year));
		}
	}
	
	public String sgetMonth(String year,String name) {
		String r="";
		HashMap<String, String> map=new HashMap<String, String>();
		if(name.equalsIgnoreCase("case")) {
			map.put("2007","[8,0,0,0,0,0,6,2,0,0,1,1]");
			map.put("2008","[3,2,3,1,1,3,0,1,3,3,1,0]");
			map.put("2009","[1,9,0,1,2,1,4,4,1,3,1,4]");
			map.put("2010","[11,3,6,5,6,11,9,11,4,6,4,13]");
			map.put("2011","[6,5,4,10,17,6,4,7,2,46,34,33]");
			map.put("2012","[11,54,28,52,35,26,62,56,67,60,98,66]");
			map.put("2013","[967,413,859,912,934,818,922,805,773,761,925,849]");
			map.put("2014","[3854,2366,4676,5198,5109,5229,5987,5699,5752,7668,7333,7479]");
			map.put("2015","[11524,5843,14695,15157,15362,13098,16541,13844,13720,29475,12623,10367]");
			map.put("2016","[29223,7927,22298,30683,28850,29430,51948,42443,32769,32676,32734,56036]");
			map.put("2017","[17748,23980,35840,28471,30416,41039,20898,27534,38625,17691,26213,28767]");
			map.put("2018","[29896,12669,39085,23782,32385,47592,30282,33285,36030,40393,12678,0]");		
			r=map.get(year);
		}
		return r;
	}
	public String sgetYear(String name) {
		String r="";
		r="[18,21,31,89,174,615,9938,66350,172249,397017,337222,338077]";
		return r;
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
