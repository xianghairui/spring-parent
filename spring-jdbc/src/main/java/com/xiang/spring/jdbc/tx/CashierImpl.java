package com.xiang.spring.jdbc.tx;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("cashier")
public class CashierImpl implements Cashier {

	@Autowired
	private BookShopService bookService;
	
	// 使用propagation 指定事务的传播行为， 即当前的事务方法被另外一个事务方法调用时
	// 如何使用事务，默认取值为 REQUIRED, 即使用调用方法的事务
	@Transactional
	@Override
	public void checkout(String username, List<String> bookIds) {
		for(String bookId : bookIds){
			bookService.purchase(username, bookId);
		}
	}

}
