<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<h1>음원목록</h1>
<hr>

<table border="1" cellpadding="10" cellspacing="0">
	<c:forEach var="dto" items="${list }">
	<tr>
		<td>${dto.id }</td>
		<td>${dto.isTitle != 0 ? '타이틀' : ''}</td>
		<td>${dto.artist_name }</td>
		<td>${dto.album_name }</td>
		<td>${dto.name }</td>
		<td>${dto.genre }</td>
		<td>${dto.playTime }</td>
		<td>
			<c:if test="${fn:length(dto.lyrics) > 10 }">
				${fn:substring(dto.lyrics,0, 10) }...
			</c:if>
			<c:if test="${fn:length(dto.lyrics) > 10 == false}">
				${dto.lyrics }
			</c:if>
		</td>
	</tr>
	</c:forEach>
</table>





</body>
</html>