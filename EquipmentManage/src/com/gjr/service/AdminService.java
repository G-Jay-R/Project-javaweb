package com.gjr.service;

import com.gjr.pojo.Admin;
import com.gjr.pojo.Equip;

public interface AdminService {
	//用户登录验证
	Admin checkAdminLoginServcie(String aname,String apwd);
	
	//添加设备
	int addEquipService(Equip e);
	
	//修改信息
	int modifyEquipService(int id,Equip ep);
	
	//删除设备
	int delequiService(int id);
}
