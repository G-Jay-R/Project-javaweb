package com.tz.jspstudy.sysmanage.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tz.jspstudy.framework.util.StringUtils;
import com.tz.jspstudy.sysmanage.services.UserService;

/**
 * 
 * 类描述：  登陆SERVLET
 * 类名称：com.tz.jspstudy.sysmanage.servlet.LoginServlet       
 * 创建人：keven  
 * 创建时间：2016年6月29日 下午3:46:26     
 * @version   V1.0
 */
public class LoginServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1)
			throws ServletException, IOException {
		System.out.println("loginServlet.service");
	}
		
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("I AM GET ");
		doPost(request,response);
	}
	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
 		System.out.println("I AM POST ");
 		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		PrintWriter out = response.getWriter();
		if(StringUtils.isNotNull(userName)&&StringUtils.isNotNull(password)){
			//通过数据库验证成功则返回true
			UserService userService = new UserService();
			if(userService.loginUser(userName, password)){
				out.print("success");
			}else{
				out.print("error");
			}
		}
		out.flush();
		out.close();
		/*System.out.println("servlet相对路径："+request.getRequestURI());
		System.out.println("servlet绝对路径："+request.getRequestURL());
		System.out.println("项目路径"+request.getContextPath());
		System.out.println("客户端IP地址："+request.getRemoteAddr());
		System.out.println("服务器IP地址"+request.getRemoteHost());*/
		//设置请求的编码
		/*request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");*/
		
		//如果是一个表单信息 enumeration本身是一个接口 不像list map是一种数据结构
		/*Enumeration<String> parameters =  request.getParameterNames();
		while(parameters.hasMoreElements()){
			String paremeterName = parameters.nextElement();
			String paremeterValue = request.getParameter(paremeterName);
			System.out.println("paremeterName="+paremeterName+"===paremeterValue="+paremeterValue);
 		}
		
		//如果你知道所有属性的名称，则采用以下方法获取属性的值
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		
		if(StringUtils.isNotNull(userName)&&StringUtils.isNotNull(password)){
			//通过数据库验证成功则返回true
			UserService userService = new UserService();
			if(userService.loginUser(userName, password)){
				//登陆成功后 获取servletContext变量,每次登陆都成功都把用户加入登陆用户列表
				ServletContext application = this.getServletContext();
				@SuppressWarnings("unchecked")
				Map<String,String> userMap = (Map<String,String>)application.getAttribute("userMap");
				userMap.put(userName, userName);
				
				
				//登陆成功后 放入session中，那么其他非登陆页面就可以根据session来判断
				HttpSession session = request.getSession();
				session.setAttribute("userName", userName);
				//此处建议用可逆的加密算法将密码加密
				session.setAttribute("password", password);
				//session存活时间 单位是秒  设置-1为永久有效  当然也可以在配置文件web.xml中设置统一的session存活时间
				session.setMaxInactiveInterval(1*3600);
				
				//登陆成功后同样可以将用户信息放入cookie，存放到客户的浏览器上
				
				//存储在客户端(浏览器),
				//注意 :Cookie不能直接写入中文,java.net.URLEncoder
				//URLEncoder:encode(str,charset) 编码
				//URLDecoder:decode(str,charset) 解码
				String encodeName = URLEncoder.encode(userName,"UTF-8"); //%E7%9A%AE%E5%9B%8A	
				Cookie cookieUser = new Cookie("userName",encodeName);
				//cookie失效时效,单位是:秒
				cookieUser.setMaxAge(60*60*24);//一天
				//response将cookie写入到浏览器
				response.addCookie(cookieUser);
				String encodePassword = java.net.URLEncoder.encode(password,"UTF-8"); //%E7%9A%AE%E5%9B%8A	
				Cookie cookiePassword = new Cookie("password",encodePassword);
				//cookie失效时效,单位是:秒
				cookiePassword.setMaxAge(60*60*24);//一天
				//response将cookie写入到浏览器
				response.addCookie(cookiePassword);		
				//页面重定向
				response.sendRedirect("pages/main/main.html"); 
			}else{
				//页面请求分发
				request.getRequestDispatcher("error.html").forward(request, response);
			}
		}else{
			response.sendRedirect("error.html");
		}*/
		
	}
	

	public void destroy() {
		System.out.println("I AM loginServlet destory" );

	}

	public void init() throws ServletException {
		System.out.println("I AM loginServlet init " );
	}
	
	
}
