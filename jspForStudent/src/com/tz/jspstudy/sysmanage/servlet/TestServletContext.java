package com.tz.jspstudy.sysmanage.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * 类描述：测试ServletContext的使用  
 * 类名称：com.tz.jspstudy.sysmanage.servlet.TestServletContext       
 * 创建人：keven  
 * 创建时间：2016年7月5日 下午9:40:24     
 * @version   V1.0
 */
public class TestServletContext extends HttpServlet{

	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {	
		doPost(request, response);
	}
	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//ServletContext(上下文)是一个存储类似于全局变量的空间，只要是服务（系统）没有停掉，他就永远不会消亡
		//怎么获取 
		//1：在web.xml里面配置的参数
		ServletContext application = this.getServletContext();
		System.out.println(application.getInitParameter("testContextParam1"));
		System.out.println(application.getInitParameter("testContextParam2"));
		//2:临时设置的属性
		application.setAttribute("studentName", "ssss");
		System.out.println(application.getAttribute("studentName"));
		
	}

	public void destroy() {
		 
	}
	
	public void init() throws ServletException {
		 
	}
	
	
}
