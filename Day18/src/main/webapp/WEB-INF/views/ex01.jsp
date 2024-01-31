<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<script src="http://cdn.jsdelivr.net/npm/chart.js"></script>

<h3>ex01</h3>

<div id="root">
	<canvas id="myChart"></canvas>
</div>

<script>
	async function handler(){
		let url = 'https://apis.data.go.kr/1741000/admmPpltnHhStus/selectAdmmPpltnHhStus'
		url += '?'
		const param = {
				serviceKey : 'RQ1ckzESkp8xVq0CBtgPoDjwFz7IFHbf%2F3vPT0Yq74jPYfWPHnsEJItbxlRkyFajXIkDrVFVKPtDvBp2IQiMVg%3D%3D',
				admmCd: '2600000000',		// 행정구역의 코드
				srchFrYm: '202307',			// 조회시작년월. 2022.10부터 조회가능
				srchToYm: '202309',			// 조회종료년월. 3개월 기간내 설정
				lv: '1',					// 광역시도 단위 : 1, 시군구 단위: 2, 읍면동 단위 : 3, 읍면동 통반 단위 : 4
				regSeCd: '1',				// 등록구분. 전체:1, 거주가:2, 거주불명자:3, 재외국민:4 (기본값 : 1)
				type: 'JSON',
				numOfRows: '10',
				pageNo: '1',
		}
		for(let key in param){
			url += key + '=' + param[key] + '&'
		}
		
		// 주소와 파라미터로 요청하여 결과를 json으로 받는다
		const result = await fetch(url).then(resp => resp.json())
		
		// 전체 응답 데이터에서 필요한 부분만 가져온다
		let arr = result.Response.items.item
		
		// 배열의 차트로 띄우기 전 보기 편한 형태로 정렬을 수행한다
		arr = arr.sort((a, b) => b.toNmprCnt - a.toNmprCnt)
		
		// canvas 태그 불러오기
		const context = document.getElementById('myChart')
		
		const data = {
				labels: arr.map(e => e.ctpvNm),		//행정구역
				datasets: [
					{
						label: '전체',
						data: arr.map(e => e.totNmprCnt),
						backgroundColor: '#00ff0055'
					},
					{
						label: '남성',
						data: arr.map(e => e.maleNmprCnt),
						backgroundColor: 'blue'
					},
					{
						label: '여성',
						data: arr.map(e => e.femlNmprCnt),
						backgroundColor: 'red'
					},
				]
		}
		const config = {
				type: 'bar',		// 막대그래프(line: 꺽은선 그래프)
				data: data,			// 위에서 만든 데이터
				options: {}
		}
		const myChart = new Chart(context, config)
		// 데이터와 설정을 이용하여 canvas태그에 그림을 그리기
		
	}// end of function handler()
	
	window.addEventListener('DOMContentLoaded', handler)
</script>

</body>
</html>