package com.tz.jspstudy.sysmanage.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.util.Map;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * 类描述：  
 * 类名称：com.tz.jspstudy.sysmanage.servlet.TestServlet       
 * 创建人：keven  
 * 创建时间：2016年6月30日 下午10:01:52     
 * @version   V1.0
 */
public class TestServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("I AM GET ");
		System.out.println(request.getRequestURI());
		System.out.println(request.getRequestURL());
		System.out.println(request.getContentType());
		System.out.println(request.getContextPath());
		System.out.println(request.getCharacterEncoding());	
		doPost(request,response);
	}
	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("I AM POST ");	 
 		//如果出现乱码的问题
		response.setContentType("text/html;charset=utf-8");
		
		//获取上下文ServletContext
		ServletContext application = this.getServletContext();
		@SuppressWarnings("unchecked")
		Map<String,String> userMap = (Map<String,String>)application.getAttribute("userMap");
		
		//获取session
		String sessionUserName =(String) request.getSession().getAttribute("userName");
		String sessionPassword =(String) request.getSession().getAttribute("password");
		
		//获取cookies
		String cookieName ="";
		String cookiePassword ="";

		Cookie[] cookies = request.getCookies();
		if(cookies!=null){
			for (Cookie cookie : cookies) {
				if("userName".equals(cookie.getName())){
					cookieName = URLDecoder.decode(cookie.getValue(), "UTF-8");
				}
				if("password".equals(cookie.getName())){
					cookiePassword = URLDecoder.decode(cookie.getValue(), "UTF-8");
				}
			}
		}
		//获取浏览器输出流
		PrintWriter out =  response.getWriter();
		//数据库查询----s
		out.println("<h1><div>我的第一个Servlet应用程序!!!</div></h1>");
		out.println("<h1><span>xxxxxxxxxxxxx</span></h2>");
		out.println("<h2><span>登陆用户数:"+userMap.size()+"</span></h2>");
		out.println("<h3><span>session里面的user信息"+sessionUserName+"</span></h3>");
		out.println("<h3><span>session里面的password信息"+sessionPassword+"</span></h3>");
		
		out.println("<h4><span>cookie里面的user信息"+cookieName+"</span></h4>");
		out.println("<h5><span>cookie里面的password信息"+cookiePassword+"</span></h5>");


		out.flush();
		out.close(); 
 		
 	}
	

	public void destroy() {
		System.out.println("I AM TestServlet destory" );

	}

	public void init() throws ServletException {
		System.out.println("I AM TestServlet init " );
	}
	
	
}
