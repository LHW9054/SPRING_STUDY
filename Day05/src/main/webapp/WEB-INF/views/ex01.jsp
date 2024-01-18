<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<h3>ex01 - multipartRequest를 활용한 파일 업로드</h3>

<form method="POST" enctype="multipart/form-data">
	<p><input type="file" name="upload" accept="image/*"></p>
	<p><input type="submit"></p>
</form>

</body>
</html>