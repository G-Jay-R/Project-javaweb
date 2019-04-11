<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'testSqlJSTL.jsp' starting page</title>
    
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
	<!-- 	
		sql:setDataSource	指定数据源
		sql:query	运行SQL查询语句
		sql:update	运行SQL更新语句
		sql:param	将SQL语句中的参数设为指定值
		sql:dateParam	将SQL语句中的日期参数设为指定的java.util.Date 对象值
		sql:transaction	在共享数据库连接中提供嵌套的数据库行为元素，将所有语句以一个事务的形式来运行
	-->
	<%
		java.util.Date testDate = new Date("2016/01/16");
	%>
	<h3>测试oracle数据库连接并查询数据返回页面</h3>
		 <sql:setDataSource var="testOracleCon" driver="oracle.jdbc.driver.OracleDriver"
     		 url="jdbc:oracle:thin:@127.0.0.1:1521:orcl"
    		 user="scott"  password="orcl"/>
    	<%--  <sql:query dataSource="${testOracleCon}"  var="result">
		 	 SELECT * FROM EMP 
 		 </sql:query>	  --%>
		<sql:query dataSource="${testOracleCon}"  var="result">
		 	 SELECT * FROM EMP WHERE HIREDATE > ?
		  	 <sql:dateParam value="<%=testDate%>" type="DATE" />		  
		 </sql:query>
		 
		 <sql:update dataSource="${testOracleCon}" var="count">
		   DELETE FROM EMP WHERE EMPNO=3334 
		</sql:update>
		<p>删除影响的行数:
		<c:out value="${count}"></c:out>
		<p>
		
		
		<%-- <sql:transaction dataSource="${testOracleCon}">
		   <sql:update var="count">
		     INSERT INTO EMP(EMPNO,ENAME) VALUES(1,'A')
		   </sql:update>
		   <sql:update var="count">
		     INSERT INTO EMP(EMPNO,ENAME) VALUES(2,'B')
		   </sql:update>
		   <sql:update var="count">
		     INSERT INTO EMP(EMPNO,ENAME) VALUES(3,'C')
		   </sql:update>
		</sql:transaction>
		  --%>
		<c:forEach var="emp" items="${result.rows}">
			<p>
			<tr>
				<td><c:out value="${emp.empno}"/></td>
				<td><c:out value="${emp.ename}"/></td>
				<td><c:out value="${emp.sal}"/></td>
				<td><c:out value="${emp.deptno}"/></td>
			</tr>
			</p>
		</c:forEach>
  </body>
</html>
