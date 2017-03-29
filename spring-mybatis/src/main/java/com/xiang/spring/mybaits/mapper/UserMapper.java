package com.xiang.spring.mybaits.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;

import com.xiang.spring.mybaits.entity.TlUser;
@MapperScan
public interface UserMapper {

	@Select("select * from tl_user")
	@Results({ 
		@Result(id = true, property = "id", column = "id"), 
		@Result(property = "username", column = "username"),
		@Result(property = "age", column = "age"),
		@Result(property = "adress", column = "adress") })
	public List<TlUser> getUserAll();

	@Select("select * from tl_user where id=#{id}")
	@Results({ 
		@Result(id = true, property = "id", column = "id"), 
		@Result(property = "username", column = "username"),
		@Result(property = "age", column = "age"),
		@Result(property = "adress", column = "adress") })
	public TlUser getUserById(Integer id);

}
