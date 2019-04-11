package com.gjr.service.impl;

import com.gjr.dao.UserDao;
import com.gjr.dao.impl.UserDaoimpl;
import com.gjr.pojo.User;
import com.gjr.service.UserService;

public class UserServiceimpl implements UserService{
	UserDao ud=new UserDaoimpl();	//声明dao层对象
	
	public User checkUserloginService(String uname, String upwd) {
		return ud.checkUserloginDao(uname, upwd);
	}
	

}
