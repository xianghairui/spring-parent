package com.xiang.sping.ioc.beans.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xiang.spring.ioc.beans.annotation.Controller.UserController;

//@RunWith(value = SpringJUnit4ClassRunner.class)
//@ContextConfiguration(value = "classpath:beans-annotation.xml")
public class TestAnnotation {
	
	@Test
	public void test(){
		@SuppressWarnings("resource")
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-annotation.xml");
//		TestObject testObject = (TestObject) ctx.getBean("testObject");
//		System.out.println(testObject.toString());
		
		UserController userController = (UserController) ctx.getBean("userController");
		userController.execute();
		
//		UserService userService = (UserService) ctx.getBean("userService");
//		userService.add();
//		
//		UserRepositoryImpl userRepository = (UserRepositoryImpl) ctx.getBean("userRepository");
//		userRepository.save();
	}
	
}
