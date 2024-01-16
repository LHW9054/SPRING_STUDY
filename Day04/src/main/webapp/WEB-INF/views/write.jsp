<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기</title>
</head>
<body>

<h1>새글쓰기</h1>
<hr>
<div>
	<form method="POST">
		<input type="text" name="title" placeholder="제목" required autofocus>
		<input type="text" name="writer" placeholder="작성자" >
		<input type="text" name="content" placeholder="내용" >
		<input type="submit">
	</form>
</div>

</body>
</html>