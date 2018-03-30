<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="http://cdn.bootcss.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
<title>Insert title here</title>
</head>
<style>
	td{
		text-align: center;
	}
	th{
		text-align: center;
	}
</style>
<body>



	<div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<table class="table table-striped table-hover">
				<thead>
					<tr>
					<th>编号</th>
					<th>父类编号</th>
					<th>名称</th>
					<th>状态</th>
					<th>排序编号</th>
					<th>创建时间</th>
					<th>更新时间</th>
					<th>用户操作</th>
					</tr>
				</thead>
				<tbody>
		<c:forEach items="${pageModel.data}" var="category">
			<tr>
				<td>${category.id}</td>
				<td>${category.parent_id}</td>
				<td>${category.name}</td>
				<td>${category.status}</td>
				<td>${category.sort_order}</td>
				<td>${category.create_time}</td>
				<td>${category.update_time}</td>
				<td><a href="modifypage.do?id=${category.id}">修改</a>	<a href="delete.do?id=${category.id}">删除</a></td>
			</tr>
		</c:forEach>
				</tbody>
			</table>
			<table style="margin: 0 auto;">
			<ul class="pagination" >
				<c:forEach var="pageNo" begin="1" end="${pageModel.totalPage}" step="1">
					<li style="text-align: center;"><a href="category.do?pageNo=${pageNo}" style="text-align: center">${pageNo}</a></li>
				</c:forEach>
			</ul>
			</table>
		</div>
	</div>
</div>



<!-- 	<a href="addpage.do"><button>添加商品分类</button></a> -->
<%-- 	<table border="0" width="100%">
		<tr>
			<th>id</th>
			<th>parent_id</th>
			<th>name</th>
			<th>status</th>
			<th>sort_order</th>
			<th>create_time</th>
			<th>update_time</th>
			<th>用户操作</th>
		 </tr>
		<c:forEach items="${pageModel.data}" var="category">
			<tr>
				<td>${category.id}</td>
				<td>${category.parent_id}</td>
				<td>${category.name}</td>
				<td>${category.status}</td>
				<td>${category.sort_order}</td>
				<td>${category.create_time}</td>
				<td>${category.update_time}</td>
				<td><a href="modifypage.do?id=${category.id}">修改</a>	<a href="delete.do?id=${category.id}">删除</a></td>
			</tr>
		</c:forEach>
	</table>
	
	<c:forEach var="pageNo" begin="1" end="${pageModel.totalPage}" step="1">
		<a href="category.do?pageNo=${pageNo}" style="text-align: center">${pageNo}</a>
	</c:forEach>
	 --%>
</body>
</html>