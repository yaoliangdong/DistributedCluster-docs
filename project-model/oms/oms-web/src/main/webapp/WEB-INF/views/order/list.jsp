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
<title>订单列表</title>
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
		<th>商品编码</th>
		<th>SKU编码</th>
		<th>商品条码</th>
		<th>商品标题</th>
		<th>商品名称</th>
		<th>购买用户</th>
		<th>订单数量</th>
	</tr>
	<c:forEach items="${list}" var="var" varStatus="vs">
	<tr>
		<td>${var.comCode }</td>
		<td>${var.skuCode }</td>
		<td>${var.barcode }</td>
		<td>${var.title }</td>
		<td>${var.name }</td>
		<td>${var.userId }</td>
		<td>${var.qty }</td>
	</tr>
	</c:forEach>
</table>
</body>
</html>