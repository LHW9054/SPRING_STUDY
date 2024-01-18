<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<h3>ex01.jsp</h3>

<form method="POST" enctype="multipart/form-data">
	<p><input type="file" name="upload" required></p>
	<p><input type="text" name="title" placeholder="title" required></p>
	<p><input type="submit"></p>
</form>



</body>
</html>