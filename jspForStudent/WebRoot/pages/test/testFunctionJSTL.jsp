<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
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
		fn:contains()	测试输入的字符串是否包含指定的子串
		fn:containsIgnoreCase()	测试输入的字符串是否包含指定的子串，大小写不敏感
		fn:endsWith()	测试输入的字符串是否以指定的后缀结尾
		fn:escapeXml()	跳过可以作为XML标记的字符
		fn:indexOf()	返回指定字符串在输入字符串中出现的位置
		fn:join()	将数组中的元素合成一个字符串然后输出
		fn:length()	返回字符串长度
		fn:replace()	将输入字符串中指定的位置替换为指定的字符串然后返回
		fn:split()	将字符串用指定的分隔符分隔然后组成一个子字符串数组并返回
		fn:startsWith()	测试输入字符串是否以指定的前缀开始
		fn:substring()	返回字符串的子集
		fn:substringAfter()	返回字符串在指定子串之后的子集
		fn:substringBefore()	返回字符串在指定子串之前的子集
		fn:toLowerCase()	将字符串中的字符转为小写
		fn:toUpperCase()	将字符串中的字符转为大写
		fn:trim()	移除首位的空白符
	-->
	 
	<h3>测试jstl函数</h3>
		 <c:set var="testString" value="I am keven"/>

		<c:if test="${fn:contains(testString, 'keven')}">
		   <p>contains:千辛万苦终于找到你<p>
		</c:if>		
		<c:if test="${fn:containsIgnoreCase(testString, 'KEVEN')}">
		   <p>fn:containsIgnoreCase:原来如此!!!<p>
		</c:if> 
		
		<c:if test="${fn:startsWith(testString, 'I am')}">
		   <p>fn:fn:startsWith:字符串以 I am 开头<p>
		</c:if>
		
		<c:if test="${fn:endsWith(testString, 'ven')}">
		   <p>fn:endsWith:字符串以 ven 结尾<p>
		</c:if>
		
		<c:set var="testXmlString" value="I am <aaa>keven </aaa>"/>
	 	<p>使用 escapeXml() 函数:${fn:escapeXml(testXmlString)}</p>
	 	<p>不使用 escapeXml() 函数:${testXmlString}</p>		 	
		<p>fn:indexOf : ${fn:indexOf(testString, "keven")}</p>
					
		<c:set var="testSplitString" value="${fn:split(testString, ' ')}" />
		<c:set var="testJoinString" value="${fn:join(testSplitString, '-')}" />
		
		<p>fn:split : ${testSplitString}</p>
		<p>fn:join : ${testJoinString}</p>
		
		<c:set var="testRepalceString" 
				value="${fn:replace(testString,'keven','arry')}" />
		<p>fn:replace : ${testRepalceString}</p>
		
		<p>fn:length : ${fn:length(testString)}</p>
		
		<c:set var="substring" value="${fn:substring(testString, 0, 5)}" />
		<c:set var="substringAfter" value="${fn:substringAfter(testString, 'am')}" />
		<c:set var="substringBefore" value="${fn:substringBefore(testString, 'am')}" />
		
		<p>fn:substring : ${substring}</p>
		<p>fn:substringAfter : ${substringAfter}</p>
		<p>fn:substringBefore : ${substringBefore}</p>
		
		
		<c:set var="lowercaseString" value="${fn:toLowerCase(testString)}" />
		<c:set var="uppercaseString" value="${fn:toUpperCase(testString)}" />
		<p>fn:toLowerCase : ${lowercaseString}</p>
		<p>fn:toUpperCase : ${uppercaseString}</p>
		
		<!--移除首位的空白符 -->
		<c:set var="trimString" value="${fn:trim(testString)}" />
		<p>fn:trim : ${trimString}</p>
			
			
  </body>
</html>
