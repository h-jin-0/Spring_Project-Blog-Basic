<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../include/nav.jsp"%>

<div class="container">

	<form>
		<div class="form-group">
			<label for="username">유저네임</label> 
			<input type="text" class="form-control" id="username" placeholder="Enter Username" />
		</div>
		<div class="form-group">
			<label for="password">비밀번호</label> 
			<input type="password" class="form-control" id="password" placeholder="Enter password" />
		</div>

	</form>

	<button id="login--submit" class="btn btn-primary">로그인</button>
</div>

<%@include file="../include/footer.jsp"%>