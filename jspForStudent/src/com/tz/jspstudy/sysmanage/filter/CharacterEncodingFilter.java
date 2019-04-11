package com.tz.jspstudy.sysmanage.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


/**
 * 
 * 类描述：  字符编码过滤器
 * 类名称：com.tz.jspstudy.sysmanage.Filter.CharacterEncodingFilter       
 * 创建人：keven  
 * 创建时间：2016年6月30日 下午10:52:36     
 * @version   V1.0
 */
public class CharacterEncodingFilter implements Filter {

	private FilterConfig config;

 	public void init(FilterConfig config) throws ServletException {
		this.config = config;
	}

 	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// 获取filter初始化的参数值
 		String encoding = config.getInitParameter("encoding");
		if (null != encoding && !"".equalsIgnoreCase(encoding)) {
			request.setCharacterEncoding(encoding);
			response.setCharacterEncoding(encoding);			
		}
		//System.out.println("请求第一次进入了字符编码filter...");  
		// 把请求和响应传给过滤链中的下一个调用者或servlet
		chain.doFilter(request, response);
	}
	
	
	@Override
	public void destroy() {

	}

}
