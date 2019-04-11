package servlet;

import com.*;

import sqlbean.*;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ManPerishServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		HttpSession session=request.getSession();
		//PrintWriter out=response.getWriter();
		
        String manName=(String)session.getAttribute("manloginname");
		Man m=new Man();
		ManWorksql ms=new ManWorksql();
		m.setManName(manName);
		int n=ms.deleteInformation(m);
		request.getRequestDispatcher("index.jsp").forward(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}

}
