<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
			<form action="productModify.do" method="get">
			  <tr>
			  	<td>商品ID</td>
			  	<td><input type="text" name="id" value="${product.id}"/></td>
			  </tr>
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
			  	<td><input type="text" name="name" value="${product.name}"/></td>
			  </tr>
			  <tr>
			  	<td>商品副标题</td>
			  	<td><input type="text" name="subtitle" value="${product.subtitle}"/></td>
			  </tr>
			  <tr>
			  	<td>商品主图</td>
			  	<td><input type="text" name="main_image" value="${product.main_image}"/></td>
			  </tr>
			  <tr>
			  	<td>商品附图</td>
			  	<td><input type="text" name="sub_images" value="${product.sub_images}"/></td>
			  </tr>
			  <tr>
			  	<td>商品细节</td>
			  	<td><input type="text" name="detail" value="${product.detail}"/></td>
			  </tr>
			  <tr>
			  	<td>商品价格</td>
			  	<td><input type="text" name="price" value="${product.price}"/></td>
			  </tr>
			  <tr>
			  	<td>商品库存</td>
			  	<td><input type="text" name="stock" value="${product.stock}"/></td>
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
			  <tr colspan="2"><input type="submit" value="修改" /></tr>
			</form>
		</table>
</body>
</html>