package servlet;

import com.*;

import sqlbean.*;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class SSuser extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");

		String userName=request.getParameter("s");
		//System.out.println(manName);
		User u=new User();
		UserWorksql us=new UserWorksql();
		u.setUserName(userName);
		int n=us.deleteInformation(u);
		request.getRequestDispatcher("/sssuser.jsp").forward(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}

}
