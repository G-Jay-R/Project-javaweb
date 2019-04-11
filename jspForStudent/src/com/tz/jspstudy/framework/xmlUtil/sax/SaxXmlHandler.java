package com.tz.jspstudy.framework.xmlUtil.sax;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.tz.jspstudy.sysmanage.bean.User;

public class SaxXmlHandler extends DefaultHandler{
	
	//1:List<User>
	//2:初始化一个user对象  然后user赋值 
	//3:list.add(user)
	//4:user = null 转到第2步
	//5:返回list<user>
	
	//存储元素集合
	private List<User> userList = null;	
	//存储当前解析的元素
	private User user = null;
	//存储当前元素的标识符
    String currentTag = null;
	//存储当前元素的值
	String currentValue = null;	
	//开始解析的元素
    String nodeName=null;
	 
	public List<User> getUserList() {
		return userList;
	} 
 
	public User getUser() {
		return user;
	}
 

	public SaxXmlHandler(String nodeName){
    	this.nodeName = nodeName;
    }
    
    //开始解析文档，即开始解析XML根元素时调用该方法
	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub
		System.out.println("LET US START READ DOCUMENT");
		this.userList = new ArrayList<User>();
	}

	//开始解析每个元素时都会调用该方法
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		// TODO Auto-generated method stub
		System.out.println("LET US START READ ELEMENT");
		//如果碰到符合要求的元素
		if(qName.equals(nodeName)){
			this.user =new User();
		}
		//判断正在解析的元素是否有属性值,如果有则将其全部取出
		if(attributes!=null&&user!=null){
			for(int i=0;i<attributes.getLength();i++){
				if(attributes.getQName(i).equals("id"))
					user.setUserId(Long.parseLong(attributes.getValue(i)));
            }
		}
		this.currentTag=qName;  //正在解析的元素
	}
	
	

	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
        System.out.println("LET US START READ NAME AND VALUE");
        if(currentTag!=null&&user!=null){
        	currentValue = new String(ch,start,length);
        	if(currentValue!=null&&!currentValue.trim().equals("")&&!currentValue.trim().equals("\n")){
        		if(currentTag.equals("userName"))
        			user.setUserName(currentValue);
        		if(currentTag.equals("password"))
        			user.setPassword(currentValue);
        	}
        }
        //解析完以后把当前元素置空，等待下一个读取
        currentTag = null;
        currentValue = null;
	}
	
	//结束当前元素解析以后，我们应该把user add到userList
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		System.out.println("LET US END READ ELEMENT");
		if(qName.equals(nodeName)){
			userList.add(user);
			user = null;
		}
	}
	
	//结束文档解析，关闭文件 。。
	public void endDocument() throws SAXException {		
		System.out.println("LET US END READ DOCUMENT");
		super.endDocument();
	}

	
}