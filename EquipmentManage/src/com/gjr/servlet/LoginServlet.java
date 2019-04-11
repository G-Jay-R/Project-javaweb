package com.gjr.servlet;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gjr.pojo.Admin;
import com.gjr.pojo.User;
import com.gjr.service.AdminService;
import com.gjr.service.UserService;
import com.gjr.service.impl.AdminServiceimpl;
import com.gjr.service.impl.UserServiceimpl;

public class LoginServlet extends HttpServlet {


	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");	//设置请求编码格式
		resp.setContentType("text/html;charset=utf-8"); //设置响应编码格式
		String oper=req.getParameter("oper");	//获取附带信息，辨别是管理员还是用户
		if(oper.equals("admin"))
		{
			CheckadimLogin(req,resp);
		}else if(oper.equals("user")){
			CheckuserLogin(req,resp);
		}else{
			System.out.print("Error!!!");
		}
	}
	//管理员验证登录
	private void CheckadimLogin(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		//获取请求信息
		String aname=req.getParameter("aname");
		String apwd=req.getParameter("apassword");
			//处理请求信息
				//获取service层对象
		AdminService as=new AdminServiceimpl();
		//校验
		Admin a=as.checkAdminLoginServcie(aname,apwd);
		if(a!=null){
			//将登录成功的用户名和密码存入session
			HttpSession se=req.getSession();
			se.setAttribute("aname", aname);
			//session存活时间，单位是秒 设置-1为永久有效
			se.setMaxInactiveInterval(1*10);
			resp.sendRedirect("/equipmng/pages/admin1.jsp");
		}else{
			//添加标识符到request中
			req.setAttribute("flag",0);
			//请求转发，/表示根目录，这样写即可
			req.getRequestDispatcher("/adminlogin.jsp").forward(req, resp);
		}
		
	}
	
	//用户验证登录
	private void CheckuserLogin(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		//获取请求信息
		String uname=req.getParameter("username");
		String upwd=req.getParameter("upassword");
		System.out.print(uname+"+"+upwd);
		//获取service层对象
		UserService us=new UserServiceimpl();
		User u=us.checkUserloginService(uname, upwd);
		if(u!=null){
			//将登录成功的用户名和密码存入session
			HttpSession se=req.getSession();
			se.setAttribute("uname", uname);
			//session存活时间，单位是秒 设置-1为永久有效
			//se.setMaxInactiveInterval(1*10);
			resp.sendRedirect("/equipmng/pages/user1.jsp");
		}else{
			//添加标识符到request中
			req.setAttribute("flag",0);
			req.getRequestDispatcher("/userlogin.jsp").forward(req, resp);
		}
		
	}


	
}
