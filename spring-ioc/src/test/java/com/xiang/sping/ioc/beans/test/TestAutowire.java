package com.xiang.sping.ioc.beans.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xiang.spring.ioc.beans.autowire.Person;

public class TestAutowire {

	@SuppressWarnings("resource")
	@Test
	public void Test(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("bean-autowire.xml");
		Person person = (Person) ctx.getBean("person");
		System.out.println(person.toString());
	}
	
}
