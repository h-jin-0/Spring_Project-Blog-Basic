<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../include/nav.jsp"%>

<div class="container">

	<form>
		<div class="form-group">
			<label for="username">유저네임</label> <input type="text" class="form-control" id="username" placeholder="Enter Username" maxlength="15" />
		</div>
		<div class="form-group">
			<label for="password">비밀번호</label> <input type="password" class="form-control" id="password" placeholder="Enter password" maxlength="15" />
		</div>
		<div class="form-group">
			<label for="email">이메일</label> <input type="email" class="form-control" id="email" placeholder="Enter email" maxlength="30" />
		</div>
	</form>

	<button id="join--submit" class="btn my__bg__pink">회원가입</button>
</div>
<script src="/js/join.js"></script>
<%@include file="../include/footer.jsp"%>