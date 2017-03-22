package com.xiang.spring.aop.helloworld;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * 
 * <p>ClassName:ArithmeticCalculatorLoggingProxy</p>
 * <p>Description: 动态代理</p>
 * <p></p>
 * @author hairui
 * @date 2017年3月13日 下午4:49:40
 */
public class ArithmeticCalculatorLoggingProxy {

	//需要代理对象
	private ArithmeticCalculator target;
	
	public ArithmeticCalculatorLoggingProxy(ArithmeticCalculator target) {
		this.target = target;
	}
	
	@SuppressWarnings("rawtypes")
	public ArithmeticCalculator getLoggingProxy(){
		ArithmeticCalculator proxy = null;
		
		//代理对象由哪一个类加载器负责加载
		ClassLoader loader = target.getClass().getClassLoader();
		//代理对象的类型，即其中有哪些方法
		Class[] interfaces = new Class[]{ArithmeticCalculator.class};
		//当调用代理对象其中的方法时， 该执行的代码
		InvocationHandler h = new InvocationHandler() {
			/**
			 * proxy :正在返回的那个代理对象，一般情况下，在invoke方法不使用该对象
			 * method: 正在调用的方法
			 * args: 调用方法传入的参数
			 */
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				String methodName = method.getName();
				System.out.println("The method " + methodName + " begin with " + Arrays.asList(args));
				Object result = method.invoke(target, args);
				System.out.println("The method " + methodName + "end with " + result);
				return result;
			}
		};
		proxy = (ArithmeticCalculator) Proxy.newProxyInstance(loader, interfaces, h);
		return proxy;
		
	}
	
}
