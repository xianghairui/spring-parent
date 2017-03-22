package com.xiang.sping.ioc.beans.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xiang.spring.ioc.beans.spel.Address;
import com.xiang.spring.ioc.beans.spel.Car;
import com.xiang.spring.ioc.beans.spel.Person;


public class TestSpel {
	
	@Test
	public void test(){
		@SuppressWarnings("resource")
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-spel.xml");
		Address address = (Address) ctx.getBean("address");
		System.out.println(address.toString());
		
		Car car = (Car) ctx.getBean("car");
		System.out.println(car.toString());
		
		Person person = (Person) ctx.getBean("person");
		System.out.println(person.toString());
	}
	
}
