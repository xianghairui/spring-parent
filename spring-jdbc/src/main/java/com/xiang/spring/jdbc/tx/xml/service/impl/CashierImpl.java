package com.xiang.spring.jdbc.tx.xml.service.impl;

import java.util.List;

import com.xiang.spring.jdbc.tx.xml.service.BookShopService;
import com.xiang.spring.jdbc.tx.xml.service.Cashier;

public class CashierImpl implements Cashier {

	private BookShopService bookShopService;
	
	public void setBookShopService(BookShopService bookShopService) {
		this.bookShopService = bookShopService;
	}
	
	public BookShopService getBookShopService() {
		return bookShopService;
	}
	
	@Override
	public void checkout(String username, List<String> bookIds) {
		for(String bookId : bookIds){
			bookShopService.purchase(username, bookId);
		}
	}

}
