package servlet;
import com.*;
import sqlbean.*;

import java.io.*;


import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InsertServlet extends HttpServlet {
	public InsertServlet() {
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
		
		String sno=request.getParameter("sno");
		String name=request.getParameter("sname");
		String sex=request.getParameter("sex");
		String age=request.getParameter("sage");
		Student s=null;
		Worksql w=null;
		if(sno.equals("")||name.equals("")||sex==null||age.equals("")){
			session.setAttribute("insertstr","请填写完整");
			request.getRequestDispatcher("/insertfail.jsp").forward(request,response);

		}else{
			s=new Student();
			w=new Worksql();
			s.setSno(sno);
			s.setName(name);
			s.setSex(sex);
			s.setAge(age);
			Student s1=w.selectInformation(s);
			if(sno.equals(s1.getSno())){

				session.setAttribute("insertstr","已有此学生");
				request.getRequestDispatcher("/insertfail.jsp").forward(request,response);
			}else{
				int n=w.insertInformation(s);
				if(n!=0){

					request.getRequestDispatcher("/insertok.jsp").forward(request,response);
				}
			}
		}
	}	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);		
	}

	public void init() throws ServletException {}

}
