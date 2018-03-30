<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="http://cdn.bootcss.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
<title>Insert title here</title>
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
						<th>用户姓名</th>
						<th>商品名称</th>
						<th>商品主图</th>
						<th>单价</th>
						<th>数量</th>
						<th>总价</th>
						<th>创建时间</th>
						<th>更新时间</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${vo}" var="item">
						<tr>
							<td>${item.uoid}</td>
							<td>${item.order_no}</td>
							<td>${item.user.username}</td>
							<td>${item.product_name}</td>
							<td>${item.product_image}</td>
							<td>${item.current_unit_price}</td>
							<td>${item.quantity}</td>
							<td>${item.total_price}</td>
							<td>${item.create_time}</td>
							<td>${item.update_time}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</div>
</body>
</html>