package com.xiang.spring.aop;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xiang.spring.aop.impl.xml.ArithmeticCalculator;

public class TestArithmeticCalculatorXml {
	
	@Test
	public void test(){
		//1. 创建Spring IOC的容器
		@SuppressWarnings("resource")
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext-xml.xml");		
		
		//2. 从IOC容器中获取bean的实例
		ArithmeticCalculator arithmeticCalculator = (ArithmeticCalculator) ctx.getBean("arithmeticCalculator");
		
		//3. 使用bean
		int result = arithmeticCalculator.add(3, 6);
		System.out.println("result: " + result);
		System.out.println();
		
		result = arithmeticCalculator.div(3, 3);
		System.out.println("result: " + result);
		
	}
	
}
