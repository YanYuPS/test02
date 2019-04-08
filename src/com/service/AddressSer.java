package com.service;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class AddressSer {

	
	
	public static void main(String args[]) {
		//ArrayList<String> qu=new ArrayList<String>(Arrays.asList(""));
//		String line = "北京市朝阳区东三环北路乙二号海南航空大厦A座5层";
//	    String pattern = "朝阳|海淀|东城";
//		// 创建 Pattern 对象
//	    Pattern r = Pattern.compile(pattern);
//	 
//	    // 现在创建 matcher 对象
//	    Matcher m = r.matcher(line);
//	    if (m.find( )) {
//	       System.out.println("Found value: " + m.group(0) );
//	    } else {
//	       System.out.println("NO MATCH");
//	    }
		
		AddressSer addressSer=new AddressSer();
		System.out.println(addressSer.txtMap());
	}
	
	
	/**
	 * 读取文件
	 * @param pathname 文件路径
	 */
	public String txtMap() {
		/**
		 * --地区-案件数量
select c.address from TBL_CASE_COMMON_BASIC c where c.address is not null 
 and c.address!=' ' and c.address!='/' ORDER BY c.address;
select c.address from TBL_CASE_SIMPLE_BASIC c where c.address is not null 
 and c.address!=' ' and c.address!='/' ORDER BY c.address
		 */
		String pathname="E:\\workspace\\eclipse\\原始数据文件\\案件地址.json";
		HashMap<String, Integer> qu=new HashMap<String, Integer>();
		qu.put("昌平", 0);
		qu.put("朝阳", 0);
		qu.put("大兴", 0);
		qu.put("东城", 0);
		qu.put("房山", 0);
		qu.put("丰台", 0);
		qu.put("海淀", 0);
		qu.put("怀柔", 0);
		qu.put("密云", 0);
		qu.put("平谷", 0);
		qu.put("顺义", 0);
		qu.put("通州", 0);
		qu.put("西城", 0);
		qu.put("延庆", 0);
		qu.put("门头沟", 0);
		qu.put("石景山", 0);
		 
		try (BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(pathname),"UTF-8"));) {
			String line;
			while ((line = br.readLine()) != null) {// 一次读入一行数据
				String pattern = "昌平|朝阳|大兴|东城|房山|丰台|海淀|怀柔|密云|平谷|顺义|通州|西城|延庆|门头沟|石景山";
				// 创建 Pattern 对象
			    Pattern r = Pattern.compile(pattern);
				Matcher m = r.matcher(line);
			    if (m.find( )) {
			       String quStr=m.group(0);
			       if(qu.containsKey(quStr)) {
			    	   qu.put(quStr, qu.get(quStr)+1);
			       }
			    }
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
			
		//[{name: '北京',value:0},..]
		String r="[";
		
		int sum=0;
		Set<String> keySet = qu.keySet();
		Iterator<String> it1 = keySet.iterator();
		while(it1.hasNext()){
			String ID = it1.next();
			int num = qu.get(ID);
			sum+=num;
			//System.out.println(ID+" "+num);
			//{name: '北京',value:0},
			r=r+"{name: '"+ID+"区',value:"+num+"},";
		}
		System.out.println(sum);
		r=r.substring(0, r.length()-1);
		r=r+"]";
		
		return r;

	}
}
