package com.tz.jspstudy.test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 类描述：测试log4j的应用  
 * 类名称：com.tz.jspstudy.test.Log4jTest       
 * 创建人：keven  
 * 创建时间：2016年8月5日 下午8:39:31     
 * @version   V1.0
 */
public class Log4jTest{
	
	public static void main(String[] args) {
		Log logger = LogFactory.getLog(Log4jTest.class);
				
		logger.debug("debug log");
		logger.info(" info log");
		logger.warn(" info log");
		logger.error(" info log");
		
	}
}