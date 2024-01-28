<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<div id="root">
	<table id="dataList" border="1" cellpadding="10" cellspacing="0">
		<thead>
			<tr>
				<td>이미지</td>
				<td>이름</td>
				<td>주소</td>
				<td>위도</td>
				<td>경도</td>
				<td>전화번호</td>
			</tr>
		</thead>
		<tbody>
		</tbody>
	</table>
</div>

<script>
	async function getPlaceAPIHandler(){
		let url = 'https://apis.data.go.kr/6260000/BusanCulturePerformPlaceService/getBusanCulturePerformPlace'
		url += '?'
		const params = {
				'serviceKey' :'RQ1ckzESkp8xVq0CBtgPoDjwFz7IFHbf%2F3vPT0Yq74jPYfWPHnsEJItbxlRkyFajXIkDrVFVKPtDvBp2IQiMVg%3D%3D',
				'pageNo' :'1',
				'numOfRows' :'10',
				'resultType' :'json',
		}
		for(let key in params){
			url += key + '=' + params[key] + '&'
		}
		const result = await fetch(url).then(resp => resp.json())
		console.log(result.getBusanCulturePerformPlace.item)
		const data = result.getBusanCulturePerformPlace.item
		// 가져오고 싶은 필드(컬럼)의 이름을 배열로 미리 준비해두면 편리하다
		// attech, placeNm, addr, lngt, lttd, tel
		
		const tbody = document.querySelector('#dataList tbody')
		const columnName = ['attech','placeNm','addr','lngt','lttd', 'tel']
		data.forEach(e => {
			const tr = document.createElement('tr')
			
			for(let i = 0; i < columnName.length; i++){
				const td = document.createElement('td')
				td.innerText = e[columnName[i]]
				if(i==0){
					td.innerHTML = '<img src="' + e.attech + '"width="200">'
				}
				tr.appendChild(td)
			}
			tbody.appendChild(tr)
		})
	}
	window.addEventListener('DOMContentLoaded', getPlaceAPIHandler)
</script>

</body>
</html>