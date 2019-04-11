package com.tz.jspstudy.sysmanage.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.tz.jspstudy.framework.dbUtil.TzJdbcTemplate;
import com.tz.jspstudy.framework.dbUtil.inteface.RowMapper;
import com.tz.jspstudy.framework.util.StringUtils;
import com.tz.jspstudy.sysmanage.bean.Role;

/**
 * 类描述：角色管理增删改查dao方法  
 * 类名称：com.tz.jspstudy.sysmanage.dao.RoleDao       
 * 创建人：keven  
 * 创建时间：2016年7月29日 下午9:38:15     
 * @version   V1.0
 */
public class RoleDao extends TzJdbcTemplate{
	 
 
	/**  
	 * @Title: 查询数据库中的角色信息
	 * @Description: TODO
	 * @param userName 模糊搜索与角色名称匹配
	 * @return    
	 */ 
	public List<Role> queryRoleList(String roleName){		  
		String sql = "SELECT ROLE_ID,ROLE_NAME,STATUS,REMARK,TV_UPDATE FROM M_ROLE ";
 		if(StringUtils.isNotNull(roleName)){
			sql = sql+ " WHERE ROLE_NAME LIKE '%"+roleName+"%'";
		}
		sql = sql+" ORDER BY TV_UPDATE DESC ";
		List<Role> roleList = new ArrayList<Role>();
		roleList = this.queryForList(new RowMapper<Role>(){
        	//实现接口，进行赋值
			public Role mappingRow(ResultSet rs, int rownum)throws SQLException {
				Role role = new Role();
				role.setRoleId(rs.getLong("ROLE_ID"));
				role.setRoleName(rs.getString("ROLE_NAME"));
				role.setStatus(rs.getInt("STATUS")); 
				role.setRemark(rs.getString("REMARK"));
				role.setTvUpdate(rs.getTimestamp("TV_UPDATE"));				
				return role;
			}
        	
        }
        , sql, null);
        return roleList;
 		
	}
	
	/**
	 * 获取角色明细信息的dao方法
	 * @Title: queryRoleDetail  
	 * @Description: TODO
	 * @param roleId
	 * @return
	 */
	public Role queryRoleDetail(Long roleId){
		String sql = "SELECT ROLE_ID,ROLE_NAME,STATUS,REMARK,TV_UPDATE FROM M_ROLE  ";
		sql = sql+ " WHERE ROLE_ID ="+roleId;
		 
		List<Role> roleList = new ArrayList<Role>();
		roleList = this.queryForList(new RowMapper<Role>(){
        	//实现接口，进行赋值
			public Role mappingRow(ResultSet rs, int rownum)throws SQLException {
				Role role = new Role();
				role.setRoleId(rs.getLong("ROLE_ID"));
				role.setRoleName(rs.getString("ROLE_NAME"));
				role.setStatus(rs.getInt("STATUS")); 
				role.setRemark(rs.getString("REMARK"));
				role.setTvUpdate(rs.getTimestamp("TV_UPDATE"));				
				return role;
			}
        	
        }
        , sql, null);
		if(roleList.size()>0)
			return roleList.get(0);
		else
			return new Role();
 		
	}
	
	public int  addRole(Role role) {
		String insertSql = "INSERT INTO M_ROLE(ROLE_ID,ROLE_NAME,STATUS,REMARK,TV_UPDATE)VALUES(?,?,?,?,?)" ;
		Object[] params = new Object[]{role.getRoleId(),role.getRoleName(),
 		                             	role.getStatus(),role.getRemark(),role.getTvUpdate()};
		return this.updateTemplate(insertSql, params);
		
	}
	
	public int  delRole(Long roleId) {
		String deleteSql = "DELETE FROM M_ROLE WHERE ROLE_ID = ? " ;
		Object[] params = new Object[]{roleId};
		return this.updateTemplate(deleteSql, params);		
	}
	
	public int  updateRole(Role role) {
		StringBuffer sqlBuffer = new StringBuffer();
		sqlBuffer.append(" UPDATE M_ROLE SET ");
		sqlBuffer.append(" ROLE_NAME =? , ");
		sqlBuffer.append(" STATUS =? , ");
		sqlBuffer.append(" REMARK =? , ");
		sqlBuffer.append(" TV_UPDATE =?  ");
		sqlBuffer.append(" WHERE ROLE_ID =?  ");
 
		Object[] params = new Object[]{role.getRoleName(),role.getStatus(),role.getRemark(),role.getTvUpdate(),role.getRoleId()};
		return this.updateTemplate(sqlBuffer.toString(), params);
		
	}
	
	public static void main(String[] args) {
		RoleDao roleDao = new RoleDao();
		List<Role> roleList = roleDao.queryRoleList("");
		System.out.println(roleList.size());
	} 
}