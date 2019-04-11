package com.tz.jspstudy.sysmanage.services;

import java.sql.Timestamp;
import java.util.List;

import com.tz.jspstudy.sysmanage.bean.Dept;
import com.tz.jspstudy.sysmanage.dao.DeptDao;
import com.tz.jspstudy.sysmanage.dto.DeptDto;

/**
 * 
 * 类描述：用于部门管理的服务类  
 * 类名称：com.tz.jspstudy.sysmanage.services.DeptService       
 * 创建人：keven  
 * 创建时间：2016年7月29日 下午9:55:29     
 * @version   V1.0
 */
public class DeptService{
	
 
	/**
	 * 查询部门信息
	 * @Title: queryDeptList  
	 * @Description: TODO
	 * @param deptName
	 * @return
	 */
	public List<DeptDto> queryDeptList(String deptName){
		DeptDao deptDao = new DeptDao();
		return deptDao.queryDeptList(deptName);
	}
	
	/**
	 * 查询部门明细
	 * @Title: queryDeptDetail  
	 * @Description: TODO
	 * @param deptId
	 * @return
	 */
	public Dept queryDeptDetail(Long deptId){
		DeptDao deptDao = new DeptDao();
		return deptDao.queryDeptDetail(deptId);		
	}
	
	/**
	 * 增加部门信息
	 * @Title: addDept  
	 * @Description: TODO
	 * @param dept
	 * @return
	 */
	public boolean addDept(Dept dept){
		DeptDao deptDao = new DeptDao();
		dept.setDeptId(deptDao.getSequence());
		dept.setStatus(1);
		dept.setTvUpdate(new Timestamp(System.currentTimeMillis()));
		int addFlag = deptDao.addDept(dept);	
		if(addFlag>0)
			return true;
		else
			return false;
 	}
	
	/**
	 * 删除部门信息
	 * @Title: delDept  
	 * @Description: TODO
	 * @param deptId
	 * @return
	 */
	public boolean delDept(Long deptId){
		DeptDao deptDao = new DeptDao();
		int delFlag = deptDao.delDept(deptId);
		if(delFlag>0)
			return true;
		else
			return false;
 	}
	
	/**
	 * 修改部门信息
	 * @Title: updateDept  
	 * @Description: TODO
	 * @param dept
	 * @return
	 */
	public boolean updateDept(Dept dept){
		DeptDao deptDao = new DeptDao();
		dept.setStatus(1);
		dept.setTvUpdate(new Timestamp(System.currentTimeMillis()));
		int updateFlag = deptDao.updateDept(dept);
		if(updateFlag>0)
			return true;
		else
			return false;
 	}
	
	
	public static void main(String[] args) {
		 
	} 
}