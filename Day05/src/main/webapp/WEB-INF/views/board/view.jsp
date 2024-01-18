<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<h3>게시글 조회 : ${dto.idx }</h3>

<table border="1" cellpadding="10" cellspacing="0">
	<tr>
		<td>번호</td>
		<td>${dto.idx }</td>
	</tr>
	<tr>
		<td>제목</td>
		<td>${dto.title }</td>
	</tr>
	<tr>
		<td>작성자</td>
		<td>${dto.writer }</td>
	</tr>
	<tr>
		<td>작성일자</td>
		<td>${dto.wdate }</td>
	</tr>
	<tr>
		<td>내용</td>
		<td><pre style="font-size: 16px; font-family:initial;">${dto.content }</pre></td>
	</tr>
</table>

<div style="display : flex; justify-content: space-between; margin: 20px 0; width: 500px;">
	<div>
		<a href="${cpath }/board/list"><button>목록</button></a>
	</div>
	<div>
		<a href="${cpath }/board/modify/${dto.idx}"><button>수정</button></a>
		<a href="${cpath }/board/delete/${dto.idx}"><button>삭제</button></a>
	</div>
</div>


</body>
</html>