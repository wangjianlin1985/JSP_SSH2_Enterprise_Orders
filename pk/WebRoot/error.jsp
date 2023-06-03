<%@ page language="java" contentType="text/html; charset=utf-8"
	import="java.util.*" pageEncoding="utf-8" isELIgnored="false"%>

<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>


<title>error</title>
<link rel="stylesheet" type="text/css" href="<%=path%>/css/404.css" />


</head>

<body>
<!-- the exception and exceptionStack bean propertieswere created by Struts2's Exception Intercepter (see page 89) -->
<%
	java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss");

	java.util.Date currentTime = new java.util.Date();//得到当前系统时间

	String str_date1 = formatter.format(currentTime); //将日期时间格式化 
	String str_date2 = currentTime.toString(); //将Date型日期时间转换成字符串形式
%>
<h4 style="display: none">Exception Time: <%=str_date1 %></h4>
<h4 style="display: none">Exception Thread: <%=Thread.currentThread().toString()%></h4>
<h4 style="display: none">Exception Name: <s:property
	value="exception" /></h4>
<h4 style="display: none">Exception Details: <s:property value="exceptionStack" /></h4>
	

<div class=container>
<div class=containertop></div>
<div class=containermain>
<div class=containerleft>
<div class=leftmain><a href="#" >
<img border=0  alt=返回网站首页 src="<%=path%>/images/404/404_button.jpg" width=180 height=55></a>
 </div></div>
<div class=containerright>
<p><strong>在错误没有修复之前，建议您：</strong><br/>1、返回系统首页
<a href="http://localhost:8080/pk/main.jsp">http://www.114la.com</a>,看看Google Earth新闻解闷。
 <br/>


2、诅咒系统管理员，因为他影响到了您浏览网页的心情。</P></div></div></div>
<div class=foot>福建师范大学www.zmb.cn 版权所有<br/>2011-2012 福建师范大学桂ICP备05013869号
</div>

</body>

</html>