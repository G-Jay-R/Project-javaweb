package com.gjr.servlet;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gjr.pojo.Equip;
import com.gjr.service.AdminService;
import com.gjr.service.impl.AdminServiceimpl;

public class InsertServlet extends HttpServlet {

	//添加设备
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");	//设置请求编码格式
		resp.setContentType("text/html;charset=utf-8"); //设置响应编码格式
		//获取请求信息
		String ename=req.getParameter("ename");
		String brand=req.getParameter("brand");
		String model=req.getParameter("model");
		String type=req.getParameter("type");
		String department=req.getParameter("department");
		String staff=req.getParameter("staff");
		String position=req.getParameter("position");
		String date=req.getParameter("date");
		//新建设备对象
		Equip ep=new Equip();
		ep.setEname(ename);
		ep.setBrand(brand);
		ep.setModel(model);
		ep.setDate(date);
		ep.setDepartment(department);
		ep.setPosition(position);
		ep.setStaff(staff);
		ep.setType(type);
		//创建service对象
		AdminService as=new AdminServiceimpl();
		//as.addEquipService
		int t=as.addEquipService(ep);
		if(t>0){
			resp.sendRedirect("/equipmng/pages/admin1.jsp");	
		}else{
			System.out.print("添加失败！！"+t);	
		}
		
	}
	

}
