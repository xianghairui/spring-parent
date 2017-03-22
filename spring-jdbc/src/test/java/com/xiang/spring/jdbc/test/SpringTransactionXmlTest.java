package com.xiang.spring.jdbc.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xiang.spring.jdbc.tx.xml.BookShopDao;
import com.xiang.spring.jdbc.tx.xml.service.BookShopService;
import com.xiang.spring.jdbc.tx.xml.service.Cashier;

@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:applicationContext-xml.xml")
public class SpringTransactionXmlTest {

	@Autowired
	private BookShopDao bookShopDao;
	
	@Autowired
	private BookShopService bookShopService;
	
	@Autowired
	private Cashier cashier;
	
	@Test
	public void testFindBookPriceByBookId() {
		System.out.println(bookShopDao.findBookPriceByBookId(1001 + ""));	
	}
	
	@Test
	public void testUpdateBookStock() {	
		bookShopDao.updateBookStock(1001 + "");	
	}
	
	@Test
	public void testUpdateUserAccount() {
		bookShopDao.updateUserAccount("AA", 500);
	}
	
	@Test
	public void testPurchase() {
		bookShopService.purchase("AA", "1001");
	}
	
	@Test
	public void testCashier() {
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
