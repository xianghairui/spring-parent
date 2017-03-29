package com.xiang.spring.struts2.bean;

public class Person {
	
	private String username;
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public void sayHello() {
		System.out.println("Hello, " + username);
	}
	
}
