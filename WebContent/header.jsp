<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>header</title>
<style type="text/css">
	body{
		background-color:black;
	}
	.content{
		color:white;
		font-size: 30px;
	}
</style>
</head>
<body>
	<span class="content">欢迎${user.username}</span><a class="content" href="Logout.do" style="float :right;text-decoration: none">退出登录</a>
</body>
</html>