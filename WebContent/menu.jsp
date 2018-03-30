<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="js/adapter.js"></script> <!--rem适配js-->

<link rel="stylesheet" href="css/base.css"> <!--初始化文件-->
<link rel="stylesheet" href="css/menu.css"> <!--主样式-->
</head>
<body>
	<div id="menu">
    <!--隐藏菜单-->
    <div id="ensconce">
        <h2>
            <img src="images/show.png" alt="">
            国内各地景点
        </h2>
    </div>

    <!--显示菜单-->
    <div id="open">
        <div class="navH">
            <span><img class="obscure" src="images/obscure.png" alt=""></span>
        </div>
        <div class="navBox">
            <ul>
                <li>
                    <h2 class="obtain">商品类别管理<i></i></h2>
                    <div class="secondary">
                        <h3><a href="category.do?pageNo=1" target="main">查看所有商品种类</a></h3>
                        <h3><a href="addpage.do" target="main">添加分类</a></h3>
                        <h3></h3>
                    </div>
                </li>
                <li>
                    <h2 class="obtain">商品管理<i></i></h2>
                    <div class="secondary">
                        <h3><a href="product.do?pageNo=1" target="main">查看所有商品</a></h3>
                        <h3><a href="productAddpage.do" target="main">添加商品</a></h3>
                    </div>
                </li>
                <li>
                    <h2 class="obtain">订单管理<i></i></h2>
                    <div class="secondary">
                        <h3><a href="order.do?option=2&pageNo=1&pageSize=4" target="main">查看所有订单</a></h3>
                    </div>
                </li>
                <li>
                    <h2 class="obtain">会员管理<i></i></h2>
                    <div class="secondary">
                        <h3><a href="user.do" target="main">查看所有用户</a></h3>
                    </div>
                </li>
             <li>
                    <h2 class="obtain">地址管理<i></i></h2>
                    <div class="secondary">
                        <h3><a href="address.do?pageNo=1" target="main">查看所有地址</a></h3>
                    </div>
                </li> 
            </ul>
        </div>
    </div>
</div>

<script src="js/menu.js"></script> <!--控制js-->
</body>
</html>