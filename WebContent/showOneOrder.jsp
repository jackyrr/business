<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="http://cdn.bootcss.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
<title>Insert title here</title>
<style>
	body{
		margin-left: 0;
		margin-right:0;
	}
</style>
</head>
<body>
	<div class="container" style="margin-left: 0;margin-right: 0; width:100%;">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<table class="table table-striped table-hover">
				<thead>
					<tr>
						<th>编号</th>
						<th>订单号</th>
						<th>用户ID</th>
						<th>地址</th>
						<th>总价格</th>
						<th>支付方式</th>
						<th>邮费</th>
						<th>状态</th>
						<th>创建时间</th>
						<th>更新时间</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
			<tr>
				<td>${order.oid}</td>
				<td>${order.order_no}</td>
				<td>${order.user_id}</td>
				<td>${order.shipping_id}</td>
				<td>${order.payment}</td>
				<td>${order.payment_type}</td>
				<td>${order.postage}</td>
				<td>${order.status}</td>
				<td>${create_time}</td>
				<td>${update_time}</td>
				<td><a href="order.do?option=3&order_no=${order.order_no}">订单详情</a></td>
			</tr>
				</tbody>
			</table>
		</div>
	</div>
</div>
</body>
</html>