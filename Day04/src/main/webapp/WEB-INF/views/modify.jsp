<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MODIFY - 수정</title>
</head>
<body>
<h1>수정하기</h1>
<hr>

<div style="border : 1px solid black; padding : auto; margin: auto;">
	<form method="POST">
		<h3>수정할 제목</h3>
		<input type="text" name="title" placeholder="제목" autofocus required>
		<h3>수정할 작성자</h3>
		<input type="text" name="writer" placeholder="작성자">
		<h3>수정할 내용</h3>
		<input type="text" name="content" placeholder="내용">
		<input type="submit">
	</form>
</div>





</body>
</html>