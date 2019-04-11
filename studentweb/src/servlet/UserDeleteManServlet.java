package servlet;

import com.*;

import sqlbean.*;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class UserDeleteManServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");

		String manName=request.getParameter("s");
		//System.out.println(manName);
		Man m=new Man();
		ManWorksql ma=new ManWorksql();
		m.setManName(manName);
		int n=ma.deleteInformation(m);
		request.getRequestDispatcher("/manageman.jsp").forward(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}

}
