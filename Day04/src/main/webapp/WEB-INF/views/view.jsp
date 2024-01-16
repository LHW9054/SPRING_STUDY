<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cpath" value="${pageContext.request.contextPath }" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View.jsp</title>
</head>
<body>

<h1>View.jsp(단일조회)</h1>
<hr>

<fieldset>
	<table>
		<thead>
			<tr>
				<td>IDX</td>
				<td>TITLE</td>
				<td>WRITE</td>
				<td>CONTENT</td>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>${dto.idx }</td>
				<td>${dto.title }</td>
				<td>${dto.writer }</td>
				<td>${dto.content }</td>
			</tr>
		</tbody>
	</table>
</fieldset>
<p><a href="${cpath }/modify/${idx}"><button>수정</button></a></p>
<p><a href="${cpath }/delete/${idx}"><button>삭제</button></a></p>

</body>
</html>