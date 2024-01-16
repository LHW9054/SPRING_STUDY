<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="home.jsp" %>

<div>
		<div>${dto.idx }</div>
		<div>${dto.title }</div>
		<div>${dto.writer }</div>
		<div>${dto.content }</div>
	<a href="${cpath }/modify/${idx}"><button>수정</button></a>
	<a href="${cpath }/delete/${idx}"><button id="deleteBtn">삭제</button></a>
</div>

<script>
	const deleteBtn = document.getElementById('deleteBtn')
	
	function deleteHandler(){
		const idx = '${dto.idx}'
		const flag = confirm('삭제 하시겠습니까')
		if(idx != '' && flag){
			location.href = '${cpath}/delete/'
		}
	}
	deleteBtn.addEventListener('click', deleteHandler)
</script>




</body>
</html>