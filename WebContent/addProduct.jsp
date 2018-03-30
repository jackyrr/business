<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="http://cdn.bootcss.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
<title>Insert title here</title>
</head>
<body style="margin-top: 30px;">
<div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<form class="form-horizontal" role="form" action="addProduct.do">
			<input type="hidden" name="option" value="5">
<!-- 				<div class="form-group">
					 <label for="inputEmail3" class="col-sm-2 control-label">编号</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="inputEmail3"  name="tid"/>
					</div>
				</div> -->
				<div class="form-group">
					 <label for="inputPassword3" class="col-sm-2 control-label">商品类别</label>
					<div class="col-sm-10">
			  		<select name="category_id">
			  			<c:forEach items="${Category}" var="category">
			  				<option value="${category.id}">${category.name}</option>
			  			</c:forEach>
			  		</select>
					</div>
				</div>
				<div class="form-group">
					 <label for="inputPassword3" class="col-sm-2 control-label">商品名称</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="inputPassword3"  name="name"/>
					</div>
				</div>
				<div class="form-group">
					 <label for="inputPassword3" class="col-sm-2 control-label">商品副标题</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="inputPassword3" name="subtitle"/>
					</div>
				</div>
				<div class="form-group">
					 <label for="inputPassword3" class="col-sm-2 control-label">商品主图</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="inputPassword3"  name="main_image"/>
					</div>
				</div>
				<div class="form-group">
					 <label for="inputPassword3" class="col-sm-2 control-label">商品附图</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="inputPassword3"  name="sub_images"/>
					</div>
				</div>
				<div class="form-group">
					 <label for="inputPassword3" class="col-sm-2 control-label">商品细节</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="inputPassword3"  name="detail"/>
					</div>
				</div>
				<div class="form-group">
					 <label for="inputPassword3" class="col-sm-2 control-label">商品库存</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="inputPassword3"  name="stock"/>
					</div>
				</div>
				<div class="form-group">
					 <label for="inputPassword3" class="col-sm-2 control-label">商品价格</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="inputPassword3"  name="price"/>
					</div>
				</div>
				<div class="form-group">
					 <label for="inputPassword3" class="col-sm-2 control-label">商品状态</label>
					<div class="col-sm-10">
						<select name="status">
			  			<option>1</option>
			  			<option>2</option>
			  			</select>
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						 <button type="submit" class="btn btn-default">添加</button>
					</div>
				</div>
			</form>
		</div>
	</div>
</div>
<%-- 	<table>
			<form action="addProduct.do" method="get">
			  <tr>
			  	<td>商品类别</td>
			  	<td>
			  		<select name="category_id">
			  			<c:forEach items="${Category}" var="category">
			  				<option value="${category.id}">${category.name}</option>
			  			</c:forEach>
			  		</select>
			  	</td>
			  </tr>
			    <tr>
			  	<td>商品名称</td>
			  	<td><input type="text" name="name"/></td>
			  </tr>
			  <tr>
			  	<td>商品副标题</td>
			  	<td><input type="text" name="subtitle"/></td>
			  </tr>
			  <tr>
			  	<td>商品主图</td>
			  	<td><input type="text" name="main_image"/></td>
			  </tr>
			  <tr>
			  	<td>商品附图</td>
			  	<td><input type="text" name="sub_images"/></td>
			  </tr>
			  <tr>
			  	<td>商品细节</td>
			  	<td><input type="text" name="detail"/></td>
			  </tr>
			  <tr>
			  	<td>商品价格</td>
			  	<td><input type="text" name="price"/></td>
			  </tr>
			  <tr>
			  	<td>商品库存</td>
			  	<td><input type="text" name="stock"/></td>
			  </tr>
			  <tr>
			  	<td>商品状态</td>
			  	<td>
			  		<select name="status">
			  			<option>1</option>
			  			<option>2</option>
			  		</select>
			  	</td>
			  </tr>
			  <tr colspan="2"><input type="submit" value="添加" /></tr>
			</form>
		</table> --%>
</body>
</html>