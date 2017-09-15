package com.demo.org.bean;

/**
 * spring 注册生产bean的方式
 * @author xl
 *
 */
public class BeanClass01 {
	private String msg;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public void showMsg() {
		System.out.println(msg);
	}
}