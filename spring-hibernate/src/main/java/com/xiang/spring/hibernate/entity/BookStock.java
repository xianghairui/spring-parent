package com.xiang.spring.hibernate.entity;

public class BookStock {
	
	private Integer id;
	
	private Integer bookId;
	
	private Integer stock;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "BookStock [id=" + id + ", bookId=" + bookId + ", stock=" + stock + "]";
	}

}
