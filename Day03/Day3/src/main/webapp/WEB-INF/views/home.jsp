<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="cpath" value="${pageContext.request.contextPath }" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>home</title>
</head>
<body>
<h1>대문페이지</h1>
<hr>

<div>
	<ul>
		<li><a href="${cpath }/login">로그인</a></li>
		<li><a href="${cpath }/list">게시판 목록</a></li>
	</ul>
	
	<form action="${cpath }/search">
		<input type="text" name="search" placeholder="검색어">
	</form>
	
</div>


</body>
</html>