package com.tz.jspstudy.sysmanage.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tz.jspstudy.framework.util.StringUtils;

/**
 * 用于登陆验证的filter (通过调用session来获取用户名和密码进行验证，如果不通过，跳转入登陆页面，通过进入chain下一轮)  
 * 类名称：com.tz.jspstudy.sysmanage.Filter.LoginFilter       
 * 创建人：keven  
 * 创建时间：2016年7月7日 下午3:37:41     
 * @version   V1.0
 */
public class LoginFilter implements Filter {

	private FilterConfig config;

 	public void init(FilterConfig config) throws ServletException {
		this.config = config;
	}

 	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		System.out.println("进入了登陆验证filter...");  
		//获取session参数值 --用户名和密码
 		HttpServletRequest httpRequest = (HttpServletRequest)request;
		HttpServletResponse httpResponse = (HttpServletResponse)response;
		String userName = (String)httpRequest.getSession().getAttribute("userName");
		String password = (String)httpRequest.getSession().getAttribute("password");
		if(StringUtils.isNotNull(userName)&&StringUtils.isNotNull(password)){
			//如果不为空，就证明我们在这个回话过程中登陆过，不需要再次验证用户名和密码 
			System.out.println("通过session验证...");  
			//把请求和响应传给过滤链中的下一个调用者或servlet
			chain.doFilter(httpRequest, httpResponse);
		}else{//如果为空，则表示此会话没有登陆过系统，重新跳转到登陆页面，提示用户的登陆
			System.out.println("session验证没通过.转入登陆页面..");  
			httpResponse.sendRedirect("/studyJsp/login.html");
		}
	}
	
	
	@Override
	public void destroy() {

	}

}
