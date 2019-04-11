<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import ="com.tz.jspstudy.sysmanage.bean.User" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!doctype html>
<html>
    <head>
		<!--声明当前页面的编码集:charset=gbk,gb2312(中文编码)，utf-8国际编码-->
		<meta charset="UTF-8">
		<meta name="Keywords" content="关键词,关键字">
		<meta name="Description" content="">
		<title>用户管理</title>
		<link rel="stylesheet" href="<%=path%>/css/bootstrap.css" />
		<script type="text/javascript" src="<%=path%>/js/jquery-1.11.0.js" ></script>
		<script type="text/javascript" src="<%=path%>/js/bootstrap.js" ></script>
	</head>
<body>
	 <!--  
	    c:out	用于在JSP中显示数据 
		c:set	用于保存数据
		c:remove	用于删除数据
		c:catch	用来处理产生错误的异常状况，并且将错误信息储存起来
		c:if	与我们在一般程序中用的if一样
		c:choose	本身只当做 c:when 和 c:otherwise 的父标签
		c:when	c:choose的子标签，用来判断条件是否成立
		c:otherwise 	c:choose的子标签，接在 c:when 标签后，当 c:when 标签判断为false时被执行
		c:import 	检索一个绝对或相对 URL，然后将其内容暴露给页面
		c:forEach 	基础迭代标签，接受多种集合类型
		c:forTokens 	根据指定的分隔符来分隔内容并迭代输出
		c:param 	用来给包含或重定向的页面传递参数
		c:redirect 	重定向至一个新的URL.
		c:url 	使用可选的查询参数来创造一个URL
	 
	 -->
	 <div>
	  <h1>&lt;c:out&gt; 实例: <c:out value="我是c:out输出的值" escapeXml="true" default="如果为空则显示默认值"></c:out></h1>
	  <h1>&lt;c:out&gt; 实例: <c:out value="${sss}" escapeXml="true" default="如果为空则显示默认值"></c:out></h1>
	 </div>
	 <div>
	  <c:set value="更新" var="text" scope="page"></c:set>
      <c:set value="update" var="action" scope="page"></c:set>
      <h1>&lt;c:set&gt; 实例:${pageScope.text}</h1>
      <h1>&lt;c:set&gt; 实例:${pageScope.action}</h1>
	 </div>
	 
	 <div>
	  <c:remove var="text" scope="page"></c:remove>
      <h1>&lt;c:remove&gt; 实例:${pageScope.text}</h1>
 	 </div>
	
	 <div>
	 <c:catch var ="catchException">
  	 	<% int x = 1/0;%>
	 </c:catch>
	
	 
	 <c:if test = "${catchException != null}">
	   <h1> &lt;c:catch&gt; 异常名称 : ${catchException} </h1>
	   <h1> &lt;c:catch&gt; 异常信息: ${catchException.message}</h1>
	 </c:if>
	 </div>
	 
	 <div>
	 <c:if test = "${pageScope.action !=null}">
	   <h1>&lt;c:if&gt; 实例: action的值是存在的 </h1>
 	 </c:if>
 	 <c:if test = "${pageScope.action == update}">
	   <h1>&lt;c:if&gt; 实例: action的值==update </h1>
 	 </c:if>
	 </div>
	<!--choose when otherwise 其实跟我们java语法的swith类似 if/else  -->
	 <div>
	 <h1>&lt;c:choose when otherwise&gt; 实例:
	 <c:choose>
		<c:when test="${pageScope.action =='update'}">
			<input type = "button" value="修改" class="btn btn-primary">
		</c:when>
		<c:otherwise>
			<input type = "button" value="删除" class="btn btn-primary">
		</c:otherwise>
	</c:choose>
	 </h1>
	</div>	
	
	<!--c:import标签就是jsp:include行为标签所具有的功能  -->
	<div>
	<c:import var="data" url="../../error.html"/>
	<c:out value="${data}"/> 
	</div>
	
	<div>
	<c:import var="data" url="../../included.jsp"/>
	<c:out value="${data}"/> 
	</div>
	
	<!--for:each标签 就是类似于for循环  for循环有两种用法  -->
	<div>
	<h1>&lt;c:forEach &gt; 实例:
	<c:forEach var="i" begin="1" end="5" step="1">
   		Item: <c:out value="${i}"/>
	</c:forEach>
	</h1>
	</div>
	
	
	<!--for:each标签 就是类似于for循环  for循环有两种用法  -->
	<div>
	<h1>&lt;c:forTokens &gt; 实例:
	<c:forTokens  var="name" items="badu.com,qq.com,taobao.com" delims = ",">
   		name: <c:out value="${name}"/>
	</c:forTokens>
	</h1>
	</div>
	
	<div>
	<h1>&lt;c:param c:url&gt; 实例
		<c:url var="hrefUrl" value="test.jsp">
			<c:param name="userName" value="ssss"/>
			<c:param name="password" value="123456"/>
		</c:url>
    	<a href="/<c:out value="${hrefUrl}"/>">链接测试</a>
    	<a href="/<c:url value="${hrefUrl}"/>">链接测试</a>  	
    </h1>
	</div> 
	
	
	<%-- <c:redirect url="http://www.sina.com.cn"/> --%>
	
</body>
</html>

