package com.xiang.spring.aop;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xiang.spring.aop.impl.ArithmeticCalculator;

public class TestArithmeticCalculator {
	
	@SuppressWarnings("resource")
	@Test
	public void test(){
		//1. 创建Spring IOC的容器
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");		
		
		//2. 从IOC容器中获取bean的实例
		ArithmeticCalculator arithmeticCalculator = ctx.getBean(ArithmeticCalculator.class);
		
		//3. 使用bean
		int result = arithmeticCalculator.add(3, 6);
		System.out.println("result: " + result);
		System.out.println();
		
		result = arithmeticCalculator.div(3, 3);
		System.out.println("result: " + result);	
	}
}
