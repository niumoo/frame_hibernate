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
<title>登陆 - XYZ的博客</title>
<!-- Bootstrap -->
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/imniu.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/loginStyle.css"
	rel="stylesheet">
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-sm-6 col-md-4 col-md-offset-4">
				<div class="account-wall">
					<div id="my-tab-content" class="tab-content">
						<div class="tab-pane active" id="login">
							<img class="profile-img"
								src="${pageContext.request.contextPath}/img/google_account.png"
								alt="">
							<form class="form-signin" >
								<input type="text" class="form-control"  id="usernameLogin" placeholder="Username"
									required autofocus>
								<input type="password"	class="form-control" id="passwordLogin" placeholder="Password" required> 
							     <input type="button" onclick="login()" class="btn btn-lg btn-default btn-block btn-primary"
									value="Sign In" />
							</form>
							<div id="tabs" data-tabs="tabs">
								<p class="text-center">
									<a href="#register" data-toggle="tab">Need an Account?</a>
								</p>
								<p class="text-center">
									<a href="#select" data-toggle="tab">Select Account</a>
								</p>
							</div>
						</div>
						<div class="tab-pane" id="register">
							<form class="form-signin" action="" method="">
								<input type="text" id="username" class="form-control"  placeholder="User Name ..." required autofocus> 
								<input type="email" id="email" class="form-control" placeholder="Emaill Address ..." required> 
								<input type="password" id="password" class="form-control" placeholder="Password ..."  required> 
								<input type="submit" class="btn btn-lg btn-default btn-block" value="Sign Up" />
							</form>
							<div id="tabs" data-tabs="tabs">
								<p class="text-center">
									<a href="#login" data-toggle="tab">Have an Account?</a>
								</p>
							</div>
						</div>
						<div class="tab-pane" id="select">
							<div id="tabs" data-tabs="tabs">
								<div class="media account-select">
									<a href="#user1" data-toggle="tab">
										<div class="pull-left">
											<img class="select-img"
												src="${pageContext.request.contextPath}/img/google_account.png"
												alt="">
										</div>
										<div class="media-body">
											<h4 class="select-name">User Name 1</h4>
										</div>
									</a>
								</div>
								<hr />
								<div class="media account-select">
									<a href="#user2" data-toggle="tab">
										<div class="pull-left">
											<img class="select-img"
												src="${pageContext.request.contextPath}/img/google_account.png"
												alt="">
										</div>
										<div class="media-body">
											<h4 class="select-name">User Name 2</h4>
										</div>
									</a>
								</div>
								<hr />
								<p class="text-center">
									<a href="#login" data-toggle="tab">Back to Login</a>
								</p>
							</div>
						</div>
						<div class="tab-pane" id="user1">
							<img class="profile-img"
								src="${pageContext.request.contextPath}/img/google_account.png"
								alt="">
							<h3 class="text-center">User Name 1</h3>
							<form class="form-signin" action="" method="">
								<input type="hidden" class="form-control" value="User Name">
								<input type="password" class="form-control"
									placeholder="Password" autofocus required> <input
									type="button"  class="btn btn-lg btn-default btn-block"
									value="Sign In" />
							</form>
							<p class="text-center">
								<a href="#login" data-toggle="tab">Back to Login</a>
							</p>
							<p class="text-center">
								<a href="#select" data-toggle="tab">Select another Account</a>
							</p>
						</div>
						<div class="tab-pane" id="user2">
							<img class="profile-img"
								src="${pageContext.request.contextPath}/img/google_account.png"
								alt="">
							<h3 class="text-center">User Name 2</h3>
							<form class="form-signin" action="" method="">
								<input type="hidden" class="form-control" value="User Name">
								<input type="password" class="form-control"
									placeholder="Password" autofocus required> <input
									type="submit" class="btn btn-lg btn-default btn-block"
									value="Sign In" />
							</form>
							<p class="text-center">
								<a href="#login" data-toggle="tab">Back to Login</a>
							</p>
							<p class="text-center">
								<a href="#select" data-toggle="tab">Select another Account</a>
							</p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
	<!-- <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> -->
	<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
	<script type="text/javascript">
	function login() {
        var username = $("#usernameLogin").val();
        var password = $("#passwordLogin").val();
        $.ajax({
            url : "${pageContext.request.contextPath}/login", //请求的url地址
            dataType : "json", //返回格式为json
            async : true, //请求是否异步，默认为异步，这也是ajax重要特性
            data : {
                "username":username,
                "password" : password,
            }, //参数值
            type : "POST", //请求方式
             success:function(code){
                   if(code==1){
                	   window.location.href="${pageContext.request.contextPath}/mark/index"; 
                   }
                   if(code==0){
                       alert("登陆失败");
                   }
                   
                },
            error : function() {
                alert("出错");
            }
        });
    }
	</script>
</body>
</html>