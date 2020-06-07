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
<link rel="shortcut icon"
	href="//sf3-dycdn-tos.pstatp.com/obj/eden-cn/uhbfnupkbps/toutiao_favicon.ico"
	type="image/x-icon">

<title>今日头条</title>
<link href="/resource/css/bootstrap.css" rel="stylesheet">
<link href="/resource/css/index.css" rel="stylesheet">
<script type="text/javascript" src="/resource/js/jquery-3.2.1.js"></script>
<script type="text/javascript" src="/resource/js/popper.min.js"></script>
<script type="text/javascript" src="/resource/js/bootstrap.js"></script>

</head>
<body>
	<!-- 头 -->
	<jsp:include page="/WEB-INF/view/index/header.jsp" />
	<!-- 主要内容 -->
	<div class="container mt-2">
		<div class="row" style="height: 550px">
			<!-- 左侧菜单 -->
			<div class="col-md-2">
				<jsp:include page="/WEB-INF/view/index/menu.jsp" />
			</div>
			<!--中间显示 文章列表 -->
			<div class="col-md-7">
				<!-- 如果是栏目id为空，则显示热点文章及轮播图-->
				<c:if test="${article.channelId==null }">
					<jsp:include page="/WEB-INF/view/index/hot.jsp" />
				</c:if>
				<!-- 如果栏目id不为null 显示分类菜单及分类文章 -->
				<c:if test="${article.channelId!=null }">
					<jsp:include page="/WEB-INF/view/index/category.jsp" />
				</c:if>
			</div>
			<!-- 右侧边栏	 -->
			<div class="col-md-3">
				<!--24小时热文 -->
				<jsp:include page="/WEB-INF/view/index/hot24articles.jsp"></jsp:include>
			</div>

		</div>

	</div>


</body>
<script type="text/javascript">
	function goPage(pageNum) {
		var channelId = '${article.channelId}';
		var categoryId = '${article.categoryId}';
		var url = "/?pageNum=" + pageNum;
		if (channelId != "")
			url += "&channelId=" + channelId;
		if (categoryId != "")
			url += "&categoryId=" + categoryId

		location.href = url;
	}
</script>

</html>