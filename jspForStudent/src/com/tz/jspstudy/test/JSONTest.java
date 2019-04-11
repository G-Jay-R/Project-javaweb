package com.tz.jspstudy.test;

import java.util.ArrayList;
import java.util.List;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import com.tz.jspstudy.sysmanage.bean.User;


public class JSONTest {

	private static String objJsonStr = "";
	private static String arryJsonStr = "";
    public static String buildJson() {
    	
    	//构造一个User对象
     	User user1 = new User();
    	user1.setUserId(1l);user1.setUserName("aaa");user1.setPassword("bbbb");
    	User user2 = new User();
    	user2.setUserId(2l);user2.setUserName("ccc");user2.setPassword("ccc");    	
    	
    	//将java对象转化为jsonObject
    	JSONObject objJson = JSONObject.fromObject(user1);
    	
    	//构造一个List<User> 对象
    	List<User> userList = new ArrayList<User>();
    	userList.add(user1);
    	userList.add(user2);
    	
    	//讲java数据集合(list,map)转化为jsonArray
    	JSONArray arrayJson = JSONArray.fromObject(userList);
        
        
        System.out.println("JSONObject对象数据格式：");
        System.out.println(objJson.toString());
        objJsonStr=objJson.toString();

      
        System.out.println("JSONArray对象数据格式：");
        System.out.println(arrayJson.toString());
        arryJsonStr = arrayJson.toString();
        return arrayJson.toString();

    }

   
    public static void parseJson() {
        //怎么获取转化为字符串的json对象和json数组   
        //JSONObject jsonObject = JSONObject.fromObject(objJsonStr);      
        JSONArray jsonArray = JSONArray.fromObject(arryJsonStr);
        
        System.out.println("字符串转对象");
        for (int i = 0; i < jsonArray.size(); i++) {
         	System.out.println(jsonArray.getJSONObject(i).get("userId"));
        	System.out.println(jsonArray.getJSONObject(i).get("userName"));
        	System.out.println(jsonArray.getJSONObject(i).get("password"));      
        }  
    }
    /**
     * @param args
     */
    public static void main(String[] args) {        
    	System.out.println(buildJson());
    	//parseJson();
    }

}