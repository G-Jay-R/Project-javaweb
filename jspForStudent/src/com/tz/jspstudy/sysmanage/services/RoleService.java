package com.tz.jspstudy.sysmanage.services;

import java.sql.Timestamp;
import java.util.List;
import com.tz.jspstudy.sysmanage.bean.Role;
import com.tz.jspstudy.sysmanage.dao.RoleDao;

/**
 * 
 * 类描述：用于角色管理的服务类  
 * 类名称：com.tz.jspstudy.sysmanage.services.RoleService       
 * 创建人：keven  
 * 创建时间：2016年7月29日 下午9:55:29     
 * @version   V1.0
 */
public class RoleService{
	
 
	/**
	 * 查询角色信息
	 * @Title: queryRoleList  
	 * @Description: TODO
	 * @param roleName
	 * @return
	 */
	public List<Role> queryRoleList(String roleName){
		RoleDao roleDao = new RoleDao();
		return roleDao.queryRoleList(roleName);
	}
	
	/**
	 * 查询角色明细
	 * @Title: queryRoleDetail  
	 * @Description: TODO
	 * @param roleId
	 * @return
	 */
	public Role queryRoleDetail(Long roleId){
		RoleDao roleDao = new RoleDao();
		return roleDao.queryRoleDetail(roleId);		
	}
	
	/**
	 * 增加角色信息
	 * @Title: addRole  
	 * @Description: TODO
	 * @param role
	 * @return
	 */
	public boolean addRole(Role role){
		RoleDao roleDao = new RoleDao();
		role.setRoleId(roleDao.getSequence());
		role.setStatus(1);
		role.setTvUpdate(new Timestamp(System.currentTimeMillis()));
		int addFlag = roleDao.addRole(role);	
		if(addFlag>0)
			return true;
		else
			return false;
 	}
	
	/**
	 * 删除角色信息
	 * @Title: delRole  
	 * @Description: TODO
	 * @param roleId
	 * @return
	 */
	public boolean delRole(Long roleId){
		RoleDao roleDao = new RoleDao();
		int delFlag = roleDao.delRole(roleId);
		if(delFlag>0)
			return true;
		else
			return false;
 	}
	
	/**
	 * 修改角色信息
	 * @Title: updateRole  
	 * @Description: TODO
	 * @param role
	 * @return
	 */
	public boolean updateRole(Role role){
		RoleDao roleDao = new RoleDao();
		role.setStatus(1);
		role.setTvUpdate(new Timestamp(System.currentTimeMillis()));
		int updateFlag = roleDao.updateRole(role);
		if(updateFlag>0)
			return true;
		else
			return false;
 	}
	
	
	public static void main(String[] args) {
		 
	} 
}