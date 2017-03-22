package com.xiang.spring.hibernate.test;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xiang.spring.hibernate.dao.BookShopDao;
import com.xiang.spring.hibernate.service.BookShopService;
import com.xiang.spring.hibernate.service.Cashier;

public class SpringHibernateTest {

	private ApplicationContext ctx = null;
	private BookShopService bookShopService = null;
	private Cashier cashier = null;
	
	{
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		bookShopService = (BookShopService) ctx.getBean("bookShopService");
		cashier = ctx.getBean(Cashier.class);
	}
	
	@Test
	public void testDataSource() {
		DataSource dataSource = ctx.getBean(DataSource.class);
		System.out.println(dataSource);
	}
	
	@Test
	public void testBookShopServcie() {
		bookShopService.purchase("AA", 1001 + "");
	}
	
	@Test
	public void test(){
		List<String> list = new ArrayList<>();
		list.add("1001");
		list.add("1001");
		list.add("1001");
		list.add("1001");
		list.add("1001");
		list.add("1001");
		cashier.checkout("AA", list);
	}
	
}
