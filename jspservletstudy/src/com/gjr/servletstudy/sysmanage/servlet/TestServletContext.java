package com.gjr.servletstudy.sysmanage.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * 用于测试servletcontext的servlet
 */
public class TestServletContext extends HttpServlet{


	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req,resp);
	}


	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		ServletContext application = this.getServletContext();
		application.getInitParameter("testContextParam1");
		application.getInitParameter("te stContextParam2");

		/*
		 * 在上下文对象中放入对象
		 * 1.在web.xml配置数据
		 * 2.在任意一个servlet里面可以手动设置SevrletContext的属性，并赋予属性的值
		 * 3.在系统启动的时候就放入一些全局变量到ServletContext
		 * 引入一个servlet另一种应用方式<load-on-startup>
		 * 要解决系统启动启动的时候，怎么去初始化servletcontext
		 * 1.系统启动的时候，访问某个servlet
		 * 2.访问servlet，将数据放入servletcontext
		 */
		application.setAttribute("studentName","张三");
		System.out.println(application.getAttribute("studentName"));
		
		@SuppressWarnings("unchecked")
		List<String> nameList = (List<String>)application.getAttribute("dictList");
		for(String name:nameList){
			System.out.println("学生的名字是"+name);
		}
	}

	public void destroy() {

	}


	public void init() throws ServletException {

	}


}