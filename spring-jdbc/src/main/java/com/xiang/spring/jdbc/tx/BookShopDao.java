package com.xiang.spring.jdbc.tx;

/**
 * 
 * <p>ClassName:BookShopDao</p>
 * <p>Description: TODO</p>
 * <p></p>
 * @author hairui
 * @date 2017年3月20日 下午1:15:23
 */
public interface BookShopDao {
	
	/**
	 * 根据书号获取书的单价
	 * @param bookId
	 * @return
	 */
	public int findBookPriceByBookId(String bookId);
	
	/**
	 * 更新库存，使书号对应的库存 -1
	 * @param bookId
	 */
	public void updateBookStock(String bookId);
	
	/**
	 * 跟新用户的账户余额：使 username 的balance - price 
	 * @param username
	 * @param price
	 */
	public void updateUserAccount(String username, int price);
	
}
