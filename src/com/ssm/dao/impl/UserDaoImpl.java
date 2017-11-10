package com.ssm.dao.impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssm.bean.User;
import com.ssm.dao.UserDao;

/*@Repository注解将数据访问层(DAO层)的类标识为 Spring Bean*/
@Repository
public class UserDaoImpl implements UserDao {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	
	/**
	 * 查询用户信息
	 */
	@Override
	public User queryUserInfo(User user) {
		return sqlSessionTemplate.selectOne("queryUserInfo", user);
	}
	
	

}
