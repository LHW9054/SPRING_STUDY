<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<h3>json 데이터 요청해서 화면에 출력하기</h3>

<div id="root">
	<table id="table">
		<thead></thead>
		<tbody></tbody>
	</table>
</div>

<script>
	async function parkingLoadHandler(){
		const url = '${cpath}/ajax/parking/json'
		const json = await fetch(url).then(resp => resp.json())
		console.log(json)
	}
	
	window.addEventListener('DOMContentLoaded', parkingLoadHandler)
</script>

</body>
</html>