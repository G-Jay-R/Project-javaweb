package com.gjr.dao;

import com.gjr.pojo.User;

public interface UserDao {
	/*
	 * 根据用户名密码查询用户信息
	 */
	User checkUserLoginDao(String uname,String pwd);
	//用户注册
	int userRegDAO(User u);
}
