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

import com.tz.jspstudy.framework.page.dto.PageObject;
import com.tz.jspstudy.framework.util.StringUtils;
import com.tz.jspstudy.sysmanage.bean.User;
import com.tz.jspstudy.sysmanage.dto.UserDto;
import com.tz.jspstudy.sysmanage.services.UserService;


/**
 * 类描述：查询用户的sevelt  
 * 类名称：com.tz.jspstudy.sysmanage.servlet.QueryUserServlet       
 * 创建人：keven  
 * 创建时间：2016年7月14日 下午3:17:17     
 * @version   V1.0
 */
public class UserAction extends HttpServlet{

	private static final long serialVersionUID = 1L;
 
	/**
	 * 每个servlet其实不管是post还是get传参数，
	 * 在进入doget,dopost之前 先是进入的这个service方法，然后service方法来判断到底是进入dopost还是doget
	 * @see javax.servlet.http.HttpServlet#service(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
 	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
 		String method = request.getParameter("method");
 		// saveUser  delUser queryUserList queryUserDetail
		if(method.equals("saveUser")){
			this.saveUser(request, response);
		}else if(method.equals("delUser")){
			this.delUser(request, response);
		}else if(method.equals("queryUserList")){
			this.queryUserList(request, response);
		}else if(method.equals("queryUserDetail")){
			this.queryUserDetail(request, response);
		}else{
			this.queryUserList(request, response);
		}		
	}
 	
 	/**
 	 * 用户删除请求
 	 * @Title: deaUser  
 	 * @Description: TODO
 	 * @param request
 	 * @param response
 	 * @throws ServletException
 	 * @throws IOException
 	 */
 	public void delUser(HttpServletRequest request, HttpServletResponse response)
 			throws ServletException, IOException{
 		String userId = request.getParameter("userId");		
		UserService userService = new UserService();
		boolean operatorFlag = userService.delUser(StringUtils.isNotNull(userId)?Long.parseLong(userId):0l);
		PrintWriter out = response.getWriter();
		if(operatorFlag)
			out.println("success");
		else
			out.println("error");
		out.flush();
		out.close();
 	}
 	
 	/**
 	 * 用户保存请求
 	 * @Title: saveUser  
 	 * @Description: TODO
 	 * @param request
 	 * @param response
 	 * @throws ServletException
 	 * @throws IOException
 	 */
 	public void saveUser(HttpServletRequest request, HttpServletResponse response)
 			throws ServletException, IOException{
 		User user = new User();
		
		String editFlag = request.getParameter("editFlag");
		String userId = request.getParameter("userId");
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String deptId = request.getParameter("deptId");
		String roleId = request.getParameter("roleId");
		String mobile = request.getParameter("mobile");
		String otelephone = request.getParameter("otelephone");
		String htelephone = request.getParameter("htelephone");
		String remark = request.getParameter("remark");
		
		user.setUserId(StringUtils.isNotNull(userId)?Long.parseLong(userId):null);
		user.setUserName(StringUtils.isNotNull(userName)?userName:null);
		user.setPassword(StringUtils.isNotNull(password)?password:null);
		user.setDeptId(StringUtils.isNotNull(deptId)?Long.parseLong(deptId):null);
		user.setRoleId(StringUtils.isNotNull(roleId)?Long.parseLong(roleId):null);
		user.setMobile(StringUtils.isNotNull(mobile)?Long.parseLong(mobile):null);
		user.setOtelephone(StringUtils.isNotNull(otelephone)?otelephone:null);
		user.setHtelephone(StringUtils.isNotNull(htelephone)?htelephone:null);
		user.setRemark(StringUtils.isNotNull(remark)?remark:null);

		
		UserService userService = new UserService();
		boolean operatorFlag =false;
		if(editFlag.equals("1"))
			operatorFlag = userService.addUser(user);
		else
			operatorFlag = userService.updateUser(user);

		PrintWriter out = response.getWriter();
		/*request.setAttribute("editFlag", editFlag);
 		request.getRequestDispatcher("/pages/sysmanage/user/userMain.jsp").forward(request, response);
		*/ 
		if(operatorFlag)
			out.println("success");
		else
			out.println("error");
		out.flush();
		out.close();
 	}
 
 	/**
 	 * 用户明细请求
 	 * @Title: queryUserDetail  
 	 * @Description: TODO
 	 * @param request
 	 * @param response
 	 * @throws ServletException
 	 * @throws IOException
 	 */
 	public void queryUserDetail(HttpServletRequest request, HttpServletResponse response)
 			throws ServletException, IOException{
 		String userId = request.getParameter("userId");
		long queryUserId =0l; 
		if(StringUtils.isNotNull(userId)){
			queryUserId = Long.parseLong(userId);
		}	
		UserService userService = new UserService();
		UserDto user= userService.queryUserDetail(queryUserId);		
        JSONObject jsonObject = JSONObject.fromObject(user);
        PrintWriter out = response.getWriter();
		out.println(jsonObject.toString());
		out.flush();
		out.close();
 	}
 	
 	public void queryUserList(HttpServletRequest request, HttpServletResponse response)
 			throws ServletException, IOException{
 		String userName = request.getParameter("userNameQuery");
 		
 		int pageNo = StringUtils.isNotNull(request.getParameter("pageNo"))?new Integer(request.getParameter("pageNo")):1;
 		int pageSize = StringUtils.isNotNull(request.getParameter("pageSize"))?new Integer(request.getParameter("pageSize")):2;
 		int totalRows = StringUtils.isNotNull(request.getParameter("totalRows"))?new Integer(request.getParameter("totalRows")):-1;

 		PageObject page = new PageObject(pageNo,pageSize,totalRows);
		UserService userService = new UserService();
		List<UserDto> userList = userService.queryUser(userName,page);		
        JSONArray jsonArray = JSONArray.fromObject(userList);
        //定义一个json对象存放数据和totalRows
        JSONObject jsonObj  = new JSONObject();
        
        jsonObj.put("totalRows", page.getTotalRow());
        jsonObj.put("dataList", jsonArray.toString());
        
        PrintWriter out = response.getWriter();
		out.println(jsonObj.toString());
		out.flush();
		out.close();
 	}
 	
	public void destroy() {
		
  	}

 
	public void init() throws ServletException {
  	}

	 
	
}
