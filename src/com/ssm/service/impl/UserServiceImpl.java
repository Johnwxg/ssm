package com.ssm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssm.bean.User;
import com.ssm.dao.UserDao;
import com.ssm.exception.SelfException;
import com.ssm.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;

	/**
	 * 登录
	 * @param user
	 * @return
	 * @throws SelfException
	 */
	@Override
	public User queryUserInfo(User user) throws SelfException {
		User userInfo = null;
		try {
			userInfo = userDao.queryUserInfo(user);
		} catch (Exception e) {
			throw new SelfException(e.getMessage());
		}
		return userInfo;
	}
}
