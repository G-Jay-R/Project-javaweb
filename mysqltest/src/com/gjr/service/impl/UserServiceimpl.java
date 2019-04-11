package com.gjr.service.impl;

import com.gjr.dao.UserDao;
import com.gjr.dao.impl.UserDaoimpl;
import com.gjr.pojo.User;
import com.gjr.service.UserService;

	//Service层实现类
public class UserServiceimpl implements UserService{
	//声明Dao层对象
	UserDao ud=new UserDaoimpl();
	//用户登录
	public User checkUserLoginService(String uname, String pwd) {
		return ud.checkUserLoginDao(uname, pwd);
	}

	public int userRegService(User u) {
		//用户注册
		return ud.userRegDAO(u);
	}

}
