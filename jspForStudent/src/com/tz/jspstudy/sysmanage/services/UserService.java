package com.tz.jspstudy.sysmanage.services;

import java.sql.Timestamp;
import java.util.List;

import com.tz.jspstudy.framework.page.dto.PageObject;
import com.tz.jspstudy.sysmanage.bean.User;
import com.tz.jspstudy.sysmanage.dao.UserDao;
import com.tz.jspstudy.sysmanage.dto.UserDto;

/**
 * 类描述： 用于对关于用户信息处理的服务类（业务处理）  
 * 类名称：com.tz.jspstudy.sysmanage.services.UserService       
 * 创建人：keven  
 * 创建时间：2016年7月6日 下午4:26:22     
 * @version   V1.0
 */
public class UserService{
	
	/**
	 * 此方法调用与数据库交互的UserDao.loginUser方法，判断是否验证成功
	 * @Title: loginUser  
 	 * @param userName
	 * @param password
	 * @return boolean
	 */
	public boolean loginUser(String userName,String password){
		UserDao userDao = new UserDao();
		//如果需要加密或者解密，就在这一层进行处理，大家注意分层开发的思想，每层做每一层的事情，不要交叉 ，这就是j
		return userDao.loginUser(userName, password);		
	}
	
	/**
	 * 用于查询查询用户信息
	 * @Title: queryUser  
	 * @Description: TODO
	 * @param userName
	 * @return
	 */
	public List<UserDto> queryUser(String userName){
		UserDao userDao = new UserDao();
		return userDao.queryUser(userName);		
	}
	
	/**
	 * 用于分页查询用户信息
	 * @Title: queryUser  
	 * @Description: TODO
	 * @param userName
	 * @return
	 */
	public List<UserDto> queryUser(String userName,PageObject page){
		UserDao userDao = new UserDao();
		return userDao.queryUser(userName,page);		
	}
	
	
	
	public UserDto queryUserDetail(Long userId){
		UserDao userDao = new UserDao();
		return userDao.queryUserDetail(userId);		
	}
	
	/**
	 * 增加一个用户
	 * @Title: addUser  
	 * @Description: TODO
	 * @param user
	 * @return
	 */
	public boolean addUser(User user){
		UserDao userDao = new UserDao();
		user.setUserId(userDao.getSequence());
		user.setStatus(1);
		user.setTvUpdate(new Timestamp(System.currentTimeMillis()));
		int addFlag = userDao.addUser(user);	
		if(addFlag>0)
			return true;
		else
			return false;
 	}
	
	public boolean delUser(Long userId){
		UserDao userDao = new UserDao();	 
		int delFlag = userDao.delUser(userId);	
		if(delFlag>0)
			return true;
		else
			return false;
 	}
	
	/**
	 * 修改用户
	 * @Title: updateUser  
	 * @Description: TODO
	 * @param user
	 * @return
	 */
	public boolean updateUser(User user){
		UserDao userDao = new UserDao();
		user.setStatus(1);
		user.setTvUpdate(new Timestamp(System.currentTimeMillis()));
		int updateFlag = userDao.updateUser(user);
		if(updateFlag>0)
			return true;
		else
			return false;
 	}
	
	
	public static void main(String[] args) {
		 
	}
}