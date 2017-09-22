package com.demo.org.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.demo.org.bean.Account;
import com.demo.org.dao.IAccountDao;
import com.demo.org.service.IAccountService;

@Service("accountService")
public class AccountServiceImpl implements IAccountService{
	@Resource
	private IAccountDao accountDao;
	
	@Override
	public Account getAccount(int id) {
		// TODO Auto-generated method stub
		Account acc = accountDao.getAccount(1);
//		acc.setUsername("testusername");
//		acc.setPassword("testpassword");
		
		return acc;
	}

}