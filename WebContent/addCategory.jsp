<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="http://cdn.bootcss.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
<title>Insert title here</title>
</head>
<body style="margin-top: 50px;">
<div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<form class="form-horizontal" role="form" action="add.do">
			<input type="hidden" name="option" value="5">
				<div class="form-group">
					 <label for="inputPassword3" class="col-sm-2 control-label">父类别</label>
					<div class="col-sm-10">
						<select name="parent_id">
			    		<c:forEach items="${Category}" var="category">
			    			<option>${category.parent_id}</option>
			    		</c:forEach>
			    		<option>0</option>
			    	</select>	
					</div>
				</div>
				<div class="form-group">
					 <label for="inputPassword3" class="col-sm-2 control-label">类别名称</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="inputPassword3"  name="name"/>
					</div>
				</div>
				<div class="form-group">
					 <label for="inputPassword3" class="col-sm-2 control-label">类别状态</label>
					<div class="col-sm-10">
			    	<select name="status">
			    		<option>1</option>
			    		<option>2</option>
			    	</select>
					</div>
				</div>
				<div class="form-group">
					 <label for="inputPassword3" class="col-sm-2 control-label">排序编号</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="inputPassword3"  name="sort_order"/>
					</div>
				</div>
					<div class="col-sm-offset-2 col-sm-10">
						 <button type="submit" class="btn btn-default">添加</button>
					</div>
				</div>
			</form>
		</div>
	</div>
</div>
<%-- 		<table>
			<form action="add.do" method="post">
			  <tr>
			    <td>父类别</td>
			    <td>
			    	<select name="parent_id">
			    		<c:forEach items="${Category}" var="category">
			    			<option>${category.parent_id}</option>
			    		</c:forEach>
			    		<option>0</option>
			    	</select>	
			    </td>
			  </tr>
			  <tr>
			    <td>类别名称</td>
			    <td>
			    	<input type="text" name="name"></input>
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
			    	<input type="text" name="sort_order"></input>
			    </td>
			  </tr>
			  	  <tr colspan="2"><input type="submit" value="添加" /></tr>
			</form>
		</table> --%>
</body>
</html>