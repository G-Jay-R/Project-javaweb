<%@ page language="java" import="java.util.*,com.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<base href="<%=basePath%>">
	<title></title>
  </head> 
<body background="img/4.jpg">
<center>
   <h2>查询结果</h2>
   <%
   /**
   <%!
   String ToGBK(String str){
   byte GBK[]=new byte[str.length()];
   for(int i=0;i<str.length();i++){
       GBK[i]=(byte)str.charAt(i);
   }
   return new String(GBK);
   }
  
   */ %>
   
<table width="40%" height="40%" border="1">
  <%
  Student s=(Student)session.getAttribute("s1");
  String sno=s.getSno();
  String name=s.getName();
  String sex=s.getSex();
  String age=s.getAge();
     %>  
  <%
   /**
    sno=ToGBK(sno);
  name=ToGBK(name);
  sex=ToGBK(sex);
  age=ToGBK(age);
   */ %>

 
   <tr>
   <td><h2>学号：</h2></td>
   <td><h2><%=sno %></h2></td>
   </tr>
   <tr>
   <td><h2>姓名：</h2></td>
   <td><h2><%=name %></h2></td>
   </tr>
   <tr>
  <td> <h2>性别：</h2></td>
  <td><h2><%=sex %></h2></td>
   </tr>
   <tr>
  <td> <h2>年龄：</h2></td>
  <td><h2><%=age %></h2></td>
   </tr>
   </table>
   </center>
   <center><a href="manjinru.jsp">返回到用户查询界面</a></center>
<br><br><br><br><br><br><br>
<br><br><br><br><br>
  </body>
</html>
<h4><jsp:include page="tail.jsp" flush="true"/></h4>