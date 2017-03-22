package com.xiang.sping.ioc.beans.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xiang.spring.ioc.beans.generic.di.UserService;

public class TestGenericDi {
	
	@SuppressWarnings("resource")
	@Test
	public void test(){
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-generic-di.xml");
		UserService userService = (UserService) ctx.getBean("userService");
		userService.add();
		
	}
	
}
