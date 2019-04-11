package com.gjr.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.gjr.dao.UserDao;
import com.gjr.pojo.Admin;
import com.gjr.pojo.User;

public class UserDaoimpl implements UserDao{

	//验证用户登录
	public User checkUserloginDao(String uname, String upwd) {
		//声明jdbc对象
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		//声明变量
		User u=null;
		try {
			//加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			//获取连接
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/equip","root","111");
			//创建SQL命令
			String sql="select * from user where uname=? and upwd=?";
			//创建SQL命令对象
			ps=con.prepareStatement(sql);
			//给占位符赋值
			ps.setString(1,uname);
			ps.setString(2,upwd);
			//执行查询
			rs=ps.executeQuery();
			//遍历结果
				while(rs.next()){
					//给变量赋值
					u=new User();
					u.setUname(rs.getString("uname"));
					u.setUpwd(rs.getString("upwd"));
					//System.out.print("请求登录");
				}					
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			//关闭资源
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		return u;
	}

}
