package com.demo.org.bean;

import java.beans.ConstructorProperties;

/**
 * 验证bean配置
 * @author xl
 *
 */
public class BeanClass02 {
	private String info;

	//默认无参构造函数
	public BeanClass02() {
		
	}
	//有参构造函数
	@ConstructorProperties("info")
	public BeanClass02(String info) {
		this.info = info;
	}
	
	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}
	
	public void showInfo() {
		System.out.println(info);
	}
}