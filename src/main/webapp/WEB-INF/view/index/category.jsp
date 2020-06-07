<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!-- 显示栏目的分类 -->
<div class="subchannel">
	<ul class="sub-list">
		<li class="sub-item ${article.categoryId==null?"sub-selected":"" }"><a
			href="/?channelId=${article.channelId}">全部</a></li>
		<c:forEach items="${categorys}" var="category">
			<li class="sub-item"><a
				href="/?channelId=${article.channelId}&categoryId=${category.id }"
				class="${article.categoryId==category.id?"sub-selected":"" }">
					${category.name }</a></li>
		</c:forEach>
	</ul>
</div>
<!-- 显示文章 -->
<div>
	<ul class="list-unstyled">
		<c:forEach items="${info.list}" var="article">
			<li class="media"><a href="/detail?id=${article.id }"
				target="_blank"><img style="height: 101.8px; width: 156px"
					src="/pic/${article.picture }" class="mr-3 rounded" alt="..."></a>
				<div class="media-body">
					<div class="title-box">
						<a href="/detail?id=${article.id }" target="_blank" class="title">${article.title }</a>
					</div>
					<p>${article.user.username}·${article.displayDate }</p>
				</div></li>
			<hr>
		</c:forEach>
	</ul>
	<jsp:include page="/WEB-INF/view/common/pages.jsp" />



</div>