<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<h1>회원가입</h1>
<hr>

<form method="POST">
	<p><input type="text" name="userid" placeholder="아이디" required autofocus></p>
	<p><input type="password" name="userpw" placeholder="비밀번호" required></p>
	<p><input type="text" name="username" placeholder="이름" required></p>
	<p><input type="email" name="email" required></p>
	<p><input type="submit"></p>
</form>

</body>
</html>