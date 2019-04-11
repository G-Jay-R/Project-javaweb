package com.tz.jspstudy.framework.xmlUtil.dom;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.tz.jspstudy.sysmanage.bean.User;

/**
 * 类描述：XML解析，采用DOM的方式解析user.xml和生成user.xml 
 * 类名称：com.tz.jspstudy.framework.xmlUtil.DomParseUtil       
 * 创建人：keven  
 * 创建时间：2016年7月19日 下午9:19:10     
 * @version   V1.0
 */
public class DomParseUtil{  
	
	/**
	 * 读取指定的xml文件，并将文件中的内容放到指定的对象
	 * @Title: getusers  
	 * @Description: TODO
	 * @param inputStream
	 * @return
	 * @throws Exception
	 */
    public List<User> getUsers(File file) throws Exception{  
        List<User> list = new ArrayList<User>();  
        //1:初始化文档建造工厂
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();  
        //2:从工厂获取建造工具
        DocumentBuilder builder = factory.newDocumentBuilder();  
        //3:将xml文件流加载到一个document文本对象
        Document document = builder.parse(file);  
        //获取文本对象所有的元素集合
        Element element = document.getDocumentElement();  
        //获取元素名称为user的所有内容
        NodeList userNodes = element.getElementsByTagName("user");  
        System.out.println("总共有多少user对象："+userNodes.getLength());
        //循环所有userElement元素
        for(int i=0;i<userNodes.getLength();i++){  
            Element userElement = (Element) userNodes.item(i);  
            User user = new User();  
            user.setUserId(Long.parseLong(userElement.getAttribute("id")));  
            NodeList childNodes = userElement.getChildNodes();  
            System.out.println("每个user对象有多少个属性:"+childNodes.getLength()); 
            //循环某一个user元素，获取user元素下所有的子元素，将子元素赋予对象
            for(int j=0;j<childNodes.getLength();j++){ 
            	System.out.println("user对象的属性值："+childNodes.item(j).getNodeName());
                if(childNodes.item(j).getNodeType()==Node.ELEMENT_NODE){  
                    if("userName".equals(childNodes.item(j).getNodeName())){  
                        user.setUserName(childNodes.item(j).getFirstChild().getNodeValue());  
                    }else if("password".equals(childNodes.item(j).getNodeName())){  
                        user.setPassword(childNodes.item(j).getFirstChild().getNodeValue());  
                    }  
                }  
            }
            list.add(user);  
        }
        return list;  
    }  
    
    public void buildUserXml() throws ParserConfigurationException, TransformerException{
    	 //1:初始化文档建造工厂
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();  
        //2:从工厂获取建造工具
        DocumentBuilder builder = factory.newDocumentBuilder();  
        //3:新建一个Document对象  
        Document document = builder.newDocument();  
        //4:创建一个根节点  
        Element rootElement = document.createElement("users");  
        for (int i=0;i<5;i++) {  
            //5:创建一个节点  
            Element user = document.createElement("user");  
            //step6:为该节点设定属性  
            user.setAttribute("id", i+"");  
            Element userName = document.createElement("userName");  
            //为节点设定文本内容  
            userName.setTextContent("userName_"+i);  
            Element password = document.createElement("password");  
            password.setTextContent("password_"+i);  
          
            user.appendChild(userName); 
            user.appendChild(password);        
            //7:为某一元素节点设立子节点  
            rootElement.appendChild(user);  
        }  
        //8:把刚刚建立的根节点添加到document对象中  
        document.appendChild(rootElement);  
        //9:获得一个TransformerFactory对象  
        TransformerFactory transformerFactory = TransformerFactory.newInstance();  
        //10:获得一个Transformer对象  
        Transformer transformer = transformerFactory.newTransformer(); 
       

        //11:把document对象用一个DOMSource对象包装起来  
        Source xmlSource = new DOMSource(document);  
        //12:建立一个存储目标对象  
        Result outputTarget = new StreamResult(new File("src/domUser.xml"));  
        //13:生成相应的xml文件  
	    transformer.setOutputProperty("encoding", "UTF-8");//设定文档编码，属性也可以使用OutputKeys的静态常量属性设定  
	    transformer.setOutputProperty(OutputKeys.METHOD, "xml");//输出方式，可以是xml、html和text 
	    //换行
	    transformer.setOutputProperty(OutputKeys.INDENT, "yes");  
        transformer.transform(xmlSource, outputTarget);  
    	
    }
    
    public static void main(String[] args) {
        DomParseUtil dom = new DomParseUtil();  
       /* File file = new File("src/user.xml");
        List<User> userList = new ArrayList<User>();
		try {
			userList = dom.getUsers(file);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		for(User user : userList){  
            System.out.println(user.getUserName()+"---"+user.getPassword());  
    	 } */
       try {
			dom.buildUserXml();
		} catch (ParserConfigurationException e) {
 			e.printStackTrace();
		} catch (TransformerException e) {
 			e.printStackTrace();
		}
    	 
	}
} 


 
 
