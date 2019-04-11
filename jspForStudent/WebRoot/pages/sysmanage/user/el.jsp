<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'el.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
   <div class ="tab-pane" id ="password">
			 		修改密码代码
			 		<%--  EL(Expression Language)表达式的应用  为了使JSP里面的java代码写起来更加简单。
						 主要作用：获取数据、获取 Web开发常用对象  执行运算、
						 1 :获取域里面的数据：${data}
						 2 :获取 Web开发常用对象--获取各域的对象取值
						 3 :执行运算
						 4 :[]的应用  当属性名称包含 如.- / 或? 等非字母或数字的符号
					--%>
			 		<h2>1.1返回的用户列表集合{userList} :${userList}</h2>
			 		<h2>1.2返回的用户列表第一条记录{userList[0].userName} :${userList[0].userName}</h2>
			 		<h2>1.3返回的用户名称{userName} :${userName}</h2>
			 		
			 		<!--如果没有写域名称，则检索的顺序为：pageContext(pageScope),request(requestScope),
			 								   session(sessionScope),application(applicationScope)  -->		 		
				    <h2>2.1获取{pageContext.request.contextPath}的值 :${pageContext.request.contextPath}</h2>
				    <h2>2.2获取{pageContext.request.serverPort}的值 :${pageContext.request.serverPort}</h2>
				   
				   	<h2>2.3获取{pageScope.userName}的值 :${pageScope["userName"]}</h2>	
				   	<h2>2.4获取{requestScope.userName}的值 :${requestScope.userName}</h2>				   				   	 
				   	<h2>2.5获取{sessionScope.userName}的值 :${sessionScope.userName}</h2>				   				   	
			 		<h2>2.6获取{applicationScope.testApplication}的值 :${applicationScope.testApplication}</h2>			 		
			 		<h2>2.7获取{cookie.userName.value}的值 :${cookie.userName.value}</h2>
		 			<h2>3.1判断userList是否为空：${userList==null}</h2>
			 		<h2>3.2运算表达式1+1：${1+1}</h2>
			 		
			 		<h2>4.1获取{requestScope.test-Request}的值 :${requestScope["test-Request"]}</h2>				   				   	 
			 		
			 	</div>	
  </body>
</html>
