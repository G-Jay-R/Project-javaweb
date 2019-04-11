package com.gjr.servlet;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gjr.pojo.Equip;
import com.gjr.service.AdminService;
import com.gjr.service.impl.AdminServiceimpl;

public class ModifyServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//设置格式
		req.setCharacterEncoding("utf-8");
		resp.setContentType("txet/html;charset=utf-8");
		//获取请求信息
		String s=req.getParameter("id");
		int id=Integer.parseInt(s);
		String ename=req.getParameter("ename");
		String brand=req.getParameter("brand");
		String model=req.getParameter("model");
		String type=req.getParameter("type");
		String department=req.getParameter("department");
		String staff=req.getParameter("staff");
		String position=req.getParameter("position");
		String date=req.getParameter("date");
		//System.out.print(id+date);
		//创建对象
		Equip ep=new Equip();
		//赋值
		ep.setEname(ename);
		ep.setBrand(brand);
		ep.setModel(model);
		ep.setDate(date);
		ep.setDepartment(department);
		ep.setPosition(position);
		ep.setStaff(staff);
		ep.setType(type);
		//创建service层对象
		AdminService as=new AdminServiceimpl();
		int t=as.modifyEquipService(id, ep);
		if(t>0){
			resp.sendRedirect("/equipmng/pages/show_equips.jsp");	
		}else{
			System.out.print("修改失败！！"+t);	
		}
		
	}

}
