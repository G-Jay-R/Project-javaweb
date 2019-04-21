package test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			String resource="mybatis-config.xml";
			InputStream input=Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlsessionfactory=new SqlSessionFactoryBuilder().build(input);
			System.out.println(sqlsessionfactory);
		}catch (IOException e){
			e.printStackTrace();
		}
	}

}
