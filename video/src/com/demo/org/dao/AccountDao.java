package com.demo.org.dao;

import java.util.List;

public interface AccountDao {
	//对应数据表的增删改查
	
	
	
	//获取该id下所有的权限url
	public List<String> getAuthUrl(int id);
}