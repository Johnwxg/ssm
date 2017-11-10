package com.ssm.dao;

import com.ssm.bean.User;

public interface UserDao {
	/**
	 * 查询用户信息
	 */
	public User queryUserInfo(User user);
}
