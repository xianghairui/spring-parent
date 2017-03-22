package com.xiang.sping.ioc.beans.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xiang.spring.ioc.beans.factorybean.Car;

public class TestBeanFactory {
	
	@Test
	public void test(){
		
		@SuppressWarnings("resource")
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-beanfactory.xml");
		Car car = (Car) ctx.getBean("car");
		System.out.println(car.toString());
		
	}
	
}
