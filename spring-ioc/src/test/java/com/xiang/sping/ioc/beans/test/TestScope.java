package com.xiang.sping.ioc.beans.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xiang.spring.ioc.beans.autowire.Car;

public class TestScope {
	
	@SuppressWarnings("resource")
	@Test
	public void test(){
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-scope.xml");
		Car car = (Car) ctx.getBean("car");
		Car car2 = (Car) ctx.getBean("car");
		System.out.println(car==car2);
	}
	
}
