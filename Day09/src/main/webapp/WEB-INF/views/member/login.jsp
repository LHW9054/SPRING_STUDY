<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<div id="main">
	<h3>로그인</h3>
	
	<form method="POST">
		<P><input type="text" name="userid" placeholder="ID" required autofocus></P>
		<P><input type="password" name="userpw" required></P>
		<P><input type="submit"></P>
	</form>
	<p><a href="${cpath }/member/join"><button>회원가입</button></a></p>
</div>


</body>
</html>