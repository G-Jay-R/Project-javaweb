package com.tz.jspstudy.sysmanage.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * test
 * 类描述：  
 * 类名称：com.tz.jspstudy.sysmanage.Filter.TestFilter       
 * 创建人：keven  
 * 创建时间：2016年7月2日 下午9:58:20     
 * @version   V1.0
 */
public class TestFilter implements Filter{

	private FilterConfig config;

	public void destroy() {
		 
	}

    //过滤器的动作 过滤器拦截请求以后需要做的事情
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		String encode = config.getInitParameter("encoding");
 		if(null!=encode&& !"".equalsIgnoreCase(encode)){
			request.setCharacterEncoding(encode);
			response.setCharacterEncoding(encode);
		}
		//进入过滤器链的下一个目标 ,如果没有下一个filter，则直接进入请求的servlet
		chain.doFilter(request, response);
		
 	}
	 
 	public void init(FilterConfig filterConfig) throws ServletException {
 		this.config = filterConfig;
	}
	
}