package com.xiang.spring.hibernate.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xiang.spring.hibernate.service.BookShopService;
import com.xiang.spring.hibernate.service.Cashier;

@Service(value="cashier")
public class CashierImpl implements Cashier {

	@Autowired
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
