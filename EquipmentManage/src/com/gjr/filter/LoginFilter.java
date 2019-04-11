package com.gjr.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.StringUtils;

public class LoginFilter implements Filter{


	public void destroy() {
		
	}

	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		//获取session参数值--用户名
		HttpServletRequest httpreq=(HttpServletRequest)req;
		HttpServletResponse httpresp=(HttpServletResponse)resp;
		String aname=(String)httpreq.getSession().getAttribute("aname");
		String uname=(String)httpreq.getSession().getAttribute("uname");
		if(!StringUtils.isNullOrEmpty(aname)){
			//如果不为空，就证明已经登录过，不需要再次验证
			System.out.print("Admin通过session验证...");
			//把请求和响应传给过滤链的下一个调用者或者servlet
			chain.doFilter(httpreq, httpresp);			
		}else if(!StringUtils.isNullOrEmpty(uname)){
			//如果不为空，就证明已经登录过，不需要再次验证
			System.out.print("User通过session验证...");
			//把请求和响应传给过滤链的下一个调用者或者servlet
			chain.doFilter(httpreq, httpresp);
		}else{
			//如果为空，表示未登录过，跳回登录页面
			System.out.print("未通过session验证...");
			httpresp.sendRedirect("../index.jsp");
		}
		
	
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	
}