package com.gjr.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gjr.dao.CustomerMapper;
import com.gjr.domain.Customer;

public class MybatisTest3 {
	@Test
	public void test(){//需要实现类的插入方式
		//1.加载spring配置
		ApplicationContext ac =new ClassPathXmlApplicationContext("applicationContext.xml");
		//2.获取对象
		CustomerMapper cus=(CustomerMapper)ac.getBean("customerMapper");
		
		//3.调用方法
		Customer cs=new Customer();
		cs.setName("吴涛");
		cs.setAddress("HHU");
		cs.setGender("女");
		cs.setTelephone("1777777777");
		
			cus.saveCustomer(cs);
	}
}
