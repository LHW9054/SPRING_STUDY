<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ex01.jsp</title>
</head>
<body>

<h1>ex01.jsp</h1>
<hr>

<form method="POST">
	<p><input type="text" name="name" placeholder="name"></p>
	<p><input type="number" name="age" placeholder="age"></p>
	<p><input type="submit"></p>
</form>

<div>
	(Request Method)<br>
	GET								클라이언트가 자원을 받기 위한 요청<br>
	POST							클라이언트가 자원을 보내는 요청<br>
	PUT								클라이언트가 보낸 자원을 기존 자원위에 덮어 쓰기<br>
	PATCH							클라이언트가 보낸 값을 기존 자원위에 일부만 덮어쓰기<br>
	DELETE							클라이언트가 보낸 값을 이용하여 자원을 삭제하기<br>
	<br>
	(Response Status Code)<br>
	200		status OK				정상<br>
	301<br>
	302		redirect				다른 주소로 이동<br>
	400		client error			클라이언트 문제<br>
	401		unauthorized			인증되지 않음<br>
	403		fobidden				접근 거부됨(권한 부족)<br>
	404		not found				찾을수 없음<br>
	405		method not supported	메서드 미지원<br>
	500		server internal error 	서버 내부 오류<br>
	502		bad gateway				잘못된 게이트웨이<br>
</div>

</body>
</html>