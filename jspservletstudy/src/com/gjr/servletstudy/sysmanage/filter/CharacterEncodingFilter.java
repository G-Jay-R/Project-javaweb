package com.gjr.servletstudy.sysmanage.filter;



import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CharacterEncodingFilter implements Filter{

	private FilterConfig filterConfig;
	
	public void destroy() {
		
		
	}


	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		//获取filter初始化的参数值
		String encoding =filterConfig.getInitParameter("encoding");
		if(null!=encoding&&!encoding.equals("")){
			req.setCharacterEncoding(encoding);
			resp.setCharacterEncoding(encoding);
			resp.setContentType("text/html;chaset="+encoding);				
		}
		System.out.println("我们进入了过滤器");
		//把请求和响应继续带给下一个filter，如果没有下一个filter就进入请求的servlet（下一步）
		chain.doFilter(req, resp);
		
	}

	
	public void init(FilterConfig config) throws ServletException {
		this.filterConfig = config;//赋值配置文件信息
		
	}
	
}