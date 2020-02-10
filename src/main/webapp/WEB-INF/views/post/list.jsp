<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<%@include file="../include/nav.jsp"%>

<div class="container">
	<h2>Bordered Table</h2>
	<p>The .table-bordered class adds borders on all sides of the table and the cells:</p>
	<table class="table table-bordered">
		<thead class="thead-light">
			<tr>
				<th>글 번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성 시간</th>
			</tr>
		</thead>

		<tbody>
			<c:forEach var="post" items="${posts}">
				<tr>
					<td>${post.id}</td>
					<td><a href="/post/${post.id}"> ${post.title}</a></td>
					<td>${post.username}</td>
					<td>${post.createDate}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>

<%@include file="../include/footer.jsp"%>