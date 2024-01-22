<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<div id="main">
	<table>
		<tr>
			<td>${dto.idx } | ${dto.title }</td>
			<td>${dto.wdate } | ${dto.viewCount }</td>
		</tr>
		<tr>
			<td>내용</td>
			<td>
			<pre>${dto.content }</pre>
			</td>
		</tr>
		<c:if test="${not empty dto.fileName }">
		<tr>
			<td>첨부파일</td>
			<td>${dto.fileName }</td>
		</tr>
		</c:if>
	</table>
	<div class="sb700">
		<div>
			<a href="${cpath }/board/list/${dto.idx}"><button>목록</button></a>
		</div>
		<div>
			<a href="${cpath }/board/delete/${dto.idx}"><button id="deleteBtn">삭제</button></a>
		</div>
	</div>
</div>

<script>
 	const delteBtn = document.getElementById('deleteBtn')
 	const deleteHandler = function(event){
 		event.preventDefault()		// 이벤트 기본 작동을 막는다
 		if('${dto.member2_userid}' != '${login.userid}'){
 			alert('본인글만삭제할수있습니다')
 			return
 		}
 		if(confirm('삭제하시겠습니까?')){
 			location.href = event.target.parentNode.href
 		}
 	}
 	deleteBtn.onclick = deleteHandler
</script>

</body>
</html>