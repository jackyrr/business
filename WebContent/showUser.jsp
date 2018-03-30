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
						<th>姓名</th>
						<th>邮箱</th>
						<th>电话号码</th>
						<th>问题</th>
						<th>答案</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${User}" var="user">
						<tr>
							<td>${user.id}</td>
							<td>${user.username}</td>
							<td>${user.email}</td>
							<td>${user.phone}</td>
							<td>${user.question}</td>
							<td>${user.answer}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</div>
</body>
</html>