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

public class ManLoginServlet extends HttpServlet {

	public ManLoginServlet() {
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
		
		//System.out.println("hahah");
        String manName=request.getParameter("manName");
		String manPassword=request.getParameter("manPassword");
		System.out.println(manName+":"+manPassword);
		Man m=null;
		ManWorksql ms=null;
		if(manName.equals("")||manPassword.equals("")){
			session.setAttribute("manloginstr","请填写完整");
			request.getRequestDispatcher("/manloginfail.jsp").forward(request,response);
		}else{
			m=new Man();
			ms=new ManWorksql();
			m.setManName(manName);
			m.setManPassword(manPassword);
			Man m1=ms.selectInformation(m);
			//System.out.println(manName);
			//System.out.println(m1.getManName());
			if(manName.equals(m1.getManName())&&manPassword.equals(m1.getManPassword()))
			{
				session.setAttribute("manloginname",manName);
				request.getRequestDispatcher("/manjinru.jsp").forward(request,response);
			}else{
				if(!manName.equals(m1.getManName())){
					session.setAttribute("manloginstr","没有此用户");
					request.getRequestDispatcher("/manloginfail.jsp").forward(request,response);
				}else{
				session.setAttribute("manloginstr","密码错误");
				request.getRequestDispatcher("/manloginfail.jsp").forward(request,response);
			    }
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
