package servlet;
import com.*;

import sqlbean.*;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ManJcServlet extends HttpServlet {

	public ManJcServlet() {
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
		
        String manName=request.getParameter("manName");
		String manPassword=request.getParameter("manPassword");
		Man m=null;
		ManWorksql ms=null;
		if(manName.equals("")||manPassword.equals("")){//两者都不为空
			session.setAttribute("manjcstr","请填写完整！");
	        request.getRequestDispatcher("/manjcfail.jsp").forward(request,response);
		}else{
			m=new Man();
			ms=new ManWorksql();
			m.setManName(manName);
			m.setManPassword(manPassword);
			Man m1=ms.selectInformation(m);
			if(manName.equals(m1.getManName())){
				session.setAttribute("manjcstr","已存在此用户");
		        request.getRequestDispatcher("/manjcfail.jsp").forward(request,response);
			}else{
				int n=ms.insertInformation(m);
				session.setAttribute("manjcstr","注册成功");
		        request.getRequestDispatcher("/manjcok.jsp").forward(request,response);
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
