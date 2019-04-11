package com.tz.jspstudy.sysmanage.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * 
 * 类描述： ServletContext监听器
 * 配置了load-on-startup的servlet可以随TOMCAT启动初始化
 * 但是ServletContextListener会更早的启动加载 
 * 类名称：com.tz.jspstudy.sysmanage.listener.InitListener       
 * 创建人：keven  
 * 创建时间：2016年7月7日 下午9:24:02     
 * @version   V1.0
 */
public class InitListener implements ServletContextListener {

	/**
	 * 整个项目卸载部署的时候会调用这个方法
	 */
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("TOMCAT停止服务，或者项目卸载");
	}

	/**
	 * 项目被加载的时候调用该方法
	 */
	public void contextInitialized(ServletContextEvent event) {
		System.out.println("TOMCAT启动，项目初始化");

		// 通过监听器事件对象，获得上下文对象
		//ServletContext application = event.getServletContext();
		// 第一次访问就创建一个ArrayList存入上下文，用于存储用户的多条聊天消息
		/*List<String> list = new ArrayList<String>();
		application.setAttribute("msglist", list);

		// 第一次访问就创建一个LinkedList存入上下文，用于存储用户的在线记录
		List<String> userList = new LinkedList<String>();
		application.setAttribute("userlist", userList);*/
	}

}
