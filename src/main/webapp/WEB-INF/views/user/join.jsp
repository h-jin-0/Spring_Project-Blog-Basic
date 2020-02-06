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
		<div class="form-group">
			<label for="email">이메일</label> 
			<input type="email" class="form-control" id="email" placeholder="Enter email" />
		</div>
	</form>
	
	<button id="join--submit" class="btn btn-primary">회원가입</button>
</div>

<%@include file="../include/footer.jsp"%>