package com.gjr.servlet;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gjr.pojo.User;
import com.gjr.service.UserService;
import com.gjr.service.impl.UserServiceimpl;

public class UserLoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//设置请求编码格式
		req.setCharacterEncoding("utf-8");
		//设置响应编码格式
		resp.setContentType("text/html;charset=utf-8");
		//获取操作符
		String oper=req.getParameter("oper");
		if("login".equals(oper)){
			//调用登录处理方法
			checkUserlogin(req,resp);
		}else if("reg".equals(oper)){
			//调用注册功能
			userReg(req,resp);
		}else{
			System.out.println("没有找到对应的操作符："+oper);
		}

}
	//注册功能
	private void userReg(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		//获取请求信息
		String uname=req.getParameter("userName");
		String pwd=req.getParameter("userPassword");
	    User u=new User(0,uname,pwd);
	    	    
	    if(uname.equals("")||pwd.equals("")){
	    	//信息不完整，转发
	    	req.getRequestDispatcher("/regfail.jsp").forward(req,resp);	    	  	
	    }else{
	    	//处理请求信息  
	    	//调用业务层处理
		    UserService us=new UserServiceimpl();
		    int index=us.userRegService(u);
		    String t=u.getUname();
			System.out.println(t+"注册成功"+index);
	    	//重定向
	    	resp.sendRedirect("/mtest/regsuccess.jsp");	  
	    	
	    }
	    
	    
	  //响应处理结果
	  
		
	}

	//处理登录
	private void checkUserlogin(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		//获取请求信息
		String uname=req.getParameter("userName");
		String pwd=req.getParameter("userPassword");
				//处理请求信息
					//获取service层对象
		UserService us=new UserServiceimpl();
					//校验
		User u=us.checkUserLoginService(uname, pwd);
		if(u!=null){//验证成功
				String t=u.getUname();
				System.out.println(t+"登录");
				resp.sendRedirect("/mtest/usermanage.jsp");  //重定向,建议使用绝对路径，避免重定向失败
				return;
		}else{
			//添加标识符到request中
			req.setAttribute("flag",0);
			//请求转发，/表示根目录，这样写即可
			req.getRequestDispatcher("/userlogin.jsp").forward(req, resp);  
			return;
		}
				//响应处理结果
					//直接响应
					//请求转发
					//重定向
	}
}
