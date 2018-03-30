<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
			<table>
			<form action="modify.do" method="post">
			  <tr>
			  	<td>类别编号</td>
			  	<td><input type="text" name="id" value="${category.id}"/></td>
			  </tr>
			  <tr>
			    <td>父类别</td>
			    <td>
			    	<select name="parent_id">
			    		<c:forEach items="${Categorylist}" var="category">
			    			<option>${category.parent_id}</option>
			    		</c:forEach>
			    	</select>	
			    </td>
			  </tr>
			  <tr>
			    <td>类别名称</td>
			    <td>
			    	<input type="text" name="name" value="${category.name}"></input>
			    </td>
			  </tr>
			  <tr>
			    <td>类别状态</td>
			    <td>
			    	<select name="status">
			    		<option>1</option>
			    		<option>2</option>
			    	</select>
			    </td>
			  </tr>
			  <tr>
			    <td>排序编号</td>
			    <td>
			    	<input type="text" name="sort_order"value="${category.sort_order}"></input>
			    </td>
			  </tr>
			  <tr colspan="2"><input type="submit" value="修改" /></tr>
			</form>
		</table>
</body>
</html>