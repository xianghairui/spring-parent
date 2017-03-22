package com.xiang.spring.hibernate.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xiang.spring.hibernate.dao.BookShopDao;
import com.xiang.spring.hibernate.exception.BookStockException;
import com.xiang.spring.hibernate.exception.UserAccountException;

@Repository
public class BookShopDaoImpl implements BookShopDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	//不推荐使用 HibernateTemplate
	//应为这样会导致Dao 和 Spring 的API进行耦合
//	private HibernateTemplate hibernateTemplate;
	
	/**
	 * 获取当前线程绑定的session
	 * @return
	 */
	private Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public int findBookPriceByBookId(String bookId) {
		String hql = "select b.price from Book b where b.id = ?";
		Query query = getSession().createQuery(hql).setString(0, bookId);
		return (Integer) query.uniqueResult();
	}

	@Override
	public void updateBookStock(String bookId) {
		// 验证书的库存
		String hql2 = "select bs.stock from BookStock bs where bs.bookId = ?";
		int stock = (Integer) getSession().createQuery(hql2).setString(0, bookId).uniqueResult();
		if(stock == 0){
			throw new BookStockException("库存不足!");
		}
		String hql = "update BookStock bs set bs.stock = bs.stock - 1 where bs.bookId = ?";
		getSession().createQuery(hql).setString(0, bookId).executeUpdate();
	}

	@Override
	public void updateUserAccount(String username, int price) {
		// 验证金额
		String hql2 = "select balance from Account where username = ?";
		int balance = (Integer) getSession().createQuery(hql2).setString(0, username).uniqueResult();
		if(balance < price){
			throw new UserAccountException("余额不足！");
		}
		String hql = "update Account a set a.balance = a.balance - ? where a.username = ?";
		getSession().createQuery(hql).setInteger(0, price).setString(1, username).executeUpdate();
	}

}
