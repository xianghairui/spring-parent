package com.xiang.spring.jdbc;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class DepatmentDao extends JdbcDaoSupport{

	@Autowired
	public void setDataSource2(DataSource dataSource){
		setDataSource(dataSource);
	}
	
	public TlDepartment get(Integer id){
		String sql = "select departid, departmentname, remark from tl_department where departid = ?";
		RowMapper<TlDepartment> rowMapper = new BeanPropertyRowMapper<>(TlDepartment.class);
		return getJdbcTemplate().queryForObject(sql, rowMapper, id);
	}
	
}