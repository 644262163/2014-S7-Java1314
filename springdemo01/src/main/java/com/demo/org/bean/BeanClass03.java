package com.demo.org.bean;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("bc03")
@Scope("prototype")
public class BeanClass03 {
	@Resource
	private BeanClass02 bc02;
	
	public void show() {
		bc02.showInfo();
	}
}