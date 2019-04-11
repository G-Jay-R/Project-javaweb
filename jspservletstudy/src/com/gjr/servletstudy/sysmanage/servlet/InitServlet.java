package com.gjr.servletstudy.sysmanage.servlet;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;


		/*  系统启动初始化servlet  */
public class InitServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	public void init() throws ServletException {
		System.out.println("I AM InitServlet init ! ");
		//系统启动时就把一些系统信息放入上下文中，供系统里面所有servlet共享
		//获取上下文对象
		ServletContext application = this.getServletContext();
		
		//比如将我们的一些系统字典放入一个对象，供系统使用
		List<String> dictList = new ArrayList<String>();
		String name1 ="廖隽";
		String name2 ="鲜有";
		String name3 ="赖子";
		dictList.add(name1);dictList.add(name2);dictList.add(name3);		
		application.setAttribute("dictList", dictList);
		
		//创建一个空对象，用于存储用户的在线记录，当每次登陆（访问loginservlet）就在这个对象加入信息
		/**
		 * 做一个用户登陆人数统计
		 * 思路：  1.在系统启动的时候，往ServletContxet设置一个属性，放入一个空对象备用
		 * 		2.每次用户登陆（loginServlet）的时候
		 * 		     我们就会调用ServletContext上下文对象，并将用户记录放入我们准备好的对象中
		 * 		3.每次用户登出（logouServlet）的时候，我们也要调用，然后清除此登陆用户信息
		 * 		4.在我们需要展示人数的servlet里面调用ServletContext，获取所有用户信息
		 */
		List<String> userList = new LinkedList<String>();
		application.setAttribute("userList", userList);
	}
	
}