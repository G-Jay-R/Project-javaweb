package com.tz.jspstudy.sysmanage.servlet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;


/**
 * 系统启动初始化servlet
 * 类描述：  
 * 类名称：com.tz.jspstudy.sysmanage.servlet.InitServlet       
 * 创建人：keven  
 * 创建时间：2016年7月4日 下午3:43:56     
 * @version   V1.0
 */
public class InitServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
 
	public void init() throws ServletException {
		System.out.println("I AM InitServlet init " );
		//系统启动时 就把一些系统信息放入上下文中，供系统里面所有servlet共享
		// 获得上下文对象
		ServletContext application = this.getServletContext();
		
		//比如将我们的一些系统字典放入一个对象，供系统使用
		List<Object> dictList = new ArrayList<Object>();
		application.setAttribute("dictList", dictList);
		
 		//比如我们创建一个空对象，用以存储用户的在线记录 ，当每次登陆（访问loginServlet）就在这个对象里面加入信息。
		Map<String,String> userMap = new HashMap<String,String>();
		application.setAttribute("userMap", userMap);
	}
	
	
}
