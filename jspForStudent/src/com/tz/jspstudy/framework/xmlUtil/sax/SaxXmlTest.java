package com.tz.jspstudy.framework.xmlUtil.sax;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

import com.tz.jspstudy.sysmanage.bean.User;

/**
 * 类描述：测试sax读取文件  
 * 类名称：com.tz.jspstudy.framework.xmlUtil.sax.SaxXmlTest       
 * 创建人：keven  
 * 创建时间：2016年7月20日 下午12:02:37     
 * @version   V1.0
 */

public class  SaxXmlTest {
	
	public static void main(String[] args) throws IOException {
		List<User> userList = new ArrayList<User>();
		//创建一个解析XML的工厂对象
        SAXParserFactory parserFactory=SAXParserFactory.newInstance();
        //创建一个解析XML的对象
        try {
			SAXParser parser=parserFactory.newSAXParser();
			 //创建一个解析助手类
	        SaxXmlHandler saxHandler = new SaxXmlHandler("user");
	        parser.parse("src/user.xml", saxHandler);
	        userList = saxHandler.getUserList();	        
	        for(User user:userList){
	        	System.out.println(user.getUserId()+"--"+user.getUserName());
	        }
			
		} catch (ParserConfigurationException e) {
 			e.printStackTrace();
		} catch (SAXException e) {
 			e.printStackTrace();
		}
       
		
	}
}