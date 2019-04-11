package com.tz.jspstudy.framework.xmlUtil.dom4j;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import com.tz.jspstudy.sysmanage.bean.User;

/**
 * 
 * 类描述：  dom4j解析
 * 类名称：com.tz.jspstudy.framework.xmlUtil.dom4j.Dom4jXml       
 * 创建人：keven  
 * 创建时间：2016年7月20日 上午11:11:17     
 * @version   V1.0
 */
public class Dom4jXml {
	
	static List<User> userList = new ArrayList<User>();
	 
	//把一个XML读成一个实体类
	public static void xmlToEntity() {		
		//读XML文档需要的对象
		SAXReader reader = new SAXReader();
		try {			
			//Document对象代表整个XML文档的所有内容
			Document doc = reader.read("src/user.xml");			
			//获取文档的根元素
			Element root = doc.getRootElement();			
			//获取根元素下面的所有的子元素
			@SuppressWarnings("unchecked")
			List<Element> elementList = root.elements();
			
			User user= null;
			for (int i = 0; i < elementList.size(); i++) {
				user = new User();				
				//遍历所有的user标签
				Element element = elementList.get(i);			
				//获取属性id
				Attribute id = element.attribute("id");		
				//获取属性的值放到实体类中
				user.setUserId(Long.parseLong(id.getValue()));				
				//获取子元素name
				Element name = element.element("userName");				
				user.setUserName(name.getText());
				Element password = element.element("password");				
				user.setPassword(password.getText());
				userList.add(user);
			}
			
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		
		
		for (User user :userList) {
			System.out.println(user.getUserName()+"---"+user.getPassword());
 		}
		
	}
	
	//把一个数据集合写到一个XML文件
	public static void entityToXml() {		
		//创建出文档对象
		Document doc = DocumentHelper.createDocument();
		//创建出根元素对象,创建出了一个名叫users的根元素对象
		Element root = DocumentHelper.createElement("users");		
		//把根元素对象和文档对象关联在一起
		doc.setRootElement(root);		
		for (int i = 0; i < userList.size(); i++) {
			User user = userList.get(i);		
			//在根元素users的里面，添加子元素user
			Element userElement = root.addElement("user");		
			//给子元素userElement添加属性，名字叫做id
			userElement.addAttribute("id", user.getUserId().toString());			
			//给子元素userElement添加子元素，元素名字叫做name
			Element name = userElement.addElement("userName");
			name.setText(user.getUserName());			
			Element password = userElement.addElement("password");
			password.setText(user.getPassword());		
		}
		
		//把内存中已经建立好的结构，输出到文件中
		OutputStream os = null;	
		//构造XML的格式化对象
		OutputFormat opf = new OutputFormat("    ",true,"utf-8");
		XMLWriter writer = null;
		try {		
			os = new FileOutputStream("src/dom4jUser.xml");

			//构造XML输出对象
			writer = new XMLWriter(os,opf);		
			writer.write(doc);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				writer.close();
				os.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}

	public static void main(String[] args) {
		xmlToEntity();
		entityToXml();
		 
	}
}
