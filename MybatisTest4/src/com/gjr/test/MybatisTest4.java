package com.gjr.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gjr.dao.CustomerMapper;
import com.gjr.domain.Customer;

public class MybatisTest4 {
	@Test
	public void test(){//需要实现类的插入方式
		//1.加载spring配置
		ApplicationContext ac =new ClassPathXmlApplicationContext("applicationContext.xml");
		//2.获取对象,此时的CustomerMapper接口不需要实现，方便编程
		CustomerMapper cus=(CustomerMapper)ac.getBean("customerMapper");//此时bean名称为Mapper接口的类名
		
		//3.调用方法
		Customer cs=new Customer();
		cs.setName("武义");
		cs.setAddress("HHU-1204");
		cs.setGender("男");
		cs.setTelephone("11111111");
		
			cus.saveCustomer(cs);
	}
}
