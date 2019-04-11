package servlet;

import com.*;
import sqlbean.*;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class SelectServlet extends HttpServlet {

	public SelectServlet() {
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
		
		Student s=null;
		Worksql w=null;
		String sno=request.getParameter("sno");
		if(sno.equals("")){
			session.setAttribute("selectstr","请输入学生姓名！");
			request.getRequestDispatcher("/selectfail.jsp").forward(request,response);
		}
		else{
			s=new Student();
			w=new Worksql();
			s.setSno(sno);
			Student s1=w.selectInformation(s);
			if(sno.equals(s1.getSno())){
				session.setAttribute("s1",s1);
				request.getRequestDispatcher("/selectresult.jsp").forward(request,response);
			}
			else{
				session.setAttribute("selectstr", "没有此学生！");
				request.getRequestDispatcher("/selectfail.jsp").forward(request,response);
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


	
