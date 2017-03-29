package com.xiang.spring.mybatis.dao.impl.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xiang.spring.mybaits.dao.UserDao;
import com.xiang.spring.mybaits.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:applicationContext2.xml")
public class UserServiceImplTest {
	
	@Autowired
	private UserService userService;
	
	@Test
	public void test(){
		System.out.println(userService.getUserAll());
	}
	
}
