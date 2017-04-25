<%@ page isELIgnored="false" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String appPath = request.getContextPath();
	appPath = appPath.substring(1,appPath.length());
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>用户列表</title>
</head>
<style>
table{
	width:100%;
	border:1px solid #ccc;
	border-collapse: collapse;
}
table td,th{
	border:1px solid #ccc;
	text-align: left;
}
ul{
	font-weight:bold;
}
ul span{
	color:red;
}
</style>
<body>
<ul>
	<li>ServerPort：<span><%=request.getServerPort() %></span></li>
	<li>ServerName：<span><%=request.getServerName() %></span></li>
	<li>Application：<span><%=appPath %></span></li>
</ul>
<table>
	<tr>
		<th>用户名</th>
		<th>登录名</th>
		<th>密码</th>
	</tr>
	<c:forEach items="${list}" var="var" varStatus="vs">
	<tr>
		<td>${var.name }</td>
		<td>${var.loginName }</td>
		<td>${var.pass }</td>
	</tr>
	</c:forEach>
</table>
</body>
</html>