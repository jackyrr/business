<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>我的购物车</title>
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
	<h1 style="text-align: center;">我的购物车</h1>
	<a href="cartChecked.do?operation=1"><button>全部选择</button></a><a href="cartChecked.do?operation=2"><button>全部取消</button></a>
	<table border="0" width="100%">
		<tr>
			<th>编号</th>
			<th>用户名称</th>
			<th>商品名称</th>
			<th>数量</th>
			<th>是否选中</th>
			<th>创建时间</th>
			<th>更新时间</th>
			<th>用户操作</th>
		 </tr>
		<c:forEach items="${pageModel.data}" var="cart">
			<tr>
				<td>${cart.cid}</td>
				<td>${cart.user.username}</td>
				<td>${cart.product.name}</td>
				<td><a href="cartModify.do?operation=reduce&productid=${cart.product.id}&quantity=${cart.quantity}"><button>-</button></a>${cart.quantity}<a href="cartModify.do?operation=increase&productid=${cart.product.id}"><button>+</button></a></td>
				<td>
					<c:choose>
						<c:when test="${cart.checked eq 0}">
							未选中<a href="cartChecked.do?operation=3&productid=${cart.product.id}"><button>选中</button></a>
						</c:when>
						<c:otherwise>
							已选中<a href="cartChecked.do?operation=4&productid=${cart.product.id}"><button>取消</button></a>
						</c:otherwise>
					</c:choose>
				</td>
				<td>${cart.create_time}</td>
				<td>${cart.update_time}</td>
				<td><a href="cartDelete.do?productid=${cart.product.id}">删除</a></td>
			</tr>
		</c:forEach>
		<a href="order.do?shipping_id=10&option=1">加入订单</a>
	</table>
	
	<c:forEach var="pageNo" begin="1" end="${pageModel.totalPage}" step="1">
		<a href="cart.do?pageNo=${pageNo}" style="text-align: center">${pageNo}</a>
	</c:forEach>
	<br>	
</body>
</html>