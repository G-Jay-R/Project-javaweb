package servlet;

import com.*;

import sqlbean.*;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class UserPerishServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		HttpSession session=request.getSession();
		//PrintWriter out=response.getWriter();
		
        String userName=(String)session.getAttribute("userloginname");
		User u=new User();
		UserWorksql us=new UserWorksql();
		u.setUserName(userName);
		int n=us.deleteInformation(u);
		request.getRequestDispatcher("index.jsp").forward(request,response);
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
		
	}


}
