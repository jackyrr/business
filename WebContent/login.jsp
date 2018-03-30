<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="http://cdn.bootcss.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
<title>Insert title here</title>
<style>
	body{
		background-image : url("img/bg.jpg");
	}
</style>
</head>
<body>
	<div class="container">
		<div>
			<h1 style="text-align: center;">欢迎登录后台管理系统</h1>
		</div>
	<div class="row clearfix">
		<div class="col-md-12 column">
		</div>
	</div>
	<div class="row clearfix">
		<div class="col-md-6 column">
		</div>
		<div class="col-md-6 column">
			<form role="form" action="Login.do" method="post">
				<div class="form-group">
					 <label for="exampleInputEmail1">用户名</label><input type="text" class="form-control" id="exampleInputEmail1" name="username"/>
				</div>
				<div class="form-group">
					 <label for="exampleInputPassword1">密码</label><input type="password" class="form-control" id="exampleInputPassword1" name="password" />
				</div>
				<div class="checkbox">
				</div> <button type="submit" class="btn btn-default">登录</button>
			</form>
		</div>
	</div>
</div>
	<!-- <div style="background-color: blue;">
	<h1 style="text-align: center ;color: white;">欢迎登录</h1>
	</div>
	<table align="center">
		<form action="Login.do" method="get">
			<tr>
				<td>用户名：</td>
				<td><input type="text" name="username" style="width: 200px;"></td>	
			</tr>
			<tr>
				<td>密码：</td>
				<td><input type="password" name = "password" style="width: 200px;"/></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value = "登录" style="width: 280px; background-color: blue;color: white;"/></td>
			</tr>
		</form>
	</table>
 -->
</body>
</html>