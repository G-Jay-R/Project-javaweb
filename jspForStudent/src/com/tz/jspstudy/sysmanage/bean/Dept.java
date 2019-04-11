package com.tz.jspstudy.sysmanage.bean;

import java.sql.Timestamp;

/**
 * 
 * 类描述：dept对象  
 * 类名称：com.tz.jspstudy.sysmanage.bean.Dept       
 * 创建人：keven  
 * 创建时间：2016年7月29日 下午9:44:41     
 * @version   V1.0
 */
public class Dept implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	
    private Long deptId;
    private String deptName;
    private Long parentDeptId;
    private String deptDesc;
    private String deptPhone;
    private String deptAddress;
    private Long deptManagerId;
    private Integer status;
    private Timestamp tvUpdate;
	 
    
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
	 * @return the deptName  
	 */
	public String getDeptName() {
		return deptName;
	}
	/**  
	 * @param deptName the deptName to set  
	 */
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	/**  
	 * @return the parentDeptId  
	 */
	public Long getParentDeptId() {
		return parentDeptId;
	}
	/**  
	 * @param parentDeptId the parentDeptId to set  
	 */
	public void setParentDeptId(Long parentDeptId) {
		this.parentDeptId = parentDeptId;
	}
	/**  
	 * @return the deptDesc  
	 */
	public String getDeptDesc() {
		return deptDesc;
	}
	/**  
	 * @param deptDesc the deptDesc to set  
	 */
	public void setDeptDesc(String deptDesc) {
		this.deptDesc = deptDesc;
	}
	/**  
	 * @return the deptPhone  
	 */
	public String getDeptPhone() {
		return deptPhone;
	}
	/**  
	 * @param deptPhone the deptPhone to set  
	 */
	public void setDeptPhone(String deptPhone) {
		this.deptPhone = deptPhone;
	}
	/**  
	 * @return the deptAddress  
	 */
	public String getDeptAddress() {
		return deptAddress;
	}
	/**  
	 * @param deptAddress the deptAddress to set  
	 */
	public void setDeptAddress(String deptAddress) {
		this.deptAddress = deptAddress;
	}
	 
	
	/**  
	 * @return the deptManagerId  
	 */
	public Long getDeptManagerId() {
		return deptManagerId;
	}
	/**  
	 * @param deptManagerId the deptManagerId to set  
	 */
	public void setDeptManagerId(Long deptManagerId) {
		this.deptManagerId = deptManagerId;
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