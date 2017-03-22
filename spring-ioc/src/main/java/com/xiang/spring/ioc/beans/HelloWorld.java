package com.xiang.spring.ioc.beans;

public class HelloWorld {

	private String name;
	
	public HelloWorld() {
		super();
		System.out.println("HelloWorld`s Constructor");
	}
	
	public HelloWorld(String name) {
		super();
		this.name = name;
	}
	
	public void setName(String name){
		System.out.println("set name = " + name);
		this.name = name;
	}
	
	public void hello(){
		System.out.println("hello : " + name);
	}
}
