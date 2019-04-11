package com.tz.jspstudy.sysmanage.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tz.jspstudy.framework.dbUtil.TzJdbcTemplate;
import com.tz.jspstudy.framework.dbUtil.inteface.RowMapper;
import com.tz.jspstudy.framework.page.dto.PageObject;
import com.tz.jspstudy.framework.util.StringUtils;
import com.tz.jspstudy.sysmanage.bean.User;
import com.tz.jspstudy.sysmanage.dto.UserDto;

/**
 * 类描述:用户表的增删改查以及登陆验证  
 * 类名称：com.tz.jspstudy.sysmanage.dao.UserDao       
 * 创建人：keven  
 * 创建时间：2016年7月5日 下午7:48:38     
 * @version   V1.0
 */
public class UserDao  extends TzJdbcTemplate{
	
	/**
	 * 登陆验证，成功返回true 失败返回false
	 * @Title: loginUser  
	 * @Description: TODO
	 * @param userName
	 * @param password
	 * @return boolean
	 */
	public  boolean loginUser(String userName,String password){
		boolean flag = false;		 
		if(StringUtils.isNotNull(password)){
			String sql = "SELECT USER_ID,USER_NAME , PASSWORD,STATUS,DEPT_ID,ROLE_ID FROM M_USER "
						+ " WHERE USER_NAME='"+userName+"' AND PASSWORD='"+password+"'";
			 
			List<User> userList = new ArrayList<User>();
			userList = this.queryForList(new RowMapper<User>(){
	        	//实现接口，进行赋值
				public User mappingRow(ResultSet rs, int rownum)throws SQLException {
					User user = new User();
					user.setUserId(rs.getLong("USER_ID"));
					user.setUserName(rs.getString("USER_NAME"));
					user.setPassword(rs.getString("PASSWORD"));
					user.setDeptId(rs.getLong("DEPT_ID"));
					user.setRoleId(rs.getLong("ROLE_ID"));		 
					return user;
				}
	        	
	        }
	        , sql, null);
			
			if(userList!=null&&userList.size()>0)
				flag = true;
		}		
		return flag;
	}
	
	
	/**  
	 * @Title: 查询数据库中的用户信息
	 * @Description: TODO
	 * @param userName 模糊搜索与姓名匹配
	 * @return    
	 */ 
	public List<UserDto> queryUser(String userName){
		/*SELECT A.USER_ID,A.USER_NAME,A.PASSWORD,A.STATUS,
	       A.DEPT_ID,B.DEPT_NAME,A.ROLE_ID,C.ROLE_NAME,A.MOBILE,
	       A.OTELEPHONE,A.HTELEPHONE,A.REMARK ,A.TV_UPDATE FROM M_USER A 
	       LEFT JOIN M_DEPT B ON A.DEPT_ID = B.DEPT_ID
	       LEFT JOIN M_ROLE C ON A.ROLE_ID = C.ROLE_ID*/
		 
		StringBuffer strBuffer = new StringBuffer();
		strBuffer.append(" SELECT A.USER_ID,A.USER_NAME,A.PASSWORD,A.STATUS, ");
		strBuffer.append(" A.DEPT_ID,B.DEPT_NAME,A.ROLE_ID,C.ROLE_NAME,A.MOBILE, ");
		strBuffer.append(" A.OTELEPHONE,A.HTELEPHONE,A.REMARK ,A.TV_UPDATE FROM M_USER A ");
		strBuffer.append(" LEFT JOIN M_DEPT B ON A.DEPT_ID = B.DEPT_ID ");
		strBuffer.append(" LEFT JOIN M_ROLE C ON A.ROLE_ID = C.ROLE_ID ");

		if(StringUtils.isNotNull(userName)){
			strBuffer.append(" WHERE A.USER_NAME LIKE '%").append(userName).append("%'");
		}
		strBuffer.append(" ORDER BY A.TV_UPDATE DESC ");
		List<UserDto> userList = new ArrayList<UserDto>();
		userList = this.queryForList(new RowMapper<UserDto>(){
        	//实现接口，进行赋值
			public UserDto mappingRow(ResultSet rs, int rownum)throws SQLException {
				UserDto userDto = new UserDto();
				userDto.setUserId(rs.getLong("USER_ID"));
				userDto.setUserName(rs.getString("USER_NAME"));
				userDto.setPassword(rs.getString("PASSWORD"));
				userDto.setStatus(rs.getInt("STATUS"));
				userDto.setDeptId(rs.getLong("DEPT_ID"));
				userDto.setDeptName(rs.getString("DEPT_NAME"));
				userDto.setRoleId(rs.getLong("ROLE_ID"));
				userDto.setRoleName(rs.getString("ROLE_NAME"));
				userDto.setMobile(rs.getLong("MOBILE"));
				userDto.setOtelephone(rs.getString("OTELEPHONE"));
				userDto.setHtelephone(rs.getString("HTELEPHONE"));
				userDto.setRemark(rs.getString("REMARK"));
				userDto.setTvUpdate(rs.getTimestamp("TV_UPDATE"));				
				return userDto;
			}
        	
        }
        , strBuffer.toString(), null);
        return userList;
 		
	}
	
	
	
	/**  
	 * @Title: 查询数据库中的用户信息
	 * @Description: TODO
	 * @param userName 模糊搜索与姓名匹配
	 * @return    
	 */ 
	public List<UserDto> queryUser(String userName,PageObject page){
		/*SELECT A.USER_ID,A.USER_NAME,A.PASSWORD,A.STATUS,
	       A.DEPT_ID,B.DEPT_NAME,A.ROLE_ID,C.ROLE_NAME,A.MOBILE,
	       A.OTELEPHONE,A.HTELEPHONE,A.REMARK ,A.TV_UPDATE FROM M_USER A 
	       LEFT JOIN M_DEPT B ON A.DEPT_ID = B.DEPT_ID
	       LEFT JOIN M_ROLE C ON A.ROLE_ID = C.ROLE_ID*/
		 
		StringBuffer strBuffer = new StringBuffer();
		strBuffer.append(" SELECT A.USER_ID,A.USER_NAME,A.PASSWORD,A.STATUS, ");
		strBuffer.append(" A.DEPT_ID,B.DEPT_NAME,A.ROLE_ID,C.ROLE_NAME,A.MOBILE, ");
		strBuffer.append(" A.OTELEPHONE,A.HTELEPHONE,A.REMARK ,A.TV_UPDATE FROM M_USER A ");
		strBuffer.append(" LEFT JOIN M_DEPT B ON A.DEPT_ID = B.DEPT_ID ");
		strBuffer.append(" LEFT JOIN M_ROLE C ON A.ROLE_ID = C.ROLE_ID ");

		if(StringUtils.isNotNull(userName)){
			strBuffer.append(" WHERE A.USER_NAME LIKE '%").append(userName).append("%'");
		}
		strBuffer.append(" ORDER BY A.TV_UPDATE DESC ");
		List<UserDto> userList = new ArrayList<UserDto>();
		userList = this.queryForList(new RowMapper<UserDto>(){
        	//实现接口，进行赋值
			public UserDto mappingRow(ResultSet rs, int rownum)throws SQLException {
				UserDto userDto = new UserDto();
				userDto.setUserId(rs.getLong("USER_ID"));
				userDto.setUserName(rs.getString("USER_NAME"));
				userDto.setPassword(rs.getString("PASSWORD"));
				userDto.setStatus(rs.getInt("STATUS"));
				userDto.setDeptId(rs.getLong("DEPT_ID"));
				userDto.setDeptName(rs.getString("DEPT_NAME"));
				userDto.setRoleId(rs.getLong("ROLE_ID"));
				userDto.setRoleName(rs.getString("ROLE_NAME"));
				userDto.setMobile(rs.getLong("MOBILE"));
				userDto.setOtelephone(rs.getString("OTELEPHONE"));
				userDto.setHtelephone(rs.getString("HTELEPHONE"));
				userDto.setRemark(rs.getString("REMARK"));
				userDto.setTvUpdate(rs.getTimestamp("TV_UPDATE"));				
				return userDto;
			}
        	
        }
        , strBuffer.toString(), null,page);
        return userList;
 		
	}
	
	public UserDto queryUserDetail(Long userId){
		StringBuffer strBuffer = new StringBuffer();
		strBuffer.append(" SELECT A.USER_ID,A.USER_NAME,A.PASSWORD,A.STATUS, ");
		strBuffer.append(" A.DEPT_ID,B.DEPT_NAME,A.ROLE_ID,C.ROLE_NAME,A.MOBILE, ");
		strBuffer.append(" A.OTELEPHONE,A.HTELEPHONE,A.REMARK ,A.TV_UPDATE FROM M_USER A ");
		strBuffer.append(" LEFT JOIN M_DEPT B ON A.DEPT_ID = B.DEPT_ID ");
		strBuffer.append(" LEFT JOIN M_ROLE C ON A.ROLE_ID = C.ROLE_ID ");
		strBuffer.append(" WHERE USER_ID =").append(userId);
		 
		List<UserDto> userList = new ArrayList<UserDto>();
		userList = this.queryForList(new RowMapper<UserDto>(){
        	//实现接口，进行赋值
			public UserDto mappingRow(ResultSet rs, int rownum)throws SQLException {
				UserDto user = new UserDto();
				user.setUserId(rs.getLong("USER_ID"));
				user.setUserName(rs.getString("USER_NAME"));
				user.setPassword(rs.getString("PASSWORD"));
				user.setStatus(rs.getInt("STATUS"));
 				user.setDeptId(rs.getLong("DEPT_ID"));
				user.setRoleId(rs.getLong("ROLE_ID"));
				user.setMobile(rs.getLong("MOBILE"));
				user.setOtelephone(rs.getString("OTELEPHONE"));
				user.setHtelephone(rs.getString("HTELEPHONE"));
				user.setRemark(rs.getString("REMARK"));
				user.setTvUpdate(rs.getTimestamp("TV_UPDATE"));				
				return user;
			}
        	
        }
        , strBuffer.toString(), null);
		if(userList.size()>0)
			return userList.get(0);
		else
			return new UserDto();
 		
	}
	
	public int  addUser(User user) {
		String insertSql = "INSERT INTO M_USER(USER_ID,USER_NAME , PASSWORD,STATUS,DEPT_ID,ROLE_ID,MOBILE,"
				+ "OTELEPHONE,HTELEPHONE,REMARK ,TV_UPDATE)VALUES(?,?,?,?,?,?,?,?,?,?,?)" ;
		Object[] params = new Object[]{user.getUserId(),user.getUserName(),user.getPassword(),
		                             	user.getStatus(),user.getDeptId(),user.getRoleId(),
		                             	user.getMobile(),user.getOtelephone(),user.getHtelephone(),
		                             	user.getRemark(),user.getTvUpdate()};
		return this.updateTemplate(insertSql, params);
		
	}
	
	public int  delUser(Long userId) {
		String deleteSql = "DELETE FROM  M_USER WHERE USER_ID = ? " ;
		Object[] params = new Object[]{userId};
		return this.updateTemplate(deleteSql, params);		
	}
	
	public int  updateUser(User user) {
		StringBuffer sqlBuffer = new StringBuffer();
		sqlBuffer.append(" UPDATE M_USER SET ");
		sqlBuffer.append(" USER_NAME =? , ");
		sqlBuffer.append(" PASSWORD =? , ");
		sqlBuffer.append(" STATUS =? , ");
		sqlBuffer.append(" DEPT_ID =? , ");
		sqlBuffer.append(" ROLE_ID =? , ");
		sqlBuffer.append(" MOBILE =? , ");
		sqlBuffer.append(" OTELEPHONE =? , ");
		sqlBuffer.append(" HTELEPHONE =? , ");
		sqlBuffer.append(" REMARK =? , ");
		sqlBuffer.append(" TV_UPDATE =?  ");
		sqlBuffer.append(" WHERE USER_ID =?  ");
 
		Object[] params = new Object[]{user.getUserName(),user.getPassword(),
		                             	user.getStatus(),user.getDeptId(),user.getRoleId(),
		                             	user.getMobile(),user.getOtelephone(),user.getHtelephone(),
		                             	user.getRemark(),user.getTvUpdate(),user.getUserId()};
		return this.updateTemplate(sqlBuffer.toString(), params);
		
	}
	
	public static void main(String[] args) {
		PageObject page = new PageObject(1,2,-1);
		
		UserDao userDao = new UserDao();
		List<UserDto> userList = userDao.queryUser("", page);
		
		System.out.println("userList.size()="+userList.size());
		System.out.println("page.getTotalRow()="+page.getTotalRow());

		
	}
}