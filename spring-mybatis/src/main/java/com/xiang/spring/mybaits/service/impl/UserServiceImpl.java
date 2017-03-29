package com.xiang.spring.mybaits.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xiang.spring.mybaits.entity.TlUser;
import com.xiang.spring.mybaits.mapper.UserMapper;
import com.xiang.spring.mybaits.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	
	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	@Override
	public List<TlUser> getUserAll() {
		return userMapper.getUserAll();
	}

	@Override
	public TlUser getUserById(Integer id) {
		return userMapper.getUserById(id);
	}
	


}
