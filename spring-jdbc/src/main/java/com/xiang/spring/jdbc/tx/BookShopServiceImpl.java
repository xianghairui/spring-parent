package com.xiang.spring.jdbc.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("bookShopService")
public class BookShopServiceImpl implements BookShopService {

	@Autowired
	private BookShopDao bookShopDao;
	
	// 1. 使用propagation 指定事务的传播行为， 即当前的事务方法被另外一个事务方法调用时
	// 	如何使用事务，默认取值为 REQUIRED, 即使用调用方法的事务
	// 	REQUIRES_NEW 使用自己的事务， 调用的方法的事务被挂起
	// 2. 使用 isolation 指定事务的隔离级别，最常用的取值为 READ_COMMITTED
	// 3. 默认情况下 Spring 的声明式事务对所有的异常进行回滚，也可以通过对应的属性进行设置
	// 4. 使用readOnly 指定事务是否为只读, 标识这个只读取数据但不更新数据，
	//	这样可以帮助数据库引擎优化事务，若真的是一个只读取数据库值得方法，应设置 readOnly=true
	// 5. timeout 指定强制回滚之前事务可以占用的时间
//	@Transactional(propagation=Propagation.REQUIRES_NEW, 
//			isolation=Isolation.READ_COMMITTED,
//			noRollbackFor={UserAccountException.class})
	@Transactional(propagation=Propagation.REQUIRES_NEW, 
			isolation=Isolation.READ_COMMITTED,
			readOnly=false,
			timeout=5)
	@Override
	public void purchase(String username, String bookId) {
		
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//1. 获取书的单价
		int price = bookShopDao.findBookPriceByBookId(bookId);
		//2. 更新库存
		bookShopDao.updateBookStock(bookId);
		//3. 更新用户账户
		bookShopDao.updateUserAccount(username, price);
	}
	
}
