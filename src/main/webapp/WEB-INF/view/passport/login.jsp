<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- 视窗 -->
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>用户登录</title>
<link href="/resource/css/bootstrap.css" rel="stylesheet">
<link href="/resource/css/jquery/screen.css" rel="stylesheet">
<script type="text/javascript" src="/resource/js/jquery-3.2.1.js"></script>
<script type="text/javascript" src="/resource/js/jquery.validate.js"></script>
<script type="text/javascript" src="/resource/js/bootstrap.js"></script>


</head>

<body>
	<div class="container">
		<div class="row">

			<div class="col-md-12">
				<h1>
					<c:if test="${username!=null}">
						<span class="text-danger"> 恭喜${username }，注册成功！</span>
					</c:if>
					用户登录
					<hr>
				</h1>
			</div>
		</div>
		<div class="row bg-light">
			<div class="col-md-6 ">

				<form id="form1">
					<div class="form-group">
						<label for="username">用户名：</label> <input id="username"
							type="text" name="username" class="form-control"
							value="${username }">
					</div>
					<div class="form-group">
						<label for="password">密码：</label> <input id="password"
							type="password" name="password" class="form-control">
					</div>

					<div>
						<button class="btn btn-info" type="submit">登录</button>
						<button class="btn btn-warning" type="reset">重置</button>
					</div>
					<div id="msg" class="text-danger mt-3">${msg }</div>

				</form>


			</div>
			<div class="col-md-6">

				<figure class="figure">
					<img src="/resource/pic/bg-reg.jpg"
						class="figure-img img-fluid rounded" alt="...">
					<figcaption class="figure-caption">A caption for the
						above image.</figcaption>
				</figure>

			</div>

		</div>
</body>
<script type="text/javascript">
	$(function() {
		$("#form1").validate(
				{
					//1.定义规则
					rules : {
						username : {
							required : true,
						},
						password : {
							required : true,
						}
					},
					//2.消息提示
					messages : {
						username : {
							required : "用户名必须输入",
						},
						password : {
							required : "密码必须输入",
						}
					},
					submitHandler : function() {
						$.post(
								"/passport/login",
								$("#form1").serialize(),
								function(result) {
									if (result.code == 200) {
										location.href = "/";//登录成功跳转到页面首页
									} else {
										$("#msg").text(result.msg);//登录失败
									}
								})
					}
				})
	})
</script>
</html>