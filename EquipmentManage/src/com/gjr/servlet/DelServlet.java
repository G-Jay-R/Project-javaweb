package com.gjr.servlet;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gjr.service.AdminService;
import com.gjr.service.impl.AdminServiceimpl;

public class DelServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//删除设备信息
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		//获取请求信息
		String s=req.getParameter("s1");
		//System.out.print(s);
		int id=Integer.parseInt(s);
		AdminService as=new AdminServiceimpl();
		int t=as.delequiService(id);
		
		if(t>0){
			resp.sendRedirect("/equipmng/pages/show_equips.jsp");
		}else{
			System.out.print("删除出错！！！");
			}
	}
	
}
