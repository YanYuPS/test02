package com.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TxtSer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public String txtRe(String path) {
		String r="";
		try (BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(path),"UTF-8"));) {
	        String line;
			while ((line = br.readLine()) != null) {// 一次读入一行数据
				r=line;
			}    
		} catch (IOException e) {
			e.printStackTrace();
		}
		return r;
	}
	public void txtWri(String str,String path) {
		// TODO Auto-generated method stub
		 try { // 防止文件建立或读取失败，用catch捕捉错误并打印，也可以throw  
			 /* 写入Txt文件 */  
	        File writename = new File(path); 
	        writename.createNewFile(); // 创建新文件  
	        BufferedWriter out = new BufferedWriter(new FileWriter(writename));  
	        out.write(str); // \r\n即为换行 
	        out.flush(); // 把缓存区内容压入文件  
	        out.close(); // 最后记得关闭文件  
	
	    } catch (Exception e) {  
	        e.printStackTrace();  
	    }  
	}
	/**
	 * ###号连接多行
	 * @param path
	 * @return
	 */
	public String txtReMore(String path) {
		String r="";
		try (BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(path),"UTF-8"));) {
	        String line;
			while ((line = br.readLine()) != null) {// 一次读入一行数据
				r=r+line+"###";
			}    
		} catch (IOException e) {
			e.printStackTrace();
		}
		r=r.substring(0, r.length()-3);
		return r;
	}
	/**
	 * ###号连接多行
	 * @param str
	 * @param path
	 */
	public void txtWriMore(String str,String path) {
		// TODO Auto-generated method stub
		 try { // 防止文件建立或读取失败，用catch捕捉错误并打印，也可以throw  
			 /* 写入Txt文件 */  
	        File writename = new File(path); 
	        writename.createNewFile(); // 创建新文件  
	        BufferedWriter out = new BufferedWriter(new FileWriter(writename));  
	        String[] arr=str.split("###");
	        for(int i=0;i<arr.length;i++) {
	        	out.write(arr[i]+"\r\n"); // \r\n即为换行 
	        }
	        out.flush(); // 把缓存区内容压入文件  
	        out.close(); // 最后记得关闭文件  
	
	    } catch (Exception e) {  
	        e.printStackTrace();  
	    }  
	}

}
