<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<h3>새글 작성</h3>
<form method="POST">
	<p><input type="text" name="title" placeholder="제목" required autofocus></p>
	<p><input type="text" name="writer" placeholder="작성자" required></p>
	<p><textarea cols="22" rows="5" name="content" placeholder="content" required></textarea></p>
	<p><input type="password" name="pw" placeholder="pw" required></p>
	<p><input type="submit"></p>
</form>

</body>
</html>