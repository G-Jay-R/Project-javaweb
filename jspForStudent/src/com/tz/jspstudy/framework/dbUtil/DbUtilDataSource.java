package com.tz.jspstudy.framework.dbUtil;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * 用数据源的方式访问数据库
 * @author Administrator
 *
 */
public class DbUtilDataSource {
		 
	private static ComboPooledDataSource dataSource;
	static {
		try {
			/**
	         * 读取src根目录下文件的配置文件 
	         * jdbc.properties位于src目录
	         */
			Properties dbconfig = new Properties();
			// 得到配置文件的输入流
			//得到类加载器对象
			ClassLoader cl = DbUtilDataSource.class.getClassLoader();
			//通过类加载器得到指定的资源的字节流
			InputStream is = cl.getResourceAsStream("jdbc.properties");
			//将文件的输入流通过dbconfig对象进行关联
			try {
				dbconfig.load(is);
			} catch (IOException e1) {
	 			e1.printStackTrace();
			}
			
			// 创建一个连接池对象
			dataSource = new ComboPooledDataSource();
			// 设置驱动类
			dataSource.setDriverClass(dbconfig.getProperty("jdbc.driver"));
			// 设置url
			dataSource.setJdbcUrl(dbconfig.getProperty("jdbc.url"));
			// 设置用户名
			dataSource.setUser(dbconfig.getProperty("jdbc.user"));
			// 设置密码
			dataSource.setPassword(dbconfig.getProperty("jdbc.password"));
			// 设置初始化连接数量
			dataSource.setInitialPoolSize(15);
			// 设置连接池每次增加连接的数量
			dataSource.setAcquireIncrement(5);
			// 设置连接池最大连接数量
			dataSource.setMaxPoolSize(50);
			// 设置连接池最小连接数量
			dataSource.setMinPoolSize(8);
			// 设置闲置连接最大存活时间
			dataSource.setMaxIdleTime(200);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

	}

	/**
	 * 得到连接
	 * 
	 * @return
	 */
	public static Connection getConnection() {
		try {
			return dataSource.getConnection(); // 到数据库连接池中获取连接返回
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	/**
	 * 关闭资源
	 * 
	 * @param rs
	 * @param stm
	 * @param conn
	 */
	public static void closeConnection(Connection conn,Statement stm,ResultSet rs  ) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (stm != null) {
			try {
				stm.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
 
}
