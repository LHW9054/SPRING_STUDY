<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>


<div>
	<h3>게시판</h3>
	<table border="1" cellpadding="10" cellspacing="0">
		<c:forEach var="dto" items="${list }">
			<tr>
				<td>${dto.idx }</td>
				<td>
					<a href="${cpath }/board/view/${dto.idx}">
					${dto.title }
					</a>
					<c:if test="${not empty dto.fileName }">
						<span>★</span>
					</c:if>
				</td>
				
				<td>${dto.member2_username }</td>
				<td>${dto.wdate }</td>
			</tr>
		</c:forEach>
	</table>
	<div style="margin:20px 0;">
		<div></div>
		<div><a href="${cpath }/board/write"><button>새 글 작성</button></a></div>
	</div>
</div>




</body>
</html>