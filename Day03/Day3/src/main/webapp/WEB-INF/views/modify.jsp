<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="home.jsp" %>

<h1>수정하기</h1>
<hr>

<div>
	<form method="POST">
		<h3>수정할 제목</h3>
		<input type="text" name="title" placeholder="제목" autofocus required>
		<h3>수정할 작성자</h3>
		<input type="text" name="writer" placeholder="작성자">
		<h3>수정할 내용</h3>
		<input type="text" name="content" placeholder="내용">
		<input type="submit">
	</form>
</div>

</body>
</html>