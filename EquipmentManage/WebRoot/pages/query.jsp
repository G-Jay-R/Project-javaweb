<%@ page language="java" import="java.util.*,java.sql.*" pageEncoding="utf-8"%>   

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head> 
	  <base href="<%=basePath%>"> 
	 <title>Insert title here</title>
  </head>
	 <body background="images/admin_else.jpg"
	style="text-align:center;">
	<h2>输入查询条件</h2>
	 <form action="pages/list.jsp" method="post" target="list">
	 	 <select name="term">
         <option value="type">设备类型</option>
         <option value="date">购入日期</option>
         <option value="brand">品牌</option>
         <option value="department" selected="selected">所属部门</option>
     </select>
	 <input type="text" name="detail">
	 <input type="submit" value="搜索">
	 </form>
	 </body>
</html>