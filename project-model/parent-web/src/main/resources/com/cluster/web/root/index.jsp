<%@ page isELIgnored="false" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>首页</title>
<link href="assets/css/index.css" rel="stylesheet" />
<script src="assets/js/index.js" /></script>
</head>
<body>
<div style="border:1px solid gray;height:100px;line-height: 100px;">
	<h1><%=basePath %></h1>
</div>
<div style="border:1px solid gray;width:10%;float: left">
	<c:forEach items="${sysMenuList}" var="var" varStatus="vs">
	<div class="title">
		<a href="http://${var.domain }:${var.port }${var.path }${var.href }"><h3>${var.name }</h3></a>
	</div>
	</c:forEach>
</div>
<div style="border:1px solid gray;width:89.79%;float: left">

</div>
</body>
</html>