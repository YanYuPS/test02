package com.service;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EchartExchange {
	// 实体和属性1
	String[][] entityBig;
	// 实体和属性2
	String[][] entitySmall;
	//数组长度
	int l=0;
	int lb=0;
	int ls=0;
	//关系
	List<String> relationLst = new ArrayList<String>();
	
	// 判断重复
	HashSet<String> hashSet = new HashSet<String>();
	int n = 0;

	// 类别
	ArrayList<String> categoryOff = new ArrayList<String>();// 机关
	ArrayList<String> categoryPer = new ArrayList<String>();// 人员
	ArrayList<String> categoryLaw = new ArrayList<String>();// 法律法规
	ArrayList<String> categoryCase = new ArrayList<String>();// 执法案件
	ArrayList<String> categoryAtt = new ArrayList<String>();//属性

	// 背景颜色
	String colorBack = "#fff";

	// 圈的大小
	int entitySize = 50; // 实体
	int educationSize = 30; // 学历
	int lawSize = 50; // 法律法规
	int attributeSize = 20; // 属性
	// 属于类别
	int categoryNumOff = 0; // 机关
	int categoryNumPer = 1; // 人员
	int categoryNumCase = 2; // 执法案件
	int categoryNumLaw = 3; // 法律法规
	int categoryNumAtt = 4; // 属性
	// 固定
	boolean draggableBig = true;
	boolean draggableSmall = true;
	// 节点文字
	boolean lableShow = true;
	boolean edgelableShow = true;
	boolean forceMoce = true;
	// 属性字体颜色
	String colorAtt = "#8e44ad";
	String colorEnt = "#000";
	
	//中英文对照（球上的字和表的字段）
	HashMap<String, String> map=new HashMap<String, String>();
	//表格数据
	HashMap<String, String> map2=new HashMap<String, String>();
	
	public static void main(String args[]) {
		EchartExchange echartExchange = new EchartExchange();
		TxtSer txtSer=new TxtSer();
		String path1="E:\\workspace\\eclipse\\中间结果数据文件\\";
		String path2="E:\\workspace\\eclipse\\结果数据文件\\";

		//初始化：实体、属性、关系、类别
		echartExchange.init();
		
		//拼接data
		String data = echartExchange.dataJoin();
		System.out.println("------");
		System.out.println(data);
		txtSer.txtWri(data, path1+"data带~.txt");
		data=data.replace("~", " ");
		txtSer.txtWri(data, path2+"data.txt");
		
		//拼接links
		String links = echartExchange.linksJoin();
		System.out.println("------");
		System.out.println(links);
		txtSer.txtWri(links, path1+"links带~.txt");
		links=links.replace("~", " ");
		txtSer.txtWri(links, path2+"links.txt");


	}

	public void init() {
		initData();
		isRepeat();
	}
	public void initData() {
		String path="E:\\workspace\\eclipse\\原始数据文件\\";
		
		String pathBig = path+"实体和属性1.txt";
		entityBig=txtEntity(pathBig);
		lb=l;
		
		String pathSmall = path+"实体和属性2.txt";
		entitySmall=txtEntity(pathSmall);
		ls=l;
		
		//类别
		String pathCategory = path+"类别.txt";
		txtCategory(pathCategory);
		
		//关系
		String pathRelation = path+"关系.txt";
		txtRelation(pathRelation);
	}
	public void isRepeat() {
		//判断重复，重复的添加~
		isRepeat(entityBig,1);
		isRepeat(entitySmall,2);
	}

	
	/**
	 * 球上的名字和对应的表格字段名字
	 */
	public void initMap() {
		//关系
		String path="E:\\workspace\\eclipse\\原始数据文件\\map1.txt";
		txtMap(path);
	}
	/**
	 * 每个ID和对应的一行数据
	 */
	public void iniMap2(){
		//读取表格数据(读取10条)
		String path="E:\\workspace\\eclipse\\结果数据文件\\案件-机关主体人员.txt";
		try (BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(path),"UTF-8"));) {
			String line;
			int n=0;
			while ((line = br.readLine()) != null) {// 一次读入一行数据
				String pattern = "\"ID\":\"(.*?)\"";
			    Pattern r = Pattern.compile(pattern);
			    Matcher m = r.matcher(line);
			    if (m.find( )) {
			       map2.put(m.group(1), line);
			    } else {
			       System.out.println("NO MATCH");
			    }
			    
				n++;
				if(n==10) {
					break;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public String oneData(String datas) {
		//原始data(带~)
		TxtSer txtSer=new TxtSer();
		String path="E:\\workspace\\eclipse\\中间结果数据文件\\data带~.txt";
		String data = txtSer.txtRe(path);
		
		initMap();
		iniMap2();
		//根据ID找到对应的一行数据
		if(map2.containsKey(datas)) {
			datas=map2.get(datas);
		}
		
		//map中包含中英文对照的，替换掉
		//{"OFFICE_NAME":"王雪涛,邵琳萍","DEPARTMENT_NAME":"北京市国土资源局通州分局"}
		datas=datas.replace("{", "");
		datas=datas.replace("}", "");
		//"OFFICE_NAME":"王雪涛,邵琳萍","DEPARTMENT_NAME":"北京市国土资源局通州分局"
		String[] arr=datas.split(",\"");
		//"OFFICE_NAME":"王雪涛,邵琳萍"--------DEPARTMENT_NAME":"北京市国土资源局通州分局"
		for(int i=0;i<arr.length;i++) {
			arr[i]=arr[i].replace("\"", "");
			//OFFICE_NAME:王雪涛,邵琳萍--------DEPARTMENT_NAME:北京市国土资源局通州分局
			String[] arr1=arr[i].split(":");
			if(map.containsValue(arr1[0])) {
				//替换data
				data=replace(arr1,data);
			}
		}
		System.out.println(data);
		
		return data;
	}
	public String oneLinks(String datas) {
		//原始data(带~)
		TxtSer txtSer=new TxtSer();
		String path="E:\\workspace\\eclipse\\中间结果数据文件\\links带~.txt";
		String links = txtSer.txtRe(path);
		
		initMap();
		iniMap2();
		if(map2.containsKey(datas)) {
			datas=map2.get(datas);
		}
		
		//{"OFFICE_NAME":"王雪涛,邵琳萍","DEPARTMENT_NAME":"北京市国土资源局通州分局"}
		datas=datas.replace("{", "");
		datas=datas.replace("}", "");
		//"OFFICE_NAME":"王雪涛,邵琳萍","DEPARTMENT_NAME":"北京市国土资源局通州分局"
		String[] arr=datas.split(",\"");
		//"OFFICE_NAME":"王雪涛,邵琳萍--------DEPARTMENT_NAME":"北京市国土资源局通州分局"
		for(int i=0;i<arr.length;i++) {
			arr[i]=arr[i].replace("\"", "");
			//OFFICE_NAME:王雪涛,邵琳萍--------DEPARTMENT_NAME:北京市国土资源局通州分局
			String[] arr1=arr[i].split(":");
			if(map.containsValue(arr1[0])) {
				//替换
				links=replace(arr1,links);
			}
		}
		System.out.println(links);
		
		return links;
	}
	private String replace(String[] arr,String data) {
		// TODO Auto-generated method stub
		//arr[0]--英文名,arr[1]--值,
		
		Set<String> keySet = map.keySet();
		Iterator<String> it1 = keySet.iterator();
		while(it1.hasNext()){
			String key = it1.next();//中文名
			String value = map.get(key);//英文名
			
			if(value.equals(arr[0])) {
				String zh=key;//中文名
				String arr1="";
				if(arr.length!=1) {
					arr1=arr[1];
				}
				String dataNew=zh+":"+arr1;
				
				data=data.replace("\""+zh+"\"", "\""+dataNew+"\"");
			}
		}
		
		return data;
	}


	/**
	 * 读取txt文件
	 * @param pathname 文件路径
	 */
	public void txtMap(String pathname) {
		try (BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(pathname),"UTF-8"));) {
			String line;
			while ((line = br.readLine()) != null) {// 一次读入一行数据
//				System.out.println(line.substring(0, 2));
				if(line.substring(0, 2).equals("--")) {
					continue;
				}
				String[] arr = line.split(",");
				map.put(arr[1], arr[0]);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 读取txt文件,实体和属性
	 * 每行内容：实体,属性,属性
	 * @param pathname 文件路径
	 * @return 二维数组
	 */
	public String[][] txtEntity(String pathname) {
		String[][] entity = null;
		try (BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(pathname),"GB2312"));) {
			String line;
			entity = new String[100][];
			l=0;
			while ((line = br.readLine()) != null) {// 一次读入一行数据
				String[] arr = line.split(",");
				entity[l] = new String[arr.length];
                entity[l]=arr;
				l++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return entity;
	}
	
	/**
	 * 读取txt文件，类别
	 * 
	 * @param pathname 文件路径
	 */
	public void txtCategory(String pathname) {
		try (BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(pathname),"GB2312"));) {
			String line;
			while ((line = br.readLine()) != null) {// 一次读入一行数据
				String[] arr = line.split(":");
				String[] arr1 = arr[1].split(",");
				if(arr[0].equals("执法机关")) {
					categoryOff.addAll(Arrays.asList(arr1));
				}else if(arr[0].equals("执法人员")) {
					categoryPer.addAll(Arrays.asList(arr1));
				}else if(arr[0].equals("法律法规")) {
					categoryLaw.addAll(Arrays.asList(arr1));
				}else if(arr[0].equals("执法案件")) {
					categoryCase.addAll(Arrays.asList(arr1));
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//类别-----//执法案件添加
        for(int i=2;i<ls;i++){
            categoryCase.add(entitySmall[i][0]);
        }
	}

	/**
	 * 读取txt文件,实体和属性
	 * 每行内容：实体,属性,属性
	 * @param pathname 文件路径
	 * @return 二维数组
	 */
	public void txtRelation(String pathname) {
		try (BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(pathname),"UTF-8"));) {
			String line;
			while ((line = br.readLine()) != null) {// 一次读入一行数据
				relationLst.add(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 判断重复
	 * 
	 * @param entity 实体和属性(var数组)
	 * @param f      flag标志位：1-entityBig，2-entitySmall
	 * @return [["层级", "所属领域"],];
	 */
	public void isRepeat(String[][] entity, int f) {
		if (f == 1) {
			l=lb;
		} else if (f == 2) {
			l=ls;
		}
		String entityStr = "[";
		StringBuffer entityStrb = new StringBuffer(entityStr);
		for (int i = 0; i < l; i++) {
			entityStrb.append("[");
			for (int j = 0; j < entity[i].length; j++) {
				hashSet.add(entity[i][j]);
				n++;
				while (hashSet.size() != n) {// 有重复
					if (f == 1) {
						entityBig[i][j] = entityBig[i][j] + "~";
					} else if (f == 2) {
						entitySmall[i][j] = entitySmall[i][j] + "~";
					}
					hashSet.add(entity[i][j]);
				}
				// 拼接
				entityStrb.append("\"").append(entity[i][j]).append("\",");
			}
			entityStrb.append("],");
		}
		entityStrb.append("]");
		entityStr = entityStrb.toString();

		if (hashSet.size() == n) {
			System.out.println("没有重复");
		} else {
			int c = n - hashSet.size();
			System.out.println("重复几个：" + c);
		}

	}

	/**
	 * data拼接[
    {"name": "执法机关","category": 0,"draggable": true},
    {"name": "执法机关全称","category": 4,"draggable": true,
        "symbolSize": 20,"label": {"normal":{"textStyle": {"color": "#ccc"}}}
    }
    ]
	 * 
	 * @return data
	 */
	public String dataJoin() {
		System.out.println("data:");
		String data = "[";
		StringBuffer strb = new StringBuffer(data);

		// data实体拼接
		strb = dataEntity(entityBig, strb, 1);
		strb = dataEntity(entitySmall, strb, 2);
		// data属性拼接
		strb = dataAttribute(entityBig, strb, 1);
		strb = dataAttribute(entitySmall, strb, 2);
		
		data = strb.toString();
		data=data.substring(0, data.length()-1);
		data+="]";
		return data;
	}

	/**
	 * links拼接 links: [{source: entityBig[0][0],target: entityBig[2][0],value:
	 * relation[1]},
	 * 
	 * @return links
	 */
	public String linksJoin() {
		System.out.println("links:");
		String links = "[";
		StringBuffer strLink = new StringBuffer(links);

		// 其它关系
		String relationStr = "";
		strLink = linksEntity(relationStr, strLink);

		// 属性关系
		strLink = linksAttribute(entityBig, strLink, 1);
		strLink = linksAttribute(entitySmall, strLink, 2);

		links = strLink.toString();
		links=links.substring(0, links.length()-1);
		links+="]";
		return links;
	}

	/**
	 * data实体拼接
	 * {"name": "执法机关","category": 0,"draggable": true},
	 * @param entity 实体和属性(var数组)
	 * @param strb   拼接字段（返回值）
	 * @param f      flag标志位：1-entityBig，2-entitySmall
	 * @return
	 */
	private StringBuffer dataEntity(String[][] entity, StringBuffer strb, int f) {
		String symbolSize = "";// 圈的大小+字体颜色
		int categoryNum = categoryNumAtt;// 类别
		if (f == 1) {
			l=lb;
		} else if (f == 2) {
			l=ls;
		}
		
		for (int i = 0; i < l; i++) {
			// 类别
			if (categoryOff.contains(entity[i][0])) {
				categoryNum = categoryNumOff;
			} else if (categoryPer.contains(entity[i][0])) {
				categoryNum = categoryNumPer;
			} else if (categoryCase.contains(entity[i][0])) {
				categoryNum = categoryNumCase;
			} else if (categoryLaw.contains(entity[i][0])) {
				categoryNum = categoryNumLaw;
			}
			// 圈的大小+字体颜色 √
			if (entity[i][0].equals("学历")) {
				symbolSize = ",\"symbolSize\": " + educationSize
						+ ",\"label\": {\"normal\":{\"textStyle\": {\"color\": \""+colorAtt+"\"}}}";
			}

			// 拼接data
			strb.append("{\"name\": \"").append(entity[i][0]).append("\",\"category\": ").append(categoryNum)
					.append(",\"draggable\": ").append(draggableBig).append(symbolSize).append("},");

			symbolSize = "";// 圈的大小 √
		}
		return strb;
	}

	/**
	 * data属性拼接
	 * 
	 * @param entity 实体和属性(var数组)
	 * @param strb   拼接字段（返回值）
	 * @param f      flag标志位：1-entityBig，2-entitySmall
	 * @return
	 */
	private StringBuffer dataAttribute(String[][] entity, StringBuffer strb, int f) {
		String symbolSize = "";// 圈的大小+字体颜色
		if (f == 1) {
			l=lb;
		} else if (f == 2) {
			l=ls;
		}
		
		for (int i = 0; i < l; i++) {
			symbolSize = ",\"symbolSize\": " + attributeSize;
			for (int j = 1; j < entity[i].length; j++) {
				// 拼接data
				strb.append("{\"name\": \"").append(entity[i][j]).append("\",\"category\": ").append(categoryNumAtt)
						.append(",\"draggable\": ").append(draggableSmall).append(symbolSize)
						.append(",\"label\": {\"normal\":{\"textStyle\": {\"color\": \""+colorAtt+"\"}}}")
						.append("},");
			}
		}
		return strb;
	}

	/**
	 * links 实体的属性关系拼接
	 * 
	 * @param entity  实体和属性(var数组)
	 * @param strLink 拼接字段（返回值）
	 * @param f       flag标志位：1-entityBig，2-entitySmall
	 * @return
	 */
	private StringBuffer linksAttribute(String[][] entity, StringBuffer strLink, int f) {
		if (f == 1) {
			l=lb;
		} else if (f == 2) {
			l=ls;
		}
		
		for (int i = 0; i < l; i++) {
			for (int j = 1; j < entity[i].length; j++) {
				strLink.append("{\"source\": \"").append(entity[i][0]).append("\",\"target\": \"")
						.append(entity[i][j]).append("\",\"value\": \"\"")
						.append("},");
			}
		}
		return strLink;
	}

	/**
	 * links 实体关系拼接
	 * 
	 * @param relationStr 关系字符串
	 * @param strLink     拼接字段（返回值）
	 * @return
	 */
	private StringBuffer linksEntity(String relationStr, StringBuffer strLink) {
		for (int i = 0; i < relationLst.size(); i++) {
			String[] arr = relationLst.get(i).split(",");
			strLink.append("{\"source\": \"").append(arr[0]).append("\",\"target\": \"")
					.append(arr[1]).append("\",\"value\": \"")
					.append(arr[2]).append("\"},");
		}

		return strLink;
	}

}
