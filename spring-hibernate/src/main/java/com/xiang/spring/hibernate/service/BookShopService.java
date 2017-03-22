package com.xiang.spring.hibernate.service;

public interface BookShopService {
	
	/**
	 * 买书 
	 * @param username 用户名
	 * @param bookId 书号
	 */
	void purchase(String username, String bookId);
}
