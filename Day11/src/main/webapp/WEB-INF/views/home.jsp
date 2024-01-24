<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cpath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>home.jsp</h1>
<hr>
<fieldset>
	<legend>ajax01</legend>
	<button id="btn01">클릭한 시간 저장하기</button>
	<div id="result01"></div>
	
	<script>
		const btn01 = document.getElementById('btn01')
		btn01.onclick = async function(){
			const url = '${cpath}/ajax01'
			const ret = await fetch(url).then(resp => resp.text())
			const result01 = document.getElementById('result01')
			result01.innerText = ret
		}
	</script>
	
	
</fieldset>

</body>
</html>