package com.xiang.spring.hibernate.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.xiang.spring.hibernate.dao.BookShopDao;
import com.xiang.spring.hibernate.service.BookShopService;

@Service(value="bookShopService")
public class BookShopServiceImpl implements BookShopService {
	
	@Autowired
	private BookShopDao bookShopDao;
	
	public void setBookShopDao(BookShopDao bookShopDao) {
		this.bookShopDao = bookShopDao;
	}
	
	
	/**
	 * Spirng hibernate 事务的流程
	 * 1. 在方法开始前
	 * ① 获取session
	 * ② 把session 和当前线程绑定，这样就可以在Dao中使用 sessionFactory 的
	 * 	getCurrentSession() 方法来获取 Session 了
	 * ③ 开启事务
	 * 
	 * 2. 若方法结束， 即没有出现异常，则
	 * ① 提交事务
	 * ② 使和当前线程绑定的Session 解除绑定
	 * ③ 关闭 Session
	 * 
	 * 3. 若方法出现异常，则，
	 * ① 回滚事务
	 * ② 使当前线程绑定的Session 解除绑定
	 * ③ 关闭session
	 */
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
