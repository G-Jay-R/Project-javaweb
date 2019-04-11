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
public class UserLoginServlet extends HttpServlet {

	public UserLoginServlet() {
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
		//PrintWriter out=response.getWriter();
		
        String userName=request.getParameter("userName");
		String userPassword=request.getParameter("userPassword");
		User u=null;
		UserWorksql us=null;
		if(userName.equals("")||userPassword.equals("")){
			session.setAttribute("userloginstr","请填写完整");
			request.getRequestDispatcher("/userloginfail.jsp").forward(request,response);
		}else{
			u=new User();
			us=new UserWorksql();
			u.setUserName(userName);
			u.setUserPassword(userPassword);
			User u1=us.selectInformation(u);
			//System.out.println(userName);
			//System.out.println(u1.getUserName());
			if(userName.equals(u1.getUserName())&&userPassword.equals(u1.getUserPassword()))
			{
				session.setAttribute("userloginname",userName);
				request.getRequestDispatcher("/usermanage.jsp").forward(request,response);
			}else{
				if(!userName.equals(u1.getUserName())){
					session.setAttribute("userloginstr","没有此管理员");
					request.getRequestDispatcher("/userloginfail.jsp").forward(request,response);
				}else{
				session.setAttribute("userloginstr","密码错误");
				request.getRequestDispatcher("/userloginfail.jsp").forward(request,response);
			    }
			}
		}
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	
	}

	
	public void init() throws ServletException {
		
	}

}
