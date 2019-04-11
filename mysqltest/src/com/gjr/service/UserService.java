package com.gjr.service;

import com.gjr.pojo.User;

public interface UserService {
	/*
	 * 校验用户 
	 * 返回查询到的用户信息
	 */
	User checkUserLoginService(String uname,String pwd);

	int userRegService(User u);	//用户注册
}
