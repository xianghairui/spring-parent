package com.xiang.spring.aop.impl;

import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//把这个类声明为切面
@Order(2)
@Aspect
@Component
public class LoggingAspect {

	/**
	 * 第一个方法用于声明切入点表达式，一般给方法中再不需要填入其他的代码
	 * 使用@pointcut 来声明切入点标识，
	 * 后面的其他通知直接使用方法来引用当前的切入点表达式
	 */
	@Pointcut("execution(* com.xiang.spring.aop.impl.*.*(..))")
	public void declareJointPogintExpression(){}
	
	/**
	 * 该方法为前置通知: 在目标方法开始之前执行
	 * @param joinPoint
	 */
	//@Before("execution(* com.xiang.spring.aop.impl.*.*(int, int))")
	@Before(value = "declareJointPogintExpression()")
	public void beforeMethod(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		List<Object> args = Arrays.asList(joinPoint.getArgs());
		System.out.println("The method " + methodName + " begins with " + args);
	}

	/**
	 * 后置通知：在目标方法执行后（无论是否发生异常）， 执行的通知
	 * 在后置通知中还不能访问目标方法执行的结果
	 * @param joinPoint
	 */
	//@After("execution(* com.xiang.spring.aop.impl.*.*(..))")
	@After(value = "declareJointPogintExpression()")
	public void afterMethod(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		System.out.println("The method " + methodName + " end with ");
	}

	/**
	 * 在方法正常结束后执行的代码 返回通知后是可以访问到该方法的返回值得
	 * 
	 * @param joinPoint
	 */
	//@AfterReturning(value = "execution(* com.xiang.spring.aop.impl.*.*(..))", returning = "result")
	@AfterReturning(pointcut="declareJointPogintExpression()", returning="result")
	public void afterReturning(JoinPoint joinPoint, Object result) {
		String methodName = joinPoint.getSignature().getName();
		System.out.println("The method " + methodName + " end with " + result);
	}

	/**
	 * 在方法出现异常时会执行的代码 可以访问到异常对象，且可以指定在出现异常在执行通知代码
	 * 
	 * @param joinPoint
	 * @param ex
	 */
	//@AfterThrowing(value = "execution(* com.xiang.spring.aop.impl.*.*(..))", throwing = "ex")
	@AfterThrowing(pointcut="declareJointPogintExpression()", throwing = "ex")
	public void afterThrowing(JoinPoint joinPoint, Exception ex) {
		String methodName = joinPoint.getSignature().getName();
		System.out.println("The method " + methodName + "occurs exception: " + ex);
	}

	//@AfterThrowing(value = "execution(* com.xiang.spring.aop.impl.*.*(..))", throwing = "ex")
	@AfterThrowing(pointcut="declareJointPogintExpression()", throwing = "ex")
	public void afterThrowing(JoinPoint joinPoint, ArithmeticException ex) {
		String methodName = joinPoint.getSignature().getName();
		System.out.println("The method " + methodName + "occurs exception: 数学参数异常 " + ex);
	}

	/**
	 * ----》不常用
	 * 环绕通知需要携带ProceedingJoinPoint 类型参数，
	 * 环绕通知类似于动态代理的全过程：ProceedingJoinPoint 类型的参数可以决定是否执行目标方法，
	 * 且环绕通知有返回值， 返回值纪委目标方法的返回值
	 * @param pjp  
	 */
/*	@Around(value = "execution(* com.xiang.spring.aop.impl.*.*(..))")
	public Object aroundMethod(ProceedingJoinPoint pjp) {
		
		Object result = null;
		String methodName = pjp.getSignature().getName();
		//执行目标方法
		try {
			//前置通知
			System.out.println("The method " + methodName + " begins with " + Arrays.asList(pjp.getArgs()));
			result = pjp.proceed();
			//后置通知
			System.out.println("The method " + methodName + " end with " + result);
			
		} catch (Throwable e) {
			//异常通知
			System.out.println("The method " + methodName + "occurs exception: " + e);
			throw new RuntimeException(e);
		}
		//后置通知
		
		System.out.println("The method " + methodName + " end with ");
		return result;
	}*/

}
