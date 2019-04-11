package com.tz.jspstudy.sysmanage.bean;

import java.sql.Timestamp;

/**
 * 
 * 类描述：roLE对象  
 * 类名称：com.tz.jspstudy.sysmanage.bean.Role       
 * 创建人：keven  
 * 创建时间：2016年7月29日 下午9:44:41     
 * @version   V1.0
 */
public class Role implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	
    private Long roleId;
    private String roleName;
    private Integer status;
    private String remark;
    private Timestamp tvUpdate;
	/**  
	 * @return the roleId  
	 */
	public Long getRoleId() {
		return roleId;
	}
	/**  
	 * @param roleId the roleId to set  
	 */
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	/**  
	 * @return the roleName  
	 */
	public String getRoleName() {
		return roleName;
	}
	/**  
	 * @param roleName the roleName to set  
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	/**  
	 * @return the status  
	 */
	public Integer getStatus() {
		return status;
	}
	/**  
	 * @param status the status to set  
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**  
	 * @return the remark  
	 */
	public String getRemark() {
		return remark;
	}
	/**  
	 * @param remark the remark to set  
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**  
	 * @return the tvUpdate  
	 */
	public Timestamp getTvUpdate() {
		return tvUpdate;
	}
	/**  
	 * @param tvUpdate the tvUpdate to set  
	 */
	public void setTvUpdate(Timestamp tvUpdate) {
		this.tvUpdate = tvUpdate;
	}
    
    
	 
}