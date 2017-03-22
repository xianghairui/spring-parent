package com.xiang.spring.aop;

import org.junit.Test;

import com.xiang.spring.aop.helloworld.ArithmeticCalculatorImpl;
import com.xiang.spring.aop.helloworld.ArithmeticCalculatorLoggingProxy;
import com.xiang.spring.aop.helloworld.ArithmeticCalculator;

public class TestArithmeticCalculatorLoggingProxy {
	
	@Test
	public void test(){
		
		//ArithmeticCalculator arithmeticCalculator = null;
//		arithmeticCalculator = new ArithmeticCalculatorImpl();
		
		ArithmeticCalculator target = new ArithmeticCalculatorImpl();
		ArithmeticCalculator proxy = new ArithmeticCalculatorLoggingProxy(target).getLoggingProxy();
		
		int result  = 0;		
		result = proxy.add(1, 2);
		System.out.println("--> " + result);
		
		result = proxy.sub(1, 2);
		System.out.println("--> " + result);
		
		result = proxy.mul(1, 2);
		System.out.println("--> " + result);
		
		result = proxy.div(1, 2);
		System.out.println("--> " + result);
		
	}
	
}
