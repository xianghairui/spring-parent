package com.xiang.sping.ioc.beans.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xiang.spring.ioc.beans.factory.Car;

public class TestFactory {
	
	@SuppressWarnings("resource")
	@Test
	public void test(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-factory.xml");
		
		Car car1 = (Car) ctx.getBean("car1");
		System.out.println(car1.toString());
		
	}
	
}
