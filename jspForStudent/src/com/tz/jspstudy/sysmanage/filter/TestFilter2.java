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
 * 类描述：过滤器测试类2
 * 类名称：com.tz.jspstudy.sysmanage.Filter.TestFilter2       
 * 创建人：keven  
 * 创建时间：2016年6月30日 下午10:52:36     
 * @version   V1.0
 */
public class TestFilter2 implements Filter {
 
 	public void init(FilterConfig config) throws ServletException {
		System.out.println("TestFilter2 init()");
	}

 	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {		 
		System.out.println("TestFilter2 doFilter()");  
		//在一个拦截器中调用doFilter是交给下一个拦截器执行
		chain.doFilter(request, response);
	}
		 
	public void destroy() {

	}

}
