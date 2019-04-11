package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sqlbean.Worksql;

import com.Student;

public class ManSelectServlet extends HttpServlet {

	public ManSelectServlet() {
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
			session.setAttribute("manselectstr","请输入学生姓名！");
			request.getRequestDispatcher("/manselectfail.jsp").forward(request,response);
		}
	    else{
			s=new Student();
			w=new Worksql();
			s.setSno(sno);
			Student s1=w.selectInformation(s);
			if(sno.equals(s1.getSno())){
				session.setAttribute("s1",s1);
				request.getRequestDispatcher("/manselectresult.jsp").forward(request,response);
			}
			else{
				session.setAttribute("manselectstr", "没有此学生");
				request.getRequestDispatcher("/manselectfail.jsp").forward(request,response);
			}
		}
	
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	
	}

	public void init() throws ServletException {
		
	}

}
