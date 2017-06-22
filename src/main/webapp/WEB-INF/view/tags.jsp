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
<title>Tags - XYZ的博客</title>
<!-- Bootstrap -->
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/imniu.css" rel="stylesheet">
</head>
<body>

    <c:import url="/navigation.jsp"></c:import>
	<!-- Page Header -->
	<header class="page-header"
		style="background-image: url('img/home-bg.jpg')">
		<div class="container">
			<div class="row">
				<div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1 ">
					<div class="site-heading">
						<h1>
							<a href="${pageContext.request.contextPath}/tags">标签</a>
						</h1>
						<!--<hr class="small">-->
						<span class="subheading">一生想做浪漫极客</span>
					</div>
				</div>
			</div>
		</div>
	</header>


	<!-- Main Content -->
	<div class="container">
		<div class="row">
			<!-- USE SIDEBAR -->
			<!-- PostList Container -->
			<div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
				<!-- 标签云 start-->
				<div id="tag_cloud" class="tags">
				    <c:forEach items="${tags }" var="tagName">
                          <a href="${pageContext.request.contextPath}/tags/${tagName}" title="${tagName}">${tagName}</a>
                    </c:forEach>
				</div>
				<!-- 标签云 end -->
				<!-- 文章列表 start -->
				<c:forEach items="${posts }" var="post">
					<div class="post-preview">
						<a href="${pageContext.request.contextPath}/post?id=${post.id}">
							<h2 class="post-title">${post.title}</h2>
							<h3 class="post-subtitle">${post.subhead}</h3>
						</a>
						<!-- <p class="post-meta">2015-10-28</p> -->
					</div>
					<hr>
				</c:forEach>
				<!-- 文章列表 end -->

			</div>
		</div>
		<!-- row  end-->
	</div>
	<!-- container end -->

	<!-- Footer -->
	<footer>
		<div class="container">
			<div class="row">
				<div
					class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1 text-center">
					<ul class="list-inline ">
						<li><a target="_blank" href="https://twitter.com/">知乎 </a></li>
						<li><a target="_blank" href="http://weibo.com/">微博 </a></li>
						<li><a target="_blank" href="https://github.com/">GitHub
						</a></li>
					</ul>
					<span>Copyright © <a href="#">by NiuMoo</a></span>
				</div>
			</div>
		</div>
	</footer>

	<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
	<!-- <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> -->
	<script src="js/bootstrap.min.js"></script>
</body>
</html>