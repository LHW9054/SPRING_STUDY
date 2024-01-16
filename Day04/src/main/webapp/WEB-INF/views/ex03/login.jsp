<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cpath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>ex03/login.jsp</h1>
<hr>

<fieldset>
<legend>따로 전달</legend>
	<form method="POST" action="${cpath }/ex03/post1">
		<p><input type="text" name="userid" placeholder="ID"></p>
		<p><input type="password" name="userpw" placeholder="PASSWORD"></p>
		<p><input type="submit"></p>
	</form>
</fieldset>
<br>

<fieldset>
<legend>Hash Map으로 받기</legend>
	<form method="POST" action="${cpath }/ex03/post2">
		<p><input type="text" name="userid" placeholder="ID"></p>
		<p><input type="password" name="userpw" placeholder="PASSWORD"></p>
		<p><input type="submit"></p>
	</form>
</fieldset>
<br>

<fieldset>
<legend>DTO로 받기</legend>
	<form method="POST" action="${cpath }/ex03/post3">
		<p><input type="text" name="userid" placeholder="ID"></p>
		<p><input type="password" name="userpw" placeholder="PASSWORD"></p>
		<p><input type="submit"></p>
	</form>
</fieldset>

</body>
</html>


