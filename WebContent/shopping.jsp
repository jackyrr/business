<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<style>
	td{
		text-align: center;
	}
	table{
		font-family: verdana,arial,sans-serif;
    	font-size:14px;
     	color:#333333;
    	border-width: 1px;
    	border-color: #999999;
     	border-collapse: collapse;
	}
	th{
		background-color: blue;
		color: white;
	}
	a{	
		background-color:yellow;
		text-decoration: none;
	}
</style>
<body>

	<h1 style="text-align: center">商品浏览页面</h1><a href="cart.do?pageNo=1">我的购物车</a><a href="address.do?pageNo=1" style="color: black; float: right;">我的地址</a>
	<table border="0" width="100%">
		<tr>
			<th>id</th>
			<th>category_id</th>
			<th>name</th>
			<th>subtitle</th>
			<th>main_image</th>
			<th>sub_images</th>
			<th>detail</th>
			<th>price</th>
			<th>stock</th>
			<th>status</th>
			<th>create_time</th>
			<th>update_time</th>
			<th>用户操作</th>
		 </tr>
		<c:forEach items="${pageModel.data}" var="product">
			<tr>
				<td>${product.id}</td>
				<td>${product.category_id}</td>
				<td>${product.name}</td>
				<td>${product.subtitle}</td>
				<td>${product.main_image}</td>
				<td>${product.sub_images}</td>
				<td>${product.detail}</td>
				<td>${product.price}</td>
				<td>${product.stock}</td>
				<td>${product.status}</td>
				<td>${product.create_time}</td>
				<td>${product.update_time}</td>
				<td>
					<a href="cartAdd.do?id=${product.id}&quantity=2&pageNo=1">添加到购物车</a> 
				</td>
			</tr>
		</c:forEach>
		</form>
	</table>
	
	<c:forEach var="pageNo" begin="1" end="${pageModel.totalPage}" step="1">
		<a href="product.do?pageNo=${pageNo}" style="text-align: center">${pageNo}</a>
	</c:forEach>
	
</body>