package com.xiang.sping.ioc.beans.test;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xiang.spring.ioc.beans.cycle.Car;

public class TestCycle {
	
	@Test
	public void test(){
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans-cycle.xml");
		Car car = (Car) ctx.getBean("car");
		System.out.println(car.toString());
		
		//关闭IOC
		ctx.close();
	}
	
}
