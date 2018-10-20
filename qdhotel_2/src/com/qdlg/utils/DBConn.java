package com.qdlg.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConn {
	
	private final String url = "jdbc:mysql://localhost:3306/vip";
	private final String user = "root";
	private final String pwd = "1234";
	private Connection conn;
	
	public Connection getConnection(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, pwd);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void main(String[] args) {
		
		DBConn db = new DBConn();
		System.out.println(db.getConnection()==null);
		
		
	}
	
	
	

}
