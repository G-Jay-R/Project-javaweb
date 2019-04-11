package com.gjr.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.gjr.dao.AdminDao;
import com.gjr.pojo.Admin;
import com.gjr.pojo.Equip;

//Dao的实现类
public class AdminDaoimpl implements AdminDao{
	//根据用户名密码查询用户信息
	@Override
	public Admin checkAdminLoginDao(String aname, String apwd){
		//声明JDBC对象
		Connection con=null;		
		PreparedStatement ps=null;
		ResultSet rs=null;
		//声明变量
		Admin a=null;
		try {
			//加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			//获取连接
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/equip","root","111");
			//创建SQL命令
			String sql="select * from admin where aname=? and apwd=?";
			//创建SQL命令对象
			ps=con.prepareStatement(sql);
			//给占位符赋值
			ps.setString(1,aname);
			ps.setString(2,apwd);
			//执行查询
			rs=ps.executeQuery();
			//遍历结果
				while(rs.next()){
					//给变量赋值
					a=new Admin();
					a.setAname(rs.getString("aname"));
					a.setApwd(rs.getString("apwd"));
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
		//返回结果
		return a;
	}

	//添加设备
	public int addEquipDao(Equip e) {
		//声明JDBC对象
				Connection con=null;		
				PreparedStatement ps=null;
				//声明变量
				int row=-1;
				try{
					//加载驱动
					Class.forName("com.mysql.jdbc.Driver");
					//获取连接
					con=DriverManager.getConnection("jdbc:mysql://localhost:3306/equip", "root", "111");
					//创建SQL命令
					String sql = "insert into shebei values(default,?,?,?,?,?,?,?,?)";					
					//创建SQL命令对象
					ps=con.prepareStatement(sql);
					//给占位符赋值
					ps.setString(1, e.getEname());
					ps.setString(2, e.getBrand());
					ps.setString(3, e.getModel());
					ps.setString(4, e.getType());
					ps.setString(5, e.getDepartment());
					ps.setString(6, e.getStaff());
					ps.setString(7, e.getPosition());
					ps.setString(8, e.getDate());
					//执行
					row=ps.executeUpdate();			
				}catch (Exception a) {
					a.printStackTrace();
				}finally{
					//关闭资源
					try {
						con.close();
					} catch (SQLException a) {
						a.printStackTrace();
					}
					try {
						ps.close();
					} catch (SQLException a) {
						a.printStackTrace();
					}
				}
					
					return row;
		}

	/**
	 *	修改设备信息
	 * @see com.gjr.dao.AdminDao#modifyEquipDao(int, com.gjr.pojo.Equip)
	 */
	public int modifyEquipDao(int id, Equip ep) {
		//声明JDBC对象
		Connection con=null;
		PreparedStatement ps=null;
		int row=-1;
		try{
			//加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			//获取连接
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/equip", "root", "111");
			//创建sql语句
			String sql="update shebei set ename=?,brand=?,model=?,type=?,department=?,staff=?,position=?,date=? where id=?";
			//创建命令对象
			ps=con.prepareStatement(sql);
			//给占位符赋值
			ps.setString(1, ep.getEname());
			ps.setString(2, ep.getBrand());
			ps.setString(3, ep.getModel());
			ps.setString(4, ep.getType());
			ps.setString(5, ep.getDepartment());
			ps.setString(6, ep.getStaff());
			ps.setString(7, ep.getPosition());
			ps.setString(8, ep.getDate());
			ps.setInt(9, id);
			//执行
			row=ps.executeUpdate();	
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return row;
	}

	//删除信息
	public int delequipsDao(int id) {
		//声明JDBC对象
				Connection con=null;
				PreparedStatement ps=null;
				int row=-1;
				try{
					//加载驱动
					Class.forName("com.mysql.jdbc.Driver");
					//获取连接
					con=DriverManager.getConnection("jdbc:mysql://localhost:3306/equip", "root", "111");
					//创建sql语句
					String sql="delete from shebei where id=?";
					//创建命令对象
					ps=con.prepareStatement(sql);
					//给占位符赋值
					ps.setInt(1, id);
					//执行
					row=ps.executeUpdate();	
					
				} catch (Exception e) {
					e.printStackTrace();
				}finally{
					try {
						con.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					try {
						ps.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				return row;
	}
}
