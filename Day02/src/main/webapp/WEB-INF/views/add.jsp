<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<div id="main">
	<form method="POST">
		<p><input type="text" name="title" placeholder="title" required autofocus></p>
		<p><input type="text" name="channel" placeholder="channel" required></p>
		<p><input type="text" name="thumbnail" placeholder="thumbnail" required></p>
		<p><textarea name="movietag" placeholder="movietag" required></textarea></p>
		<p><input type="submit"></p>
	</form>
</div>


</body>
</html>