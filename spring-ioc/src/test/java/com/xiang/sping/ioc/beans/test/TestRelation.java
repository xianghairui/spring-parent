package com.xiang.sping.ioc.beans.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xiang.spring.ioc.beans.autowire.Address;
import com.xiang.spring.ioc.beans.autowire.Person;

public class TestRelation {
	
	@SuppressWarnings("resource")
	@Test
	public void Test(){
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-relation.xml");
		
		Address address = (Address) ctx.getBean("address2");
		System.out.println(address.toString());
		Address address3 = (Address) ctx.getBean("address3");
		System.out.println(address3.toString());
		
		Person person = (Person) ctx.getBean("person");
		System.out.println(person.toString());
		
	}
	
}
