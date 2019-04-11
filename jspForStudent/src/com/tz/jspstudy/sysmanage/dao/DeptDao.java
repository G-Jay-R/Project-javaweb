package com.tz.jspstudy.sysmanage.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tz.jspstudy.framework.dbUtil.TzJdbcTemplate;
import com.tz.jspstudy.framework.dbUtil.inteface.RowMapper;
import com.tz.jspstudy.framework.util.StringUtils;
import com.tz.jspstudy.sysmanage.bean.Dept;
import com.tz.jspstudy.sysmanage.dto.DeptDto;

/**
 * 类描述：部门管理增删改查dao方法  
 * 类名称：com.tz.jspstudy.sysmanage.dao.DeptDao       
 * 创建人：keven  
 * 创建时间：2016年7月29日 下午9:38:15     
 * @version   V1.0
 */
public class DeptDao  extends TzJdbcTemplate{
	 
 
	/**  
	 * @Title: 查询数据库中的部门信息
	 * @Description: TODO
	 * @param userName 模糊搜索与部门名称匹配
	 * @return    
	 */ 
	public List<DeptDto> queryDeptList(String deptName){	       
		/*SELECT A.DEPT_ID,A.DEPT_NAME,A.PARENT_DEPT_ID,B.DEPT_NAME PARENT_DEPT_NAME,
		       A.DEPT_DESC,A.DEPT_PHONE,A.DEPT_ADDRESS ,
					 A.DEPT_MANAGER_ID,C.USER_NAME DEPT_MANAGER_NAME,
		       A.STATUS,A.TV_UPDATE FROM M_DEPT A
		       LEFT JOIN M_DEPT B ON A.PARENT_DEPT_ID = B.DEPT_ID
		       LEFT JOIN M_USER C ON A.DEPT_MANAGER_ID =C.USER_ID*/
		StringBuffer strBuffer = new StringBuffer();
		strBuffer.append(" SELECT A.DEPT_ID,A.DEPT_NAME,A.PARENT_DEPT_ID,B.DEPT_NAME PARENT_DEPT_NAME, ");
		strBuffer.append(" A.DEPT_DESC,A.DEPT_PHONE,A.DEPT_ADDRESS , ");
		strBuffer.append(" A.DEPT_MANAGER_ID,C.USER_NAME DEPT_MANAGER_NAME, ");
		strBuffer.append(" A.STATUS,A.TV_UPDATE FROM M_DEPT A ");
		strBuffer.append(" LEFT JOIN M_DEPT B ON A.PARENT_DEPT_ID = B.DEPT_ID ");
		strBuffer.append(" LEFT JOIN M_USER C ON A.DEPT_MANAGER_ID =C.USER_ID ");
	
	
		if(StringUtils.isNotNull(deptName)){
			strBuffer.append(" WHERE DEPT_NAME LIKE '%").append(deptName).append("%'");
		}
		strBuffer.append(" ORDER BY TV_UPDATE DESC ");
		List<DeptDto> deptList = new ArrayList<DeptDto>();
		deptList = this.queryForList(new RowMapper<DeptDto>(){
        	//实现接口，进行赋值
			public DeptDto mappingRow(ResultSet rs, int rownum)throws SQLException {
				DeptDto deptDto = new DeptDto();
				deptDto.setDeptId(rs.getLong("DEPT_ID"));
				deptDto.setDeptName(rs.getString("DEPT_NAME"));
				deptDto.setParentDeptId(rs.getLong("PARENT_DEPT_ID"));
				deptDto.setParentDeptName(rs.getString("PARENT_DEPT_NAME"));
				deptDto.setDeptDesc(rs.getString("DEPT_DESC"));
				deptDto.setDeptPhone(rs.getString("DEPT_PHONE"));
				deptDto.setDeptAddress(rs.getString("DEPT_ADDRESS"));
				deptDto.setDeptManagerId(rs.getLong("DEPT_MANAGER_ID"));
				deptDto.setDeptManagerName(rs.getString("DEPT_MANAGER_NAME"));
				deptDto.setStatus(rs.getInt("STATUS")); 
				deptDto.setTvUpdate(rs.getTimestamp("TV_UPDATE"));				
				return deptDto;
			}
        	
        }
        , strBuffer.toString(), null);
        return deptList;
 		
	}
	
	/**
	 * 获取部门明细信息的dao方法
	 * @Title: queryDeptDetail  
	 * @Description: TODO
	 * @param deptId
	 * @return
	 */
	public Dept queryDeptDetail(Long deptId){
		String sql = "SELECT DEPT_ID,DEPT_NAME,PARENT_DEPT_ID,DEPT_DESC,DEPT_PHONE,DEPT_ADDRESS ,"
				+ "DEPT_MANAGER_ID,STATUS,TV_UPDATE FROM M_DEPT ";
		sql = sql+ " WHERE DEPT_ID ="+deptId;
		 
		List<Dept> deptList = new ArrayList<Dept>();
		deptList = this.queryForList(new RowMapper<Dept>(){
        	//实现接口，进行赋值
			public Dept mappingRow(ResultSet rs, int rownum)throws SQLException {
				Dept dept = new Dept();
				dept.setDeptId(rs.getLong("DEPT_ID"));
				dept.setDeptName(rs.getString("DEPT_NAME"));
				dept.setParentDeptId(rs.getLong("PARENT_DEPT_ID"));
				dept.setDeptDesc(rs.getString("DEPT_DESC"));
				dept.setDeptPhone(rs.getString("DEPT_PHONE"));
				dept.setDeptAddress(rs.getString("DEPT_ADDRESS"));
				dept.setDeptManagerId(rs.getLong("DEPT_MANAGER_ID"));
				dept.setStatus(rs.getInt("STATUS")); 
				dept.setTvUpdate(rs.getTimestamp("TV_UPDATE"));				
				return dept;
			}
        	
        }
        , sql, null);
		if(deptList.size()>0)
			return deptList.get(0);
		else
			return new Dept();
 		
	}
	
	public int  addDept(Dept dept) {
		String insertSql = "INSERT INTO M_DEPT(DEPT_ID,DEPT_NAME,PARENT_DEPT_ID,DEPT_DESC,DEPT_PHONE,DEPT_ADDRESS ,"
				+ "DEPT_MANAGER_ID,STATUS,TV_UPDATE)VALUES(?,?,?,?,?,?,?,?,?)" ;
		Object[] params = new Object[]{dept.getDeptId(),dept.getDeptName(),dept.getParentDeptId(),
		                             	dept.getDeptDesc(),dept.getDeptPhone(),dept.getDeptAddress(),
 		                             	dept.getDeptManagerId(),dept.getStatus(),dept.getTvUpdate()};
		return this.updateTemplate(insertSql, params);
		
	}
	
	public int  delDept(Long deptId) {
		String deleteSql = "DELETE FROM M_DEPT WHERE DEPT_ID = ? " ;
		Object[] params = new Object[]{deptId};
		return this.updateTemplate(deleteSql, params);		
	}
	
	public int  updateDept(Dept dept) {
		StringBuffer sqlBuffer = new StringBuffer();
		sqlBuffer.append(" UPDATE M_DEPT SET ");
		sqlBuffer.append(" DEPT_NAME =? , ");
		sqlBuffer.append(" PARENT_DEPT_ID =? , ");
		sqlBuffer.append(" DEPT_DESC =? , ");
		sqlBuffer.append(" DEPT_PHONE =? , ");
		sqlBuffer.append(" DEPT_ADDRESS =? , ");
		sqlBuffer.append(" DEPT_MANAGER_ID =? , ");
		sqlBuffer.append(" STATUS =? , ");
		sqlBuffer.append(" TV_UPDATE =?  ");
		sqlBuffer.append(" WHERE DEPT_ID =?  ");
 
		Object[] params = new Object[]{dept.getDeptName(),dept.getParentDeptId(),
             							dept.getDeptDesc(),dept.getDeptPhone(),dept.getDeptAddress(),
             							  dept.getDeptManagerId(),dept.getStatus(),dept.getTvUpdate(),dept.getDeptId()};
		return this.updateTemplate(sqlBuffer.toString(), params);
		
	}
	
	public static void main(String[] args) {
		 
	} 
}