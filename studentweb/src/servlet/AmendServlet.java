package servlet;

import com.*;
import sqlbean.*;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class AmendServlet extends HttpServlet {
	public AmendServlet() {
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
		if(sno.equals("")){
			session.setAttribute("amendstr","至少要有此学号！");
			request.getRequestDispatcher("/amendfail.jsp").forward(request,response);
		}else{
			s=new Student();
			w=new Worksql();
			s.setSno(sno);
			Student s1=w.selectInformation(s);
			if(sno.equals(s1.getSno())){
				
				if(name.equals("")){
					String name1=s1.getName();
				    s.setName(name1);
				}
				else
					s.setName(name);
				if(sex==null){
					String sex1=s1.getSex();
					s.setSex(sex1);
				}
				else
				    s.setSex(sex);
				if(age.equals("")){
					String age1=s1.getAge();
					s.setAge(age1);
				}
				else
					s.setAge(age);
				int n=w.amendInformation(s);
				request.getRequestDispatcher("/amendok.jsp").forward(request,response);
			 }
			 else{
				 session.setAttribute("amendstr","没有此学生！");
				 request.getRequestDispatcher("/amendfail.jsp").forward(request,response);
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
