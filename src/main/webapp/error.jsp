<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<title>没有找到页面 - XYZ的博客</title>
<!-- Bootstrap -->
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/imniu.css" rel="stylesheet">
</head>
<body>
    <c:import url="/navigation.jsp"></c:import>
    <!-- Page Header -->
    <header class="page-header"
        style="background-image: url('${pageContext.request.contextPath}/img/404-bg.jpg')">
        <div class="container">
            <div class="row">
                <div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1 ">
                    <div class="site-heading" style="padding-top:350px;">
                        <h1><a href="${pageContext.request.contextPath}/">404</a></h1>
	                    <span class="subheading">您来到了没有知识的荒原</span>
                    </div>
                </div>
            </div>
        </div>
    </header>
    <script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
    <!-- <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> -->
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
</body>
</html>