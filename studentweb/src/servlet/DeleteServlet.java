package servlet;

import com.*;
import sqlbean.*;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class DeleteServlet extends HttpServlet {

	public DeleteServlet() {
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
		Student s=null;
		Worksql w=null;
		String sno=request.getParameter("sno");
		if(sno.equals("")){
			session.setAttribute("deletestr","请输入要删除的学生学号");
			request.getRequestDispatcher("/deletefail.jsp").forward(request,response);
		}else{
			s=new Student();
			w=new Worksql();
			s.setSno(sno);
			Student s1=w.selectInformation(s);
			if(sno.equals(s1.getSno())){
				 int n=w.deleteInformation(s);
				 request.getRequestDispatcher("/deleteok.jsp").forward(request,response);
			}else{
					session.setAttribute("deletestr","没有此同学");
					request.getRequestDispatcher("/deletefail.jsp").forward(request,response);
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
