package com.test;
 
import java.sql.*;
import java.text.SimpleDateFormat;

import com.config.OracleUtil;
 
public class MainTest {
 
	public static void main(String[] args) {
		Connection conn=null;//���ݿ�����ʱʹ��
		Statement  stmt=null;//���ݿ����ӳɹ��󣬶����ݽ��в���ʱ�Ķ���
		ResultSet  rst=null;//��ѯ����ʱ�᷵�ؽ����
		OracleUtil db=new OracleUtil();//ʵ����һ������
		try {
			conn=db.getConnection();//�������ݿ�
			System.out.println("�������ݿ�ɹ���");
			//��һ�ԣ���ѯemp�е�����
			String sql="select * from tbl_analysis_case_area";
			//�������� -- ��ѯ
		    stmt=conn.createStatement();//�������ݲ�������
		    rst=stmt.executeQuery(sql);//stmtִ�в�ѯ���,���ѷ��صĽ���ŵ���rst��
		    //�����������
		    while(rst.next()){
//		    	int no=rst.getInt(1);
		    	//String ename=rst.getString(2);// int|number|numeric--->int  varchar2() --->String
		    	String id=rst.getString("id");
		    	String area=rst.getString("area");
//		    	Time time=rst.getTime(5);
//		    	SimpleDateFormat f=new SimpleDateFormat("yyyy��MM��dd��");
//		    	String newDate=f.format(date);
		    	System.out.println(id+"--->"+area);
		    }
		} catch (SQLException e) {
			System.out.println("�������ݿⲻ�ɹ�");
			e.printStackTrace();
		}finally{
			//�ͷ�������Դ
			db.closeAll(rst, stmt, conn);
		}
	}
 
}
