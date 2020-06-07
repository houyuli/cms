<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="card" style="width: 18rem;">
	<div class="card-header title-box">24小时热文</div>
	<div class="card-body">

		<ul class="list-unstyled">
			<c:forEach items="${hot24Articles.list}" var="hot24Article">
				<li class="media"><a href="/detail?id=${hot24Article.id }"
					target="_blank"><img style="height: 60px; width: 60px"
						src="/pic/${hot24Article.picture }" class="mr-3 rounded" alt="..."></a>
					<div class="media-body">
					    <p class="ex">
							<a href="/detail?id=${hot24Article.id }" target="_blank">
								${hot24Article.title }</a>
						</p>
					
					</div></li>
				<hr>
			</c:forEach>
		</ul>


	</div>
</div>