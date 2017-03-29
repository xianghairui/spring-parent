package com.xiang.spring.mybatis.dao.impl.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xiang.spring.mybaits.dao.UserDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:applicationContext.xml")
public class UserDaoImplTest {
	
	@Autowired
	private UserDao userDao;
	
	@Test
	public void test(){
		System.out.println(userDao.getUserById(1));
	}
	
}
