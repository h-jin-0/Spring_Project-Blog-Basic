<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../include/nav.jsp"%>

<div class="container">

	<form>
		<div class="form-group">
			<label for="username">유저네임</label> <input type="text" class="form-control" id="username" placeholder="Enter Username" />
		</div>
		<div class="form-group">
			<label for="password">비밀번호</label> <input type="password" class="form-control" id="password" placeholder="Enter password" />
		</div>

	</form>

	<button id="login--submit" class="btn my__bg__pink">로그인</button>
</div>
<script>
	$('#login--submit').on('click', function() {
		var data = {
			username : $('#username').val(),
			password : $('#password').val()
		};

		$.ajax({
			type : 'POST',
			url : '/user/login',
			data : JSON.stringify(data),
			contentType : 'application/json; charset=utf-8',
			dataType : 'json'
		}).done(function(r) {
			alert('로그인 성공');
			location.href = "/";
		}).fail(function(r) {
			alert('로그인 실패');
		});
	});
</script>
<%@include file="../include/footer.jsp"%>