package com.xiang.spring.jdbc.tx.xml;

import org.springframework.jdbc.core.JdbcTemplate;

public class BookShopDaoImpl implements BookShopDao {

	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public int findBookPriceByBookId(String bookId) {
		String sql = "select price from book where id = ?";
		return jdbcTemplate.queryForObject(sql, Integer.class, bookId);
	}

	@Override
	public void updateBookStock(String bookId) {
		////检查书的库存，是否足够不够抛异常
		String sql2 = "select stock from book_stock where book_id = ?";
		int stock = jdbcTemplate.queryForObject(sql2, Integer.class, bookId);
		if(stock == 0){
			throw new BookStockException("库存不足！");
		} 
		
		String sql = "update book_stock set stock = stock -1 where book_id = ?";
		jdbcTemplate.update(sql, bookId);
	}

	@Override
	public void updateUserAccount(String username, int price) {
		String sql2 = "select balance from account where username = ?";
		int balance = jdbcTemplate.queryForObject(sql2, Integer.class, username);
		if(balance < price){
			throw new UserAccountException("余额不足！");
		} 
		String sql = "update account set balance = balance - ? where username = ?";
		jdbcTemplate.update(sql, price, username);
	}

}
