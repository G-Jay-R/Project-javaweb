package com.gjr.servletstudy.sysmanage.services;

import com.gjr.servletstudy.sysmanage.dao.UserDao;




	/*
	 * 用于对于用户信息处理的服务类（业务处理）
	 */
public class UserService{
	
	/*
	 * 此方法调用与数据库交互的UserDao.loginUser方法，判断是否验证成功
	 */
	public boolean loginUser(String username,String password){
		UserDao userDao=new UserDao();
		//如果需要加密或者解密，就在这一层进行处理
		return userDao.loginUser(username,password);
	}
	public boolean delete(String userId){
		//删除用户前，还要删除与用户相关的东西，如用户菜单、日志等
		return true;
	}
}