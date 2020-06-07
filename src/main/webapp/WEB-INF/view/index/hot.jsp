<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!-- 显示轮播图 -->
<div class="mb-3">
	<div id="carouselExampleCaptions" class="carousel slide"
		data-ride="carousel">
		<ol class="carousel-indicators">
			<c:forEach items="${slides}" var="slide" varStatus="i">
				<li data-target="#carouselExampleCaptions"
					data-slide-to="${i.index}" class="${i.index==0?"active":""}"></li>
			</c:forEach>
		</ol>
		<div class="carousel-inner">
			<c:forEach items="${slides }" var="slide" varStatus="i">
				<div class="carousel-item ${i.index==0?"active":"" }">
					<img src="/pic/${slide.picture }" class="d-block w-100 rounded"
						alt="..." style="width: 250px; height: 220px">
					<div class="carousel-caption d-none d-md-block">
						<h5>${slide.title }</h5>
					</div>
				</div>
			</c:forEach>
		</div>
		<a class="carousel-control-prev" href="#carouselExampleCaptions"
			role="button" data-slide="prev"> <span
			class="carousel-control-prev-icon" aria-hidden="true"></span> <span
			class="sr-only">Previous</span>
		</a> <a class="carousel-control-next" href="#carouselExampleCaptions"
			role="button" data-slide="next"> <span
			class="carousel-control-next-icon" aria-hidden="true"></span> <span
			class="sr-only">Next</span>
		</a>
	</div>
	<!-- 热点文章 -->
	<div class="mt-3">
		<ul class="list-unstyled">
			<c:forEach items="${info.list}" var="hotArticle">
				<li class="media"><a href="/detail?id=${hotArticle.id }"
					target="_blank"><img style="height: 101.8px; width: 156px"
						src="/pic/${hotArticle.picture }" class="mr-3 rounded" alt="..."></a>
					<div class="media-body">
						<div class="title-box">
							<a href="/detail?id=${hotArticle.id }" target="_blank">
								${hotArticle.title }</a>
						</div>
						<p>${hotArticle.user.username}·${hotArticle.displayDate }</p>
					</div></li>
				<hr>
			</c:forEach>
		</ul>
		<jsp:include page="/WEB-INF/view/common/pages.jsp" />
	</div>


</div>