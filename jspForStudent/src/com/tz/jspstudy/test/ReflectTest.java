package com.tz.jspstudy.test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.tz.jspstudy.sysmanage.bean.User;
import com.tz.jspstudy.sysmanage.bean.UserReflect;

/**
 * 
 * 类描述：  测试两个有相同属性的对象互相复制属性的值
 * 类名称：com.tz.jspstudy.test.ReflectTest       
 * 创建人：keven  
 * 创建时间：2016年7月26日 下午8:18:44     
 * @version   V1.0
 */
public class ReflectTest{
	
	/**
	 * 思路：1：获得from对象和to对象所有属性，
	 * 	   2：通过from属性的get方法得到值 ，然后通过to对象属性的set方法赋值
	 * @Title: beanReflect  
	 * @Description: TODO
	 * @param objFrom
	 * @param objTo
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 */
	public static void beanReflect(Object objFrom,Object objTo) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		//获取objFrom对象的 class
		Class objFromClass = objFrom.getClass();
 		//获取objTo对象的class
		Class objToClass = objTo.getClass();
		
		
		//通过对象获得对象的所有属性
		Field[] objFromFields = objFromClass.getDeclaredFields();
		
		Field[] objToFields = objToClass.getDeclaredFields();
		
		//轮询from对象的所有属性，与to对象里的属性匹配，然后取值和赋值
		for(int i= 0;i<objFromFields.length;i++){
			String objFromFieldName = objFromFields[i].getName();
			if(!objFromFieldName.equals("serialVersionUID")){
				for(int j= 0 ;j<objToFields.length;j++){
					String objToFeildName = objToFields[j].getName();
					
					if(objFromFieldName.equals(objToFeildName)){
						//获取get和set方法备用
						String setMethodString = "set"+objFromFieldName.substring(0,1).toUpperCase()
												+objFromFieldName.substring(1);
						//获取get和set方法备用
						String getMethodString = "get"+objFromFieldName.substring(0,1).toUpperCase()
												+objFromFieldName.substring(1);
						
						System.out.println("setMethod="+setMethodString);
						System.out.println("getMethod="+getMethodString);
						
						//获取from对象的get属性的方法
						//获取to对象的set属性的方法
						Method getMethod = objFromClass.getMethod(getMethodString, new Class[]{});					
						Method setMethod = objToClass.getMethod(setMethodString, new Class[]{objToFields[j].getType()});
						
						//取值
						Object fromValue = getMethod.invoke(objFrom, new Object[]{});
						//设置值
						setMethod.invoke(objTo, new Object[]{fromValue});
						
					}
				}
			}
		}
		
	}
	
	
	public static void main(String[] args) {
		User user = new User();
		user.setUserId(1l);
		user.setUserName("aaaa");
		UserReflect userReflect = new UserReflect();
		try {
			ReflectTest.beanReflect(user, userReflect);
			System.out.println(userReflect.getUserId());
			System.out.println(userReflect.getUserName());
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	}
	
	
}