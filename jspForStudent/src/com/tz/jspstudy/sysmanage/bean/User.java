package com.tz.jspstudy.sysmanage.bean;

import java.sql.Timestamp;

public class User implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long userId;
	private String userName;
	private String password;
	private Integer status;
	private Long deptId;
	private Long roleId;
	private Long mobile;
	private String otelephone;
	private String htelephone;
	private String remark;
	private Timestamp tvUpdate;
	
	/**  
	 * @return the userId  
	 */
	public Long getUserId() {
		return userId;
	}
	/**  
	 * @param userId the userId to set  
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	/**  
	 * @return the userName  
	 */
	public String getUserName() {
		return userName;
	}
	/**  
	 * @param userName the userName to set  
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**  
	 * @return the password  
	 */
	public String getPassword() {
		return password;
	}
	/**  
	 * @param password the password to set  
	 */
	public void setPassword(String password) {
		this.password = password;
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
	 * @return the deptId  
	 */
	public Long getDeptId() {
		return deptId;
	}
	/**  
	 * @param deptId the deptId to set  
	 */
	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}
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
	 * @return the mobile  
	 */
	public Long getMobile() {
		return mobile;
	}
	/**  
	 * @param mobile the mobile to set  
	 */
	public void setMobile(Long mobile) {
		this.mobile = mobile;
	}
	/**  
	 * @return the otelephone  
	 */
	public String getOtelephone() {
		return otelephone;
	}
	/**  
	 * @param otelephone the otelephone to set  
	 */
	public void setOtelephone(String otelephone) {
		this.otelephone = otelephone;
	}
	/**  
	 * @return the htelephone  
	 */
	public String getHtelephone() {
		return htelephone;
	}
	/**  
	 * @param htelephone the htelephone to set  
	 */
	public void setHtelephone(String htelephone) {
		this.htelephone = htelephone;
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