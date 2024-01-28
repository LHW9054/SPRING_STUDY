<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<h3>json 데이터 요청해서 화면에 출력하기</h3>

<div id="root">
	<table id="table" border="1" cellpadding="10" cellspacing="0">
		<thead></thead>
		<tbody></tbody>
	</table>
</div>

<script>
	async function parkingLoadHandler() {
		const url = '${cpath}/ajax/parking'
		const json = await fetch(url).then(resp => resp.json())
		console.log(json)
		
		const arr = json.body.items.item
		const thead = document.querySelector('#table thead')
		const tbody = document.querySelector('#table tbody')
		
		const columnNames = Object.entries(arr[0]).filter(e => e[1] != '-').map(e => e[0])
		
		const theadRow = document.createElement('tr')
		columnNames.forEach(columnName => {
			const th = document.createElement('th')
			th.innerText = columnName
			theadRow.appendChild(th)
		})
		thead.appendChild(theadRow)
		
		arr.forEach(e => {
			const tr = document.createElement('tr')
			for(let key of columnNames) {
				const value = e[key]
				const td = document.createElement('td')
				td.innerText = value
				tr.appendChild(td)
			}
			tbody.appendChild(tr)
		})
	}
	
	window.addEventListener('DOMContentLoaded', parkingLoadHandler)
</script>

</body>
</html>





