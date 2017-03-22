package com.xiang.spring.jdbc.tx.xml.service.impl;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.xiang.spring.jdbc.tx.xml.BookShopDao;
import com.xiang.spring.jdbc.tx.xml.service.BookShopService;

public class BookShopServiceImpl implements BookShopService {

	private BookShopDao bookShopDao;
	
	public void setBookShopDao(BookShopDao bookShopDao) {
		this.bookShopDao = bookShopDao;
	}
	
	@Transactional(propagation=Propagation.REQUIRES_NEW, 
			isolation=Isolation.READ_COMMITTED,
			readOnly=false)
	@Override
	public void purchase(String username, String bookId) {
		
		//1. 获取书的单价
		int price = bookShopDao.findBookPriceByBookId(bookId);
		//2. 更新库存
		bookShopDao.updateBookStock(bookId);
		//3. 更新用户账户
		bookShopDao.updateUserAccount(username, price);
	}
	
}
