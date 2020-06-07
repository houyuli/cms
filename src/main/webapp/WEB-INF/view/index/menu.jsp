<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- 栏目菜单 -->
<div class="channel">
	<ul>
		<li class="mb-2"><a href="/" class="logo"> <img alt=""
				src="/resource/pic/logo-index.png" width="108px" height="27px">
		</a></li>
		<li><a href="/" class="channel-item ${article.channelId==null?"active":""}">热点</a></li>
		<c:forEach items="${channels}" var="channel">
			<li><a href="/?channelId=${channel.id}"
				class="channel-item ${article.channelId==channel.id?"active":"" }">${channel.name }</a></li>
		</c:forEach>
	</ul>

</div>