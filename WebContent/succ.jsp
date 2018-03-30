<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
	<style>
		*{
			margin: 0;
		}
	</style>
	
	
		<frameset rows="15%,85%" frameborder="no">
		<frame src="header.jsp">
		<frameset cols="20%,80%">
			<frame src="menu.jsp">
			<frame name="main" src="welcome.jsp">
		</frameset>
	</frameset>
	
	
	
<%-- <body>
		<div style="background-color: cadetblue; height: 100px; width: 100%;">
				<span style="color:white">欢迎登录${user.username}</span><h1 align="center">商品后台管理系统</h1><a href="Logout.do" style="color:white">退出</a>
		</div>
		<div style="width: 100%;height: 300px;background-color: red">
			<a href="category.do?pageNo=1"><div style="width:50%;height: 80%;background-color: yellow;float: left;">
				<h1 style="text-align: center;">分类管理</h1>
			</div></a>
			<a href="product.do?pageNo=1"><div style="width:50%;height: 80%;background-color: green;float: right;">
				<h1 style="text-align: center;">商品管理</h1>
			</div></a>
		</div>
		<div style="width: 100%;height: 300px;background-color: red">
			<div style="width:50%;height: 80%;background-color: yellow;float: left;">
				<h1 style="text-align: center;">订单管理</h1>
			</div>
			<div style="width:50%;height: 80%;background-color: green;float: right;">
				<h1 style="text-align: center;">商品销售统计</h1>
			</div>
		</div>
		
</body> --%>
</html>