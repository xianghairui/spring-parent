package com.xiang.spring.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class TlUserDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public TlUser getTlUser(Integer id){
		String sql = "select id, username, gender, age, adress from tl_user where id = ?";
		RowMapper<TlUser> rowMapper = new BeanPropertyRowMapper<>(TlUser.class);
		TlUser user = jdbcTemplate.queryForObject(sql, rowMapper, 1);
		return user;
	}
	
}
