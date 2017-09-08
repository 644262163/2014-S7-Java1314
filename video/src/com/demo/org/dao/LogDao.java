package com.demo.org.dao;

import java.util.List;

import com.demo.org.bean.Log;

public interface LogDao {
	//添加日志
	public int addLog(Log log);
	
	//查询日志
	public List<Log> getLog();
}