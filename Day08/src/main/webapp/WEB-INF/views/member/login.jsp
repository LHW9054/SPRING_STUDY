<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>


<h3>로그인</h3>

<form method="POST">
	<p><input type="text" name="userid" placeholder="ID" required autofocus></p>
	<p><input type="password" name="userpw" placeholder="PASSWORD" required></p>
	<p><input type="submit"></p>
</form>

<p><a href="${cpath }/member/join"><button>회원가입</button></a></p>

</body>
</html>