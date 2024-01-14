<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="cpath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>::: day02-youtube :::</title>
<style>
	.thumbnail{
		width:320px;
		height: 180px;
		background-position: center;
		background-size: 100%;
		background-repeat: no-repeat;
	}
	.thumbnail > a{
		display : block;
		width: 100%;
		height: 100%;
	}
	.item {
		width : 400px;
	}
	.wrap{
		margin : auto;
		width: 1100px;
		display:flex;
		flex-flow: wrap;
	}
</style>
</head>
<body>


<header>
	<h1><a href="${cpath }">day02</a></h1>
	<hr>
</header>


</body>
</html>