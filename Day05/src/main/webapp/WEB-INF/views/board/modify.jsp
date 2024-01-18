<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<c:if test="${empty dto }">
	<form method="POST">
		<h3>게시글 수정 (패스워드 입력)</h3>
		<p><input type="password" name="pw" placeholder="글작성시 입력한 패스워드" required autofocus></p>
		<p><input type="submit" value="수정하기"></p>
	</form>
</c:if>

<c:if test="${not empty dto }">
	<form method="POST" action="${cpath }/board/update/${dto.idx}">
		<p><input type="text" name="title" placeholder="title" value="${dto.title }" required autofocus></p>
		<p><input type="text" name="writer" placeholder="writer" value="${dto.writer }" required ></p>
		<p><textarea cols="22" rows="5" name="content" placeholder="content" required>${dto.content }</textarea></p>
		<p><input type="submit"></p>
	</form>
</c:if>


</body>
</html>