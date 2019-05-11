package com.gjr.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.gjr.dao.CustomerMapper;
import com.gjr.domain.Customer;

public class CustomerMapperImpl extends SqlSessionDaoSupport implements CustomerMapper {

	public void saveCustomer(Customer customer) {
		SqlSession sqlsession=this.getSqlSession();
		//增加
		sqlsession.insert("saveCustomer",customer);
		//这里不需要事务提交，spring默认做了

	}

}
