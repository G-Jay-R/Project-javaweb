package com.gjr.dao;

import com.gjr.pojo.User;

public interface UserDao {
	User checkUserloginDao(String uname,String upwd);
}
