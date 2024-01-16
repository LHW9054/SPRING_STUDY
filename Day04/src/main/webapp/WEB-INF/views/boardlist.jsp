<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cpath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BoardList.jsp</title>
</head>
<body>

<h1>BoardListJsp</h1>
<hr>

<table style="border : 1px solid black; padding : auto; margin: auto;">
	<thead>
		<tr>
			<td>IDX</td>
			<td>TITLE</td>
			<td>WRITER</td>
			<td>CONTENT</td>
			<td>WDATE</td>
		</tr>
	</thead>
	<tbody id="data">
		<c:forEach var="dto" items="${list }">
		<tr>
			<td><a href="${cpath }/view/${dto.idx}">${dto.idx }</a></td>
			<td>${dto.title }</td>
			<td>${dto.writer }</td>
			<td>${dto.content }</td>
			<td>${dto.wdate }</td>
		</tr>
		</c:forEach>
	</tbody>
</table>
<div>
	<a href="${cpath }/write"><button>글작성하기</button></a>
</div>

</body>
</html>