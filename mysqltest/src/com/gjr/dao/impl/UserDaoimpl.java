package com.gjr.dao.impl;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.gjr.dao.UserDao;
import com.gjr.pojo.User;

public class UserDaoimpl implements UserDao{
	//根据用户名和密码查询用户信息
	public User checkUserLoginDao(String uname, String pwd) {
		// 声明JDBC对象
		Connection conn=null;
		PreparedStatement ps=null;   //查询准备
		ResultSet rs=null;			//结果集
		//声明变量
		User u=null;
		try{
			//加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			//获取连接
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mnglogin", "root", "111");
			//创建SQL命令
			String sql="select * from user where uname=? and upwd=?";
			//创建SQL命令对象
			ps=conn.prepareStatement(sql);
			//给占位符赋值
			ps.setString(1,uname);	//第一个问号（占位符）
			ps.setString(2,pwd);	//第二个问号（占位符）
			//执行SQL查询
			rs=ps.executeQuery();	//rs为查询到的结果集
			//遍历结果
				while(rs.next()){
					//给变量赋值
					u=new User();
					u.setUid(rs.getInt("uid"));
					u.setUname(rs.getString("uname"));
					u.setPwd(rs.getString("pwd"));
				}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			//关闭资源
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//返回结果
		return u;
	}

//	用户注册
	public int userRegDAO(User u) {
		//声明JDBC对象
		Connection conn=null;
		PreparedStatement ps=null;
		//声明变量
		int index=-1;
		try{
			//加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			//获取连接
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mnglogin", "root", "111");
			//创建SQL命令
			String sql="insert into user values(default,?,?)";
			//创建SQL命令对象
			ps=conn.prepareStatement(sql);
			//给占位符赋值
			ps.setString(1, u.getUname());
			ps.setString(2,u.getPwd());
			//执行
			index=ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			//关闭资源
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//返回结果
		return index;
	}
	

}
