package com.ssm.service;

import com.ssm.bean.User;
import com.ssm.exception.SelfException;

public interface UserService {
	
	/**
	 * 登录
	 * @param user
	 * @return
	 * @throws SelfException
	 */
	public User queryUserInfo(User user) throws SelfException;
}
