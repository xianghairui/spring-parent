package com.xiang.spring.mybaits.dao.impl;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.xiang.spring.mybaits.dao.UserDao;
import com.xiang.spring.mybaits.entity.TlUser;

public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao {

	@Override
	public TlUser getUserById(Integer id) {
		return getSqlSession().selectOne("com.xiang.spring.mybaits.dao.UserDao.getUserById", id);
	}

}
