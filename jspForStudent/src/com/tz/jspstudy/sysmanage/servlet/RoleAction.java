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
import com.tz.jspstudy.sysmanage.bean.Role;
import com.tz.jspstudy.sysmanage.services.RoleService;


/**
 * 类描述：查询部门的servlet  
 * 类名称：com.tz.jspstudy.sysmanage.servlet.RoleAction       
 * 创建人：keven  
 * 创建时间：2016年7月29日 下午10:16:40     
 * @version   V1.0
 */
public class RoleAction extends HttpServlet{

	private static final long serialVersionUID = 1L;
 
	/**
	 * 每个servlet其实不管是post还是get传参数，
	 * 在进入doget,dopost之前 先是进入的这个service方法，然后service方法来判断到底是进入dopost还是doget
	 * @see javax.servlet.http.HttpServlet#service(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
 	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
 		String method = request.getParameter("method");
 		if(method.equals("saveRole")){
			this.saveRole(request, response);
		}else if(method.equals("delRole")){
			this.delRole(request, response);
		}else if(method.equals("queryRoleList")){
			this.queryRoleList(request, response);
		}else if(method.equals("queryRoleDetail")){
			this.queryRoleDetail(request, response);
		}else{
			this.queryRoleList(request, response);
		}		
	}
 	
 	
 	public void delRole(HttpServletRequest request, HttpServletResponse response)
 			throws ServletException, IOException{
 		String roleId = request.getParameter("roleId");		
		RoleService roleService = new RoleService();
		boolean operatorFlag = roleService.delRole(StringUtils.isNotNull(roleId)?Long.parseLong(roleId):0l);
		PrintWriter out = response.getWriter();
		if(operatorFlag)
			out.println("success");
		else
			out.println("error");
		out.flush();
		out.close();
 	}
 	
 	
 	public void saveRole(HttpServletRequest request, HttpServletResponse response)
 			throws ServletException, IOException{
 		Role role = new Role();
 		String editRoleFlag = request.getParameter("editRoleFlag");
		 
		String roleId = request.getParameter("roleId");
		String roleName = request.getParameter("roleName");
		String remark = request.getParameter("remark");

		
		role.setRoleId(StringUtils.isNotNull(roleId)?Long.parseLong(roleId):null);
		role.setRoleName(StringUtils.isNotNull(roleName)?roleName:null);
 		role.setRemark(StringUtils.isNotNull(remark)?remark:null);
		 
		RoleService roleService = new RoleService();
		boolean operatorFlag =false;
		if(editRoleFlag.equals("1"))
			operatorFlag = roleService.addRole(role);
		else
			operatorFlag = roleService.updateRole(role);

		PrintWriter out = response.getWriter();
		 
		if(operatorFlag)
			out.println("success");
		else
			out.println("error");
		out.flush();
		out.close();
 	}
 
 	
 	public void queryRoleDetail(HttpServletRequest request, HttpServletResponse response)
 			throws ServletException, IOException{
 		String roleId = request.getParameter("roleId");
		long queryRoleId =0l; 
		if(StringUtils.isNotNull(roleId)){
			queryRoleId = Long.parseLong(roleId);
		}	
		RoleService roleService = new RoleService();
		Role role= roleService.queryRoleDetail(queryRoleId);		
        JSONObject jsonObject = JSONObject.fromObject(role);
        PrintWriter out = response.getWriter();
		out.println(jsonObject.toString());
		out.flush();
		out.close();
 	}
 	
 	public void queryRoleList(HttpServletRequest request, HttpServletResponse response)
 			throws ServletException, IOException{
 		String roleName = request.getParameter("roleName");
		RoleService roleService = new RoleService();
		List<Role> roleList = roleService.queryRoleList(roleName);		
        JSONArray jsonArray = JSONArray.fromObject(roleList);
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
