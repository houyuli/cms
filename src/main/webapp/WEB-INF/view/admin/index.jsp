<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="/resource/css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript" src="/resource/js/jquery-3.2.1.js"></script>
<script type="text/javascript" src="/resource/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container-fluid">
		<!-- 头 -->
		<div class="row">
			<div class="col-md-12 bg-info" style="height: 50px">
				<img alt="" src="/resource/pic/logo-admin.jpg"
					class="pt-1 rounded-pill"> <strong><font
					color="white">管理员中心</font></strong>
				<div class="float-right pt-1">
					<div class="btn-group dropleft mt-0">
						<a class="dropdown-item" href="/">回到首页</a> <a
							class="dropdown-item" href="/passport/logout">注销</a>
					</div>
				</div>
			</div>
		</div>
		<!-- body -->
		<div class="row mt-2">
			<div class="col-md-2 bg-light pt-2" style="height: 550px">
				<div class="list-group">
					<a href="#" data="/admin/articles"
						class="list-group-item list-group-item-action active"> 管理文章 </a> <a
						href="#" data="/admin/users"
						class="list-group-item list-group-item-action"> 管理用户</a>
				</div>
			</div>
			<div class="col-md-10" id="center"></div>
		</div>
	</div>
</body>
<script type="text/javascript">
	$(function() {
		//默认加载所有的文章
		$("#center").load("/admin/articles");
		$("a").click(function() {
			var url = $(this).attr("data");
			$("a").removeClass("active");
			$(this).addClass("active");
			$("#center").load(url);
		})
	})
</script>
</html>