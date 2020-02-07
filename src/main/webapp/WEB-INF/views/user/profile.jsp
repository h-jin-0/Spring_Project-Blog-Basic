<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../include/nav.jsp"%>

<div class="container">

	<form action="/user/action" method="POST" enctype="multipart/form-data">
		<div class="form-group">
			<label for="username">유저네임</label> <input type="text" class="form-control" name="username" value="${sessionScope.principal.username}" readonly="readonly" />
		</div>
		<div class="form-group">
			<label for="password">비밀번호</label> <input type="password" class="form-control" name="password" placeholder="Enter password"  />
		</div>
		<div class="form-group">
			<label for="email">이메일</label> <input type="email" class="form-control" name="email" value="${sessionScope.principal.email}" readonly="readonly" />
		</div>
		<div class="form-group">
			<label for="profile">프로필 사진</label> <input type="file" class="form-control" name="profile" value="${sessionScope.principal.profile}" />
		</div>
		<button id="login--submit" class="btn btn-primary">수정 완료</button>
	</form>


</div>

<%@include file="../include/footer.jsp"%>