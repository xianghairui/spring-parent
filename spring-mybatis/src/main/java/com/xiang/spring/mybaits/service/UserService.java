package com.xiang.spring.mybaits.service;

import java.util.List;

import com.xiang.spring.mybaits.entity.TlUser;

public interface UserService {

	public List<TlUser> getUserAll();

	public TlUser getUserById(Integer id);

}
