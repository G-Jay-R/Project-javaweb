package com.gjr.servletstudy.sysmanage.dao;

import com.gjr.servletstudy.framework.util.StringUtils;

		/*
		 * 用户表的增删改查方法及登陆验证等
		 */
public class UserDao{
	
	public boolean loginUser(String username,String password){
		boolean flag = false;
		//暂时用不到数据库的验证，初步只要密码是123456的都返回验证成功
		//后半段将数据库引入后，然后再进行数据库验证
		if(StringUtils.isNotNull(password))
		{
			if(password.equals("123456"))
			{
				flag = true;
			}
		}
		return flag;
	}


}