package com.xiang.sping.ioc.beans.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mchange.v2.c3p0.ComboPooledDataSource;



public class TestProperties {
	
	@SuppressWarnings("resource")
	@Test
	public void test(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-properties.xml");
		ComboPooledDataSource dataSource =  (ComboPooledDataSource) ctx.getBean("dataSource");
		System.out.println(dataSource.toString());
	}
	
}
