<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<h3>ex02 - multipartFile을 포함하는 DTO형식의 업로드</h3>

<form method="POST" enctype="multipart/form-data">
	<p><input type="file" name="upload" accept="image/*"></p>
	<p><input type="text" name="title" placeholder="title"></p>
	<p><input type="submit"></p>
</form>


</body>
</html>