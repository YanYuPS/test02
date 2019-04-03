package com.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
 
public class OracleUtil {
	// URL
	public final static String URL="jdbc:oracle:thin:@localhost:1521:orcl";

	public final static String USERNAME="zfpt40";
	public final static String PWD="oracle";
	public final static String DRIVER="oracle.jdbc.driver.OracleDriver";

	static{
		try {
			Class.forName(DRIVER);
			//java.lang.ClassNotFoundException
			System.out.println("");
		} catch (ClassNotFoundException e) {
			System.out.println("");
			e.printStackTrace();
		}		
	}
	public Connection getConnection() throws SQLException{
		Connection conn=null;
		conn=DriverManager.getConnection(URL, USERNAME, PWD);
		return conn;
	}
	public void closeAll(ResultSet rst,Statement stmt,Connection conn){
		if(rst!=null){
			try {
				rst.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if(stmt!=null){
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	
 
}
