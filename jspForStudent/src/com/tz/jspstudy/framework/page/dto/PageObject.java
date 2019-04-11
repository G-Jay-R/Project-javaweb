package com.tz.jspstudy.framework.page.dto;

/**
 * 分页对象
 * totalRow 某次查询的总记录数  -1就表示这个分页查询是第一次使用 
 * pageNo 当前查询页码 
 * pageSize  每页记录条数   -1 代表查所有的数据
 * begRow 页起始记录行数
 * endRow 页的截止记录行数
 * 类描述：  
 * 类名称：com.tz.jspstudy.framework.page.dto.PageObject       
 * 创建人：keven  
 * 创建时间：2016年8月10日 下午8:44:58     
 * @version   V1.0
 */
public class PageObject implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	
	private int totalRow=-1;
	private int pageNo;
	private int pageSize;
	private int begRow;
	private int endRow;
	
	private final int DEFAULT_PAGESIZE=40;
	private final int MAX_PAGESIZE=1000;

	
	/**  
	 * @return the mAX_PAGESIZE  
	 */
	public int getMAX_PAGESIZE() {
		return MAX_PAGESIZE;
	}


	public PageObject(int pageNo,int totalRows){
		this.totalRow = totalRows;
		this.pageNo = pageNo;
		init();
		
	}
	
	
	public PageObject(int pageNo,int pageSize,int totalRows){
		this.totalRow = totalRows;
		this.pageNo = pageNo;
		this.pageSize = pageSize;
		init();
	}
	
	
	/**
	 * 根据构造数据初始页对象
	 */
	private void init() {
		//校正totalRows && pageNo && pageSize
		if (pageNo <= 0) pageNo = 1;
		if (pageSize == 0) pageSize = DEFAULT_PAGESIZE;
		if (pageSize > MAX_PAGESIZE) pageSize = MAX_PAGESIZE;
		if (pageSize > 0){
			begRow = (pageNo - 1 ) * pageSize + 1;
			endRow = pageNo * pageSize;
		} else {
			begRow = 1;
			endRow = MAX_PAGESIZE;
		}
	}
	
	
	
	/**  
	 * @return the totalRow  
	 */
	public int getTotalRow() {
		return totalRow;
	}
	/**  
	 * @param totalRow the totalRow to set  
	 */
	public void setTotalRow(int totalRow) {
		this.totalRow = totalRow;
	}
	/**  
	 * @return the pageNo  
	 */
	public int getPageNo() {
		return pageNo;
	}
	/**  
	 * @param pageNo the pageNo to set  
	 */
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	/**  
	 * @return the pageSize  
	 */
	public int getPageSize() {
		return pageSize;
	}
	/**  
	 * @param pageSize the pageSize to set  
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	/**  
	 * @return the begRow  
	 */
	public int getBegRow() {
		return begRow;
	}
	/**  
	 * @param begRow the begRow to set  
	 */
	public void setBegRow(int begRow) {
		this.begRow = begRow;
	}
	/**  
	 * @return the endRow  
	 */
	public int getEndRow() {
		return endRow;
	}
	/**  
	 * @param endRow the endRow to set  
	 */
	public void setEndRow(int endRow) {
		this.endRow = endRow;
	}


	/**  
	 * @return the dEFAULT_PAGESIZE  
	 */
	public int getDEFAULT_PAGESIZE() {
		return DEFAULT_PAGESIZE;
	}

 
	
	
}