package com.tz.jspstudy.sysmanage.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.tz.jspstudy.framework.util.StringUtils;
import com.tz.jspstudy.sysmanage.bean.Dept;
import com.tz.jspstudy.sysmanage.dto.DeptDto;
import com.tz.jspstudy.sysmanage.services.DeptService;


/**
 * 类描述：查询部门的servlet  
 * 类名称：com.tz.jspstudy.sysmanage.servlet.DeptAction       
 * 创建人：keven  
 * 创建时间：2016年7月29日 下午10:16:40     
 * @version   V1.0
 */
public class DeptAction extends HttpServlet{

	private static final long serialVersionUID = 1L;
 
	/**
	 * 每个servlet其实不管是post还是get传参数，
	 * 在进入doget,dopost之前 先是进入的这个service方法，然后service方法来判断到底是进入dopost还是doget
	 * @see javax.servlet.http.HttpServlet#service(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
 	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
 		String method = request.getParameter("method");
 		if(method.equals("saveDept")){
			this.saveDept(request, response);
		}else if(method.equals("delDept")){
			this.delDept(request, response);
		}else if(method.equals("queryDeptList")){
			this.queryDeptList(request, response);
		}else if(method.equals("queryDeptDetail")){
			this.queryDeptDetail(request, response);
		}else{
			this.queryDeptList(request, response);
		}		
	}
 	
 	
 	public void delDept(HttpServletRequest request, HttpServletResponse response)
 			throws ServletException, IOException{
 		String deptId = request.getParameter("deptId");		
		DeptService deptService = new DeptService();
		boolean operatorFlag = deptService.delDept(StringUtils.isNotNull(deptId)?Long.parseLong(deptId):0l);
		PrintWriter out = response.getWriter();
		if(operatorFlag)
			out.println("success");
		else
			out.println("error");
		out.flush();
		out.close();
 	}
 	
 	
 	public void saveDept(HttpServletRequest request, HttpServletResponse response)
 			throws ServletException, IOException{
 		Dept dept = new Dept();
 		String editDeptFlag = request.getParameter("editDeptFlag");
		 
		String deptId = request.getParameter("deptId");
		String deptName = request.getParameter("deptName");
		String parentDeptId = request.getParameter("parentDeptId");
		String deptDesc = request.getParameter("deptDesc");
		String deptPhone = request.getParameter("deptPhone");
		String deptAddress = request.getParameter("deptAddress");
		String deptManagerId = request.getParameter("deptManagerId");
		
		dept.setDeptId(StringUtils.isNotNull(deptId)?Long.parseLong(deptId):null);
		dept.setDeptName(StringUtils.isNotNull(deptName)?deptName:null);
		dept.setParentDeptId(StringUtils.isNotNull(parentDeptId)?Long.parseLong(parentDeptId):null);
		dept.setDeptDesc(StringUtils.isNotNull(deptDesc)?deptDesc:null);
		dept.setDeptPhone(StringUtils.isNotNull(deptPhone)?deptPhone:null);
		dept.setDeptAddress(StringUtils.isNotNull(deptAddress)?deptAddress:null);
		dept.setDeptManagerId(StringUtils.isNotNull(deptManagerId)?Long.parseLong(deptManagerId):null);
		
		DeptService deptService = new DeptService();
		boolean operatorFlag =false;
		if(editDeptFlag.equals("1"))
			operatorFlag = deptService.addDept(dept);
		else
			operatorFlag = deptService.updateDept(dept);

		PrintWriter out = response.getWriter();
		 
		if(operatorFlag)
			out.println("success");
		else
			out.println("error");
		out.flush();
		out.close();
 	}
 
 	
 	public void queryDeptDetail(HttpServletRequest request, HttpServletResponse response)
 			throws ServletException, IOException{
 		String deptId = request.getParameter("deptId");
		long queryDeptId =0l; 
		if(StringUtils.isNotNull(deptId)){
			queryDeptId = Long.parseLong(deptId);
		}	
		DeptService deptService = new DeptService();
		Dept dept= deptService.queryDeptDetail(queryDeptId);		
        JSONObject jsonObject = JSONObject.fromObject(dept);
        PrintWriter out = response.getWriter();
		out.println(jsonObject.toString());
		out.flush();
		out.close();
 	}
 	
 	public void queryDeptList(HttpServletRequest request, HttpServletResponse response)
 			throws ServletException, IOException{
 		String deptName = request.getParameter("deptName");
		DeptService deptService = new DeptService();
		List<DeptDto> deptList = deptService.queryDeptList(deptName);		
        JSONArray jsonArray = JSONArray.fromObject(deptList);
        PrintWriter out = response.getWriter();
		out.println(jsonArray.toString());
		out.flush();
		out.close();
 	}
 	
	public void destroy() {
		
  	}

 
	public void init() throws ServletException {
		
  	}

	 
	
}
