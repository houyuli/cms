<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="container-fluid">
	<div class="row bg-dark" style="height: 34px">
		<div class="col-md-12 pt-0.5">
			<a href="#" class="text-white">下载APP</a> <a href="/passport/reg"
				class="text-white ml-2"> 注册</a>
				<!-- 普通用户 -->
			<c:if test="${sessionScope.user!=null}">
				<div class="btn-group dropright mt-0">
					<button type="button" class="btn btn-dark btn-sm dropdown-toggle"
						data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
						${sessionScope.user.username }</button>
					<div class="dropdown-menu">
						<a class="dropdown-item" href="/my">个人中心</a> <a
							class="dropdown-item" href="/passport/logout">注销</a> 
					</div>
				</div>
			</c:if>
			  <!-- 管理员 -->
			<c:if test="${sessionScope.admin!=null}">

				<div class="btn-group dropright mt-0">
					<button type="button" class="btn btn-dark btn-sm dropdown-toggle"
						data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
						${sessionScope.admin.username }</button>
					<div class="dropdown-menu">
						<a class="dropdown-item" href="/admin">管理员中心</a> <a
							class="dropdown-item" href="/passport/logout">注销</a> 
					</div>
				</div>

			</c:if>
			
			<c:if test="${sessionScope.user==null && sessionScope.admin==null }">
				<a href="/passport/login" class="text-white ml-2">登录</a>
			</c:if>
			<div class="float-right">
				<a href="#" class="text-white">侵权投诉</a><a href="#"
					class="text-white ml-2"> 头条产品</a>
			</div>

		</div>

	</div>
</div>