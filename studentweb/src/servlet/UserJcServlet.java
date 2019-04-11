package servlet;
import com.*;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sqlbean.*;
public class UserJcServlet extends HttpServlet {

	
	public UserJcServlet() {
		super();
	}

	public void destroy() {
		super.destroy(); 
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		HttpSession session=request.getSession();
		PrintWriter out=response.getWriter();
		
        String userName=request.getParameter("userName");
		String userPassword=request.getParameter("userPassword");
		User u=null;
		UserWorksql us=null;
		if(userName.equals("")||userPassword.equals("")){//两者都不为空
			session.setAttribute("userjcstr","请填写完整");
	        request.getRequestDispatcher("/userjcfail.jsp").forward(request,response);
		}else{
			u=new User();
			us=new UserWorksql();
			u.setUserName(userName);
			u.setUserPassword(userPassword);
			User u1=us.selectInformation(u);
			if(userName.equals(u1.getUserName())){
				session.setAttribute("userjcstr","已存在此管理员");
		        request.getRequestDispatcher("/userjcfail.jsp").forward(request,response);
			}else{
				int n=us.insertInformation(u);
				session.setAttribute("userjcstr","注册成功");
		        request.getRequestDispatcher("/userjcok.jsp").forward(request,response);
			}
		}
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	
	}

	public void init() throws ServletException {
		
	}

}
