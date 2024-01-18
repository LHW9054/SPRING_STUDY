<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<h3>게시판 목록</h3>
<table border="1" cellpadding="10" cellspacing="0" >
	<c:forEach var="dto" items="${list }">
		<tr>
			<td>${dto.idx }</td>
			<td><a href="${cpath }/board/view/${dto.idx}">${dto.title }</a></td>
			<td>${dto.writer }</td>
			<td>${dto.wdate }</td>
		</tr>
	</c:forEach>
</table>

<p>
	<a href="${cpath }/board/write"><button>작성</button></a>
</p>




</body>
</html>