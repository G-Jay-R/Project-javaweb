package com.gjr.dao;

import com.gjr.pojo.Admin;
import com.gjr.pojo.Equip;

public interface AdminDao {
	/*
	 * 根据用户名密码查询用户信息
	 */
	Admin checkAdminLoginDao(String aname,String apwd);

	int addEquipDao(Equip e);

	int modifyEquipDao(int id, Equip ep);

	int delequipsDao(int id);
}
