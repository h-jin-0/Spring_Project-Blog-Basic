<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../include/nav.jsp"%>

<div class="container">

	<form>
		<div class="form-group">
			<label for="username">UserName</label> <input type="text" class="form-control" id="username" placeholder="Enter Username" maxlength="15" />
		</div>
		<div class="form-group">
			<label for="password">Password</label> <input type="password" class="form-control" id="password" placeholder="Enter password" maxlength="15" />
		</div>
		<div class="form-group">
			<label for="email">Email</label> <input type="email" class="form-control" id="email" placeholder="Enter email" maxlength="30" />
		</div>
	</form>

	<button id="join--submit" class="btn my__bg__pink">Join</button>
</div>
<script src="/js/join.js"></script>
<%@include file="../include/footer.jsp"%>