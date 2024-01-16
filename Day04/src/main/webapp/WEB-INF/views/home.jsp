<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cpath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>home</title>
</head>
<body>

<h1>home.jsp</h1>
<hr>

<h3>version : ${version }</h3>
<h3>sysdate : ${sysdate }</h3>
<h3>tableList : ${tableList }</h3>


<ul style="border : 1px solid black; padding : auto; margin: auto;">
	<li><a href="${cpath }/ex01">ex01 - 파라미터 전달</a></li>
	<li><a href="${cpath }/ex02">ex02 - 파라미터 전달 (경로변수)</a></li>
	<li><a href="${cpath }/ex03">ex03 - 마이바티스 파라미터 전달</a></li>
	<li><a href="${cpath }/boardlist">BoardList</a></li>
</ul>

</body>
</html>