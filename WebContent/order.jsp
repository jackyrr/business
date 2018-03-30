<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
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
		<form action="order.do" style="float: right;">
			<input type="hidden" name="option" value="4" />
			<input type="text" name="inputOrder_no" /><input type="submit" value="查询"/>
		</form>
		<span>订单状态：0-已取消</span>
		<form action="order.do" method="get">
			<input type="hidden" name="option" value="5"/>
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
					<c:forEach items="${pageModel.data}" var="order">
					<input name="order_no" value="${order.order_no}" type="hidden"/>
						<tr>
							<td>${order.oid}</td>
							<td>${order.order_no}</td>
							<td>${order.user_id}</td>
							<td>${order.shipping_id}</td>
							<td>${order.payment}</td>
							<td>${order.payment_type}</td>
							<td>${order.postage}</td>
							<td>
								<select name="status">
									<option>${order.status}</option>
									<option value="0">已取消</option>
									<option value="10">未付款</option>
									<option value="20">已付款</option>
									<option value="40">已发货</option>
									<option value="50">交易成功</option>
									<option value="60">交易关闭</option>
								</select>
								<input type="submit" value="修改"/>
							</td>
							<td>${order.create_time}</td>
							<td>${order.update_time}</td>
							<td><a href="order.do?option=3&order_no=${order.order_no}">订单详情</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			</form>
			
			<table style="margin: 0 auto;">
			<ul class="pagination" >
				<c:forEach var="pageNo" begin="1" end="${pageModel.totalPage}" step="1">
					<li style="text-align: center;"><a href="order.do?pageNo=${pageNo}&pageSize=4&option=2" style="text-align: center">${pageNo}</a></li>
				</c:forEach>
			</ul>
			</table>
		</div>
	</div>
</div>
</body>
</html>