package com.xiang.spring.jdbc.tx.xml.service;

import java.util.List;

public interface Cashier {

	void checkout(String username, List<String> bookIds);
	
}
