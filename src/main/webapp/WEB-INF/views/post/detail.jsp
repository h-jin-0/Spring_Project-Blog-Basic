<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../include/nav.jsp"%>

<div class="container">

	<div class="card">
		<div class="card-header">
			<h4 class="card-title">${post.title}</h4>
		</div>
		<div class="card-body">
			<p class="card-text">${post.content}</p>
		</div>
		<div class="card-footer">
			<a id="post--update--submit" href="/post/update/${post.id}?userId=${post.userId}" class="btn btn-warning">수정</a>
			<button id="post--delete--submit" class="btn btn-danger">삭제</button>
			<a href="/" class="btn btn-primary">목록</a>
		</div>
	</div>
	<br />
	<div class="card">
		<div class="form-group">
			<div class="card-body">
				<textarea rows="2" class="form-control" id="content"></textarea>
			</div>
			<div class="card-footer">
				<button id="conmment--save--submit" class="btn btn-primary">등록</button>
			</div>
		</div>
	</div>
	<br />
	<div class="card">
		<div class="form-group">

			<div class="card-header">
				<h4 class="card-title">댓글 리스트</h4>
			</div>
			<div class="comment--items card-body">
				<div class="comment--item">
					<span class="comment--content">댓글내용</span> 
					<span class="comment--delete--submit" value="1">X</span>
				</div>
				<div class="comment--item">
					<span class="comment--content">댓글내용</span> 
					<span class="comment--delete--submit" value="1">X</span>
				</div>
			</div>
			
		</div>
	</div>
</div>
<input type="hidden" id="postId" value="${post.id}" />
<script>
$('#post--delete--submit').on('click',function(){

		var data = {
			id : $('#postId').val()
		};

		$.ajax({
			type : 'DELETE',
			url : '/post/delete',
			data : JSON.stringify(data),
			contentType : 'application/json; charset=utf-8',
			dataType : 'json'
		}).done(function(r) {
			if (r.statusCode == 200) {
				alert('글 삭제 성공');
				location.href = '/';
			} else {

				alert('글 삭제 실패');
			}
		}).fail(function(r) {
			alert('글 삭제 실패');
		});

});
</script>



<%@include file="../include/footer.jsp"%>