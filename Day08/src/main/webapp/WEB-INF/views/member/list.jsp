<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<h3>회원목록</h3>

<table border="1" cellpadding="10" cellspacing="0">
	<c:forEach var="dto" items="${list }">
	<tr>
		<td>${dto.userid }</td>
		<td>${dto.userpw }</td>
		<td>${dto.username }</td>
		<td>${dto.email }</td>
	</tr>
	</c:forEach>
</table>


</body>
</html>