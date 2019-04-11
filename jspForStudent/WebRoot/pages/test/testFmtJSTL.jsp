<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'testfmtJSTL.jsp' starting page</title>
    
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
	fmt:formatNumber	使用指定的格式或精度格式化数字
	fmt:parseNumber	解析一个代表着数字，货币或百分比的字符串
	fmt:formatDate	使用指定的风格或模式格式化日期和时间
	fmt:parseDate	解析一个代表着日期或时间的字符串
	fmt:bundle	绑定资源
	fmt:setLocale	指定地区
	fmt:setBundle	绑定资源
	fmt:timeZone	指定时区
	fmt:setTimeZone	指定时区
	fmt:message	显示资源配置文件信息
	fmt:requestEncoding	设置request的字符编码 
	-->
	<h3>数字格式化fmt:formatNumber:</h3>
		<c:set var="testFormatNumber" value="1234.5678" />
		<p>${testFormatNumber}整数位格式化: 
			<fmt:formatNumber type="number" maxIntegerDigits="3" value="${testFormatNumber}" />
		</p>
		<p>${testFormatNumber}小数位数字 : 
			<fmt:formatNumber type="number" maxFractionDigits="3" value="${testFormatNumber}" />
		</p>
		<p>人民币:
	 	<fmt:formatNumber value="${testFormatNumber}" type="currency"/>
		</p>
	    <p>美元 :
		<fmt:setLocale value="en_US"/>
		<fmt:formatNumber value="${testFormatNumber}" type="currency"/>
		</p>
	<h3>数字解析fmt:parseNumber:</h3>
		<c:set var="testParseNumber" value="98765.x4321" />
		<fmt:parseNumber var="i" type="number" value="${testParseNumber}" />
		<p>${testParseNumber}数字解析  : <c:out value="${i}" /></p>
		<fmt:parseNumber var="i" integerOnly="true" type="number" value="${testParseNumber}" />
		<p>${testParseNumber}数字解析 (只保留整数) : <c:out value="${i}" /></p>
		
	<h3>日期格式化fmt:formatDate:</h3>
		<c:set var="testFormatDate" value="<%=new java.util.Date()%>" />
		
		<p>日期格式化 (time): <fmt:formatDate type="time" value="${testFormatDate}" /></p>
		<p>日期格式化 (date): <fmt:formatDate type="date" value="${testFormatDate}" /></p>
		<p>日期格式化 (both): <fmt:formatDate type="both" value="${testFormatDate}" /></p>
		<p>日期格式化 (both+short): <fmt:formatDate type="both" 
						 dateStyle="short" timeStyle="short"  value="${testFormatDate}" /></p>
		<p>日期格式化 (both+medium): <fmt:formatDate type="both" 
		           		 dateStyle="medium" timeStyle="medium" value="${testFormatDate}" /></p>
		<p>日期格式化 (both+long): <fmt:formatDate type="both" 
		           		 dateStyle="long" timeStyle="long" value="${testFormatDate}" /></p>
		<p>日期格式化 (yyyy-MM-dd): <fmt:formatDate pattern="yyyy-MM-dd hh:mm:ss" value="${testFormatDate}" /></p>
	<h3>日期解析fmt:parseDate:</h3>
		<c:set var="stringDate" value="16-07-2016" />		
		<fmt:parseDate value="${stringDate}" var="testParseDate" 
		                              pattern="dd-MM-yyyy" />
		<p>解析后的日期为: <c:out value="${testParseDate}" /></p>
  </body>
</html>
