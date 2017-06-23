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
<title>XYZ的博客</title>
<!-- Bootstrap -->
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/imniu.css" rel="stylesheet">
</head>
<body>

    <c:import url="/navigation.jsp"></c:import>
	<!-- Page Header -->
	<header class="page-header"
		style="background-image: url('${pageContext.request.contextPath}/img/home-bg.jpg')">
		<div class="container">
			<div class="row">
				<div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1 ">
					<div class="site-heading">
						<h1>
							<a href="${pageContext.request.contextPath}/">XYZ Blog</a>
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
			<div class=" col-lg-8 col-lg-offset-1 col-md-8 col-md-offset-1 col-sm-12 col-xs-12 postlist-container ">
				<c:forEach items="${posts }" var="post">
		            <div class="post-preview">
	                    <a href="${pageContext.request.contextPath}/post/${post.path}">
	                        <h2 class="post-title">${post.title}</h2>
	                        <h3 class="post-subtitle">${post.subhead}</h3>
	                        <div class="post-content-preview">${post.summary}</div>
	                    </a>
	                    <p class="post-meta">Posted by niu on 
	                       <fmt:formatDate value="${post.createTime}" pattern="MM dd,yyyy"/> </p>
	                </div>
	                <hr>
	            </c:forEach>
				<!-- Pager -->
				<!-- <ul class="pager">
					<li class="next"><a href="/page2">Older Posts &rarr;</a></li>
				</ul> -->
			</div>
			
			<!-- Sidebar Container -->
			<div
				class=" col-lg-3 col-lg-offset-0 col-md-3 col-md-offset-0 col-sm-12 col-xs-12 sidebar-container ">
				<!-- Featured Tags -->
				<section>
					<hr class="hidden-sm hidden-xs">
					<h5>
						<a href="${pageContext.request.contextPath}/tags/">FEATURED TAGS</a>
					</h5>
					<div class="tags">
						<c:forEach items="${tags }" var="tagName">
						  <a href="${pageContext.request.contextPath}/tags/${tagName}" title="${tagName}">${tagName}</a>
						</c:forEach>
					</div>
				</section>
				<!-- Short About -->
				<section class="visible-md visible-lg">
					<hr>
					<h5>
						<a href="${pageContext.request.contextPath}/about/">ABOUT ME</a>
					</h5>
					<div class="short-about">
						<img src="${pageContext.request.contextPath}/img/minecraft.png" />
						<p>
							写写代码，看看世界，<br>离开之前，一切都是过程
						</p>
						<!-- SNS Link -->
						<ul class="list-inline">
							<li><a href="#"><span class="fa-stack fa-lg"><i
										class="fa fa-circle fa-stack-2x"></i><i
										class="fa fa-twitter fa-stack-1x fa-inverse">推特</i> </span> </a></li>
							<li><a target="_blank" href="#"><span
									class="fa-stack fa-lg"><i
										class="fa fa-circle fa-stack-2x"></i><i
										class="fa fa-stack-1x fa-inverse">知乎</i> </span> </a></li>
							<li><a target="_blank" href="#"><span
									class="fa-stack fa-lg"><i
										class="fa fa-circle fa-stack-2x"></i><i
										class="fa fa-weibo fa-stack-1x fa-inverse">微博</i> </span> </a></li>
							<li><a target="_blank" href="#"> <span
									class="fa-stack fa-lg"><i
										class="fa fa-circle fa-stack-2x"></i><i
										class="fa fa-github fa-stack-1x fa-inverse">GitHub</i> </span>
							</a></li>
						</ul>
					</div>
				</section>
				<!-- Friends Blog -->
				<hr>
				<h5>FRIENDS</h5>
				<ul class="list-inline">
					<li><a href="http://mida.re/">乱序</a></li>
					<li><a href="http://qianduan.guru/">前端外刊评论</a></li>
					<li><a href="http://lingyu.wang/">天镶的博客</a></li>
					<li><a href="https://hmqk1995.github.io">Luke 的自留地</a></li>
					<li><a href="http://ebnbin.com/">Ebn's Blog</a></li>
					<li><a href="https://blog.smdcn.net">SmdCn's Blog</a></li>
					<li><a href="http://xieminis.me/">解旻的博客</a></li>
					<li><a href="http://dhong.co">DHong Say</a></li>
					<li><a href="https://ingf.github.io/">尹峰以为</a></li>
					<li><a href="https://wepiaofei.github.io/blog/">前端神盾局</a></li>
				</ul>
			</div>
		</div>
	</div>

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
					<span>Copyright © by <a href="${pageContext.request.contextPath}/">NiuMoo</a></span>
				</div>
			</div>
		</div>
	</footer>

	<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
	<!-- <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> -->
	<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
</body>
</html>