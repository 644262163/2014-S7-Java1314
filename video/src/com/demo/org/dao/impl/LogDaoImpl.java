package com.demo.org.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.demo.org.bean.Log;
import com.demo.org.dao.LogDao;
import com.demo.org.util.DbManager;

public class LogDaoImpl implements LogDao{

	@Override
	public int addLog(Log log) {
		// TODO Auto-generated method stub
		Connection con = null;
		try {
			con = DbManager.getConnection();
			//
			Statement stmt = con.createStatement();
			
			String sqlStr = "insert into user_log(description,account_id) " + 
					"values ('"+log.getDescription()+"',"+log.getAccount_id()+")";
			
			int result = stmt.executeUpdate(sqlStr);
			
			return result;
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DbManager.closeConnection(con);
		}
		
		
		
		return 0;
	}

	@Override
	public List<Log> getLog() {
		// TODO Auto-generated method stub
		return null;
	}

}