package com.gjr.servletstudy.sysmanage.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req,resp);
	}


	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("I am TestServlt's dopost method");
		
		ServletContext application = this.getServletContext();
		@SuppressWarnings("unchecked")
		List<String> userList=(List<String>)application.getAttribute("userList");
		
		//
		PrintWriter out =resp.getWriter();
		//数据库查询----s
		out.println("<h1><div>我的第一个Servlet应用程序！！！</div></h1>");
		out.println("<span>xxxxxxxxxxx</span>");
		out.println("<span>登陆用户数："+userList.size()+"</span>");		
		//out.println("<span>session里面的user信息"+req.getSession().getAttribute("user")+"</span>");
		
		out.flush();
		out.close();
		
	}


	public void destroy() {
		
	}


	public void init() throws ServletException {
		System.out.println("I am TestServlt's destroy");
	}
	
}