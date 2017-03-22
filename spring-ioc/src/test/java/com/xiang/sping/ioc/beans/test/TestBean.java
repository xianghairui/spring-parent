package com.xiang.sping.ioc.beans.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xiang.spring.ioc.beans.Car;
import com.xiang.spring.ioc.beans.HelloWorld;
import com.xiang.spring.ioc.beans.Person;
import com.xiang.spring.ioc.beans.collections.DataSource;
import com.xiang.spring.ioc.beans.collections.Person2;

public class TestBean {
	
	@Test
	public void testHelloWorld(){
		//创建Hello World 的一个对象
//		HelloWorld helloWorld = new HelloWorld();
//		//为name赋值
//		helloWorld.setName("xianghairui");
		
		//1. 创建spirng IOC容器对象
		//ApplicationContext 代表IOC容器
		@SuppressWarnings("resource")
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//2. 从IOC 容器中获取Bean对象  id定位IOC中的bean
		//HelloWorld helloWorld = (HelloWorld) ctx.getBean("helloWorld");
		
		//class定位bean
		HelloWorld helloWorld = ctx.getBean(HelloWorld.class);
		//3.调用hello方法
		helloWorld.hello();	
		
		Car car = (Car) ctx.getBean("car");
		System.out.println(car.toString());
		Car car2 = (Car) ctx.getBean("car2");
		System.out.println(car2.toString());
		Car car3 = (Car) ctx.getBean("car3");
		System.out.println(car3.toString());
		
		Person person = (Person) ctx.getBean("person");
		System.out.println(person.toString());
		
		Person person2 = (Person) ctx.getBean("person2");
		System.out.println(person2.toString());
	}
	
	@SuppressWarnings("resource")
	@Test
	public void testCollection(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		com.xiang.spring.ioc.beans.collections.Person person = (com.xiang.spring.ioc.beans.collections.Person) ctx.getBean("person5");
		System.out.println(person.toString());
		
		Person2 person2 = (Person2) ctx.getBean("newPerson");
		System.out.println(person2);
		
		DataSource dataSource = (DataSource) ctx.getBean("dataSource");
		System.out.println(dataSource.toString());
	}
	
}
