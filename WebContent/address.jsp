<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>我的地址</title>
</head>
<style>
	th{
		background-color: blue;
		color: white;
	 }
	td{
		text-align: center;
	}
</style>
<body>
	<h1 style="text-align: center;">我的地址管理</h1>
	<table border="0" width="100%">
		<tr>
			<th>id</th>
			<th>收货姓名</th>
			<th>收货固定电话</th>
			<th>收货移动电话</th>
			<th>省份</th>
			<th>城市</th>
			<th>区/县</th>
			<th>详细地址</th>
			<th>邮编</th>
			<th>用户操作</th>
		 </tr>
		<c:forEach items="${pageModel.data}" var="address">
			<tr>
				<td>${address.id}</td>
				<td>${address.receiver_name}</td>
				<td>${address.receiver_phone}</td>
				<td>${address.receiver_mobile}</td>
				<td>${address.receiver_province}</td>
				<td>${address.receiver_city}</td>
				<td>${address.receiver_district}</td>
				<td>${address.receiver_address}</td>
				<td>${address.receiver_zip}</td>
				<td><a href="addressModifyPage.do?id=${address.id}">修改</a>	<a href="addressDelete.do?id=${address.id}">删除</a></td>
			</tr>
		</c:forEach>
	</table>
	
	<c:forEach var="pageNo" begin="1" end="${pageModel.totalPage}" step="1">
		<a href="address.do?pageNo=${pageNo}" style="text-align: center">${pageNo}</a>
	</c:forEach>
	<br>	
	<a href="addAddress.jsp" ><button>添加地址</button></a>
</body>
</html>