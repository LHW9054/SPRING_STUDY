<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>


<h3>사용자 비밀번호 변경</h3>

<form method="POST">
	<p><input type="password" name="currentPW" placeholder="현재 비밀번호" required autofocus></p>
	<p><input type="password" name="newPW" placeholder="신규비밀번호" required></p>
	<p><input type="submit"></p>
</form>

</body>
</html>