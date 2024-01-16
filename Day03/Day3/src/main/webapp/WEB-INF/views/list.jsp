<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="home.jsp" %>

<div style="padding : auto; margin : auto; border : 1px solid black">
	<table>
		<thead>
			<tr>
				<td>idx</td>
				<td>title</td>
				<td>writer</td>
				<td>content</td>
				<td>wdate</td>
			</tr>
		</thead>
		<tbody>
			<tr>
				<c:forEach var="dto" items="${list }">
					<td><a href="${cpath }/view/${dto.idx}">${dto.idx }</a></td>
					<td>${dto.title }</td>
					<td>${dto.writer }</td>
					<td>${dto.content }</td>
					<td>${dto.wdate }</td>
				</c:forEach>
			</tr>
		</tbody>
	</table>
	<p><a href="${cpath }/write"><button>추가하기</button></a></p>
</div>




</body>
</html>