<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<table border="1" cellpadding="10" cellspacing="0">
	<c:forEach var="dto" items="${list }">
	<tr>
		<td>${dto.idx }</td>
		<td>${dto.title }</td>
		<td>${dto.originalFileName }</td>
		<td>${dto.storedFileName }</td>
		<td>
			<div style="background-image: url('${cpath}/upload/${dto.storedFileName }');
						width:150px;
						height:150px;
						background-position:center;
						background-repeat: no-repeat;
						background-size: auto 100%;"></div>
		</td>
		<td><a href="${cpath }/upload/${dto.storedFileName}"
		       download="${dto.originalFileName }"><button>다운로드</button></a>
		</td>
		<td>
			<button class="deleteBtn" idx="${dto.idx }">삭제</button>
		</td>
	</tr>
	</c:forEach>
</table>

<script>
	const deleteBtnList = document.querySelectorAll('.deleteBtn')
	
	function deleteHandler(event){
		const idx = event.target.getAttribute('idx')
		const url = '${cpath}/ex02/delete/' + idx
		const flag = confirm('정말 삭제 하시겠습니까?')
		if(flag){
			location.href = url
		}
	}
	deleteBtnList.forEach(btn => btn.onclick = deleteHandler)
</script>


</body>
</html>