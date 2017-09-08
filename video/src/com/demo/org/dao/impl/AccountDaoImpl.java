package com.demo.org.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.demo.org.dao.AccountDao;
import com.demo.org.util.DbManager;

public class AccountDaoImpl implements AccountDao{

	@Override
	public List<String> getAuthUrl(int id) {
		// TODO Auto-generated method stub
		List<String> urlList = new ArrayList<>();
		Connection con = null;
		try {
			con = DbManager.getConnection();
			
			Statement stat = con.createStatement();
			//查询语句
			StringBuffer sb = new StringBuffer();
			sb.append("select url from account ac,account_role ar,")
			  .append("role r,role_function rf,function fun ")
			  .append(" where ac.id = ar.account_id and ar.role_id = r.id and r.id = rf.role_id ")
			  .append("and rf.function_id = fun.id");
			sb.append(" and ac.id = ").append(id);
			
			ResultSet rs = stat.executeQuery(sb.toString());
			while(rs.next()) {
				String url = rs.getString("url");
				urlList.add(url);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DbManager.closeConnection(con);
		}
		
		return urlList;
	}

}