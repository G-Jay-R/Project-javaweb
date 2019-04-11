package com.gjr.service.impl;

import com.gjr.dao.AdminDao;
import com.gjr.dao.impl.AdminDaoimpl;
import com.gjr.pojo.Admin;
import com.gjr.pojo.Equip;
import com.gjr.service.AdminService;

//service的实现类
public class AdminServiceimpl implements AdminService{
	//声明Dao层对象
	AdminDao ad=new AdminDaoimpl();
	//用户登录
	@Override
	public Admin checkAdminLoginServcie(String aname, String apwd) {
		return ad.checkAdminLoginDao(aname, apwd);
	}
	
	//添加设备
	@Override
	public int addEquipService(Equip e) {
		
		return ad.addEquipDao(e);
	}
	
	//修改设备信息
	@Override
	public int modifyEquipService(int id, Equip ep) {
		// TODO Auto-generated method stub
		return ad.modifyEquipDao(id,ep);
	}

	@Override
	public int delequiService(int id) {
		// TODO Auto-generated method stub
		return ad.delequipsDao(id);
	}

}
