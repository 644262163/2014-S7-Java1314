package com.demo.org.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbManager {
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//获取connection
	public static Connection getConnection() throws SQLException{
		String urlstr = "jdbc:mysql://localhost/java1314s7?"
				+ "user=root&password=niit";
		return DriverManager.getConnection(urlstr);
	}
	
	//关闭connection
	public static void closeConnection(Connection con) {
		if(con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}