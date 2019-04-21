package com.gjr.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.gjr.dao.CustomerMapper;
import com.gjr.domain.Customer;

public class MybatisTest {
	@Test
	public void test() throws IOException{
		// 1.创建SqlSessionFactorybuilder
		SqlSessionFactoryBuilder builder =new SqlSessionFactoryBuilder();
		//加载sqlmapconfig.xml文件
		InputStream is=Resources.getResourceAsStream("sqlMapConfig.xml");
		
		//2.创建sqlsessionfactory 
		SqlSessionFactory factory=builder.build(is);
		
		//3.打开Sqlsession
		SqlSession sqlsession=factory.openSession();
		
		//4.获取Mapper接口的对象
		CustomerMapper cp=sqlsession.getMapper(CustomerMapper.class);
		
		//5.操作
		Customer cs=new Customer();
		cs.setName("李天河");
		cs.setAddress("HHU");
		cs.setGender("男");
		cs.setTelephone("1888888888");
		
		cp.saveCustomer(cs);
		
		//6.提交事务
		sqlsession.commit();
		
		//7.关闭资源
		sqlsession.close();
				
	}
}
