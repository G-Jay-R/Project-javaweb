package com;

public class Student {
	private String sno;
	private String name;
	private String sex;
	private String age;
    public void setSno(String sno){
    	this.sno=sno;
    }
    public void setName(String name){
    	this.name=name;
    }
    public void setSex(String sex){
    	this.sex=sex;
    }
    public void setAge(String age){
    	this.age=age;
    }
    public String getSno(){
    	return sno;
    }
    public String getName(){
    	return name;
    }
    public String getSex(){
    	return sex;
    }
    public String getAge(){
    	return age;
    }
}
