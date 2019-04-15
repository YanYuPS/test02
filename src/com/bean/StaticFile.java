package com.bean;


import com.servlet.EchartKnowDataSt;

public class StaticFile {
	
	public final static String PATH=EchartKnowDataSt.class.
			getResource("/").toString().replace("%20", " ").
			replace("/", "\\").replace("file:\\", "")+"file";
	
	
	
}
