package com.xiang.spring.hibernate.entity;

public class Account {

	private Integer id;
	private String username;
	private Integer balance;

	public Account() {
		super();
	}

	public Account(Integer id, String username, Integer balance) {
		super();
		this.id = id;
		this.username = username;
		this.balance = balance;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getBalance() {
		return balance;
	}

	public void setBalance(Integer balance) {
		this.balance = balance;
	}

}
