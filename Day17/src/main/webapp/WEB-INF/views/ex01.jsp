<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<script src="http://cdn.jsdelivr.net/npm/chart.js"></script>

<h3>ex01</h3>

<div id="root">
	<canvas id="myChart"></canvas>
</div>

<script>
	const arr = [
		{username : "홍길동", score : 85},
		{username : "이순신", score : 92},
		{username : "유관순", score : 78},
		{username : "강감찬", score : 96},
		{username : "정몽준", score : 88},
	]
	// canvas 태그 불러오기	
	const context = document.getElementById('myChart')
	
	const labels = arr.map(e => e.username)			// 이름만 추출
	
	const data = {
			labels: labels,							// 데이터의 라벨(이름)
			datasets: [
				{
					label: '점수',
					data: arr.map(e => e.score),	// 정수만추출
				}
			]
	}
	const config = {
			type: 'bar',	// 막대그래프 (line: 꺽은선 그래프)
			data: data,		// 위에서 만든 그래프
			option: {}
	}
	const myChart = new Chart(context, config)	// 데이터와 설정을 이용하여 canvas태그에 그림을 그리기
	
</script>

</body>
</html>