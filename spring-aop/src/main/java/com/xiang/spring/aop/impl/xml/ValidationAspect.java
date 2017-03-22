package com.xiang.spring.aop.impl.xml;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;

/**
 * 
 * <p>ClassName:ValidationAspect</p>
 * <p>Description: 指定切面的优先级</p>
 * <p>可以使用@order 指定切面的优先级，值越小优先级越高</p>
 * @author hairui
 * @date 2017年3月19日 下午3:57:01
 */
public class ValidationAspect {
	
	public void validateArgs(JoinPoint joinPoint){
		System.out.println("validate: " + Arrays.asList(joinPoint.getArgs()));
	}
	
}
