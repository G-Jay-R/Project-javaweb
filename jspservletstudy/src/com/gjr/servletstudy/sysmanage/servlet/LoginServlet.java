package com.gjr.servletstudy.sysmanage.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gjr.servletstudy.framework.util.StringUtils;
import com.gjr.servletstudy.sysmanage.services.UserService;



/*
 * 用于验证登陆的Servlet;
 */
public class LoginServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("I am doget");
		doPost(req,resp);//将所有动作引入dopost执行
			
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("I am dopost");
		
		/*
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		req.setCharacterEncoding("utf-8");
		先把中文字符串转化为字节，再把字节以指定编码组合
		*/
		
		String username=req.getParameter("username");
		String password =req.getParameter("password");
		/*
		 * 1.对本身输入的参数进行初步验证，非空是否符合规则
		 * 2.调用数据处理层验证登陆的方法。
		 * 3.验证通过后或者不通过的下一步动作
		 */
		if(StringUtils.isNotNull(username)&&
				StringUtils.isNotNull(password)){
			//UserDao userDao=new UserDao();
			//boolean flag = userDao.loginUser(username,password);
			
			//可以新写一个服务类方法service，在服务类方法里调用数据访问层Dao
			UserService userService =new UserService();
			boolean flag = userService.loginUser(username,password);
			if(flag){
				//如果验证成功，我们进入首页 跳转到指定的页面（重定向/转发）
				//在跳转之前加一段测试代码，用于测试登陆人数
				ServletContext application = this.getServletContext();
				@SuppressWarnings("unchecked")
				List<String> userList =(List<String>)application.getAttribute("userList");
				userList.add(username);
				
				resp.sendRedirect("success.html");				
			}else{
				//如果验证失败，返回错误页面
				req.getRequestDispatcher("error.html").forward(req, resp);
			}			
		}else{
			req.getRequestDispatcher("error.html").forward(req, resp);
		}
		
		/*
		PrintWriter out =resp.getWriter();
		out.println("<h1>用户名为:"+username+"</h1>");
		out.println("<h1>密码为:"+password+"</h1>");
		out.flush();
		out.close();
		*/
		
	}

	public void destroy() {
		System.out.println("I am destroy");
	}

	public void init() throws ServletException {
		System.out.println("I am init");
	}

}