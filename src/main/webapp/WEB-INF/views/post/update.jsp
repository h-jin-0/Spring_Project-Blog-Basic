<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../include/nav.jsp"%>

<div class="container">

	<form>
		<div class="form-group">
			<label for="title">제목</label> <input type="text" class="form-control" id="title" value="${post.title}" />
		</div>
		<div class="form-group">
			<label for="content">내용</label>
			<textarea rows="5" class="form-control" id="content">${post.content}</textarea>
		</div>
	</form>
	<button id="update--submit" class="btn my__bg__pink">수정</button>
</div>
<input type="hidden" id="postId" value="${post.id}" />
<script>
	$('#update--submit').on('click', function() {
		var data = {
			title : $('#title').val(),
			content : $('#content').val(),
			id : $('#postId').val()
		};

		$.ajax({
			type : 'PUT',
			url : '/post/update',
			data : JSON.stringify(data),
			contentType : 'application/json; charset=utf-8',
			dataType : 'json'
		}).done(function(r) {
			if (r.statusCode == 200) {
				alert('글 수정 성공');
				location.href = '/';
			} else {

				alert('글 수정 실패');
			}
		}).fail(function(r) {
			alert('글 수정 실패');
		});
	});
</script>
<%@include file="../include/footer.jsp"%>