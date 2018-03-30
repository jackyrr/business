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
			<th>类别编号</th>
			<th>名称</th>
			<th>标题</th>
			<th>主图</th>
			<th>附图</th>
			<th>细节</th>
			<th>价格</th>
			<th>库存</th>
			<th>状态</th>
			<th>创建时间</th>
			<th>更新时间</th>
			<th>操作</th>
					</tr>
				</thead>
				<tbody>
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
				<td><a href="productModifyPage.do?id=${product.id}">修改</a>	<a href="productDelete.do?id=${product.id}&pageNo=1">删除</a></td>
			</tr>
		</c:forEach>
				</tbody>
			</table>
			<table style="margin: 0 auto;">
			<ul class="pagination" >
				<c:forEach var="pageNo" begin="1" end="${pageModel.totalPage}" step="1">
					<li style="text-align: center;"><a href="product.do?pageNo=${pageNo}" style="text-align: center">${pageNo}</a></li>
				</c:forEach>
			</ul>
			</table>
		</div>
	</div>
</div>

	<!-- <a href="productAddpage.do"><button>添加商品</button></a> -->
<%-- 	<table border="0" width="100%">
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
				<td><a href="productModifyPage.do?id=${product.id}">修改</a>	<a href="productDelete.do?id=${product.id}&pageNo=1">删除</a></td>
			</tr>
		</c:forEach>
	</table>
	
	<c:forEach var="pageNo" begin="1" end="${pageModel.totalPage}" step="1">
		<a href="product.do?pageNo=${pageNo}" style="text-align: center">${pageNo}</a>
	</c:forEach>
	 --%>
</body>
</html>
