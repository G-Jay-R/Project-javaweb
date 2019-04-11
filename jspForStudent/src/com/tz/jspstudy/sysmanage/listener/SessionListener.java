package com.tz.jspstudy.sysmanage.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;


public class SessionListener implements HttpSessionListener {

	/**
	 * session对象被创建之后调用
	 */
	public void sessionCreated(HttpSessionEvent event) {
		System.out.println("session被创建");
	}

	/**
	 * session生命周期结束调用
	 */
	public void sessionDestroyed(HttpSessionEvent event) {
		System.out.println("session被销毁");
		//获得SESSION对象
		//HttpSession session = event.getSession();
		//在下面可以做你想做的事情
		
		/*//从SESSION中获得退出的用户名
		String userName = (String)session.getAttribute("userName");
		System.out.println(userName+"用户退出系统!");
		//获得上下文对象
		ServletContext application = session.getServletContext();
		//Map<String,String> userMap = new HashMap<String,String>();
		((Map)application.getAttribute("userMap")).remove(userName);*/
	}

}
