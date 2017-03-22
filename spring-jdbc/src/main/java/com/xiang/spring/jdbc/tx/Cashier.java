package com.xiang.spring.jdbc.tx;

import java.util.List;

public interface Cashier {

	void checkout(String username, List<String> bookIds);
	
}
