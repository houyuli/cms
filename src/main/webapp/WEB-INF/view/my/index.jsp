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
<title>个人中心</title>
<link href="/resource/css/bootstrap.css" rel="stylesheet">
<script type="text/javascript" src="/resource/js/jquery-3.2.1.js"></script>
<script type="text/javascript" src="/resource/js/popper.min.js"></script>
<script type="text/javascript" src="/resource/js/bootstrap.js"></script>
</head>
<body>
	<div class="container-fluid">
		<!-- 页面header -->
		<div class="row" style="background-color: #563D7C; height: 50px">
			<div class="col-md-12">
				<img alt="" src="/resource/pic/logo-my.png" width="50px"
					height="50px"> <font color="white">个人中心</font>
				<div class="float-right pt-1">
					<div class="btn-group dropleft mt-0">
						<a class="dropdown-item" href="/">回到首页</a> <a
							class="dropdown-item" href="/passport/logout">注销</a>
					</div>
				</div>
			</div>
		</div>
		<!-- body -->
		<div class="row" style="padding-top: 5px">
			<div class="col-md-2 bg-light" style="height: 550px">
				<div class="list-group text-center">
					<a href="#" data="/my/articles"
						class="list-group-item list-group-item-action active">我的文章 </a> <a
						href="#" data="/my/publish"
						class="list-group-item list-group-item-action"> 发布文章</a> <a
						href="#" class="list-group-item list-group-item-action"> 我的收藏</a>
					<a href="#" class="list-group-item list-group-item-action">
						我的评论</a>
				</div>
			</div>
			<div class="col-md-10" id="center">
				<!-- 引入kindeditor的样式 -->
				<div style="display: none">
					<jsp:include page="/resource/kindeditor/jsp/demo.jsp"></jsp:include>
				</div>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
	$(function() {
		// 当页面加载时，默认显示我的文章
		$("#center").load("/my/articles");
		//当页面加载时，为a标签添加点击事件
		$("a").click(function() {
			$("a").removeClass("active");//删除当前选中样式
			$(this).addClass("active");//为当前点击的A标签添加样式
			var url = $(this).attr("data")//获取点击a标签url
			$("#center").load(url);//在中间区域加载页面
		})
	})
</script>
</html>