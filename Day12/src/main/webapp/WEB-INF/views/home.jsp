<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cpath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Day12</title>
<style>
	div.content{
		width : 700px;
		padding : 10px;
		border: 2px solid black;
	}
</style>
</head>
<body>

<h1>home.jsp</h1>
<hr>

<div class="content">
	<h3>AJAX (Asynchronous Javascript And XML)</h3>
	<h3>비동기 형식의 자바스크립트와 xml을 이용한 통신</h3>
	<h3>실시간으로 수행되는 자바스크립트와 백엔드 사이의 통신</h3>
	<ul>
		<li>기본적으로 HTTP 프로토콜의 규칙을 따라간다</li>
		<li>request는 보다 다양하게 활용할수 있어서, GET/POST/PUT/PATCH/DELETE 등의 요청메서드를 모두 활용할수 있다</li>
		<li>response는 HTML 형식을 따르는 대신, XML 혹은 JSON형식으로 "객체"를 반환한다</li>
		<li>JS기반의 객체형식을 주고받기 때문에, JavaScript Object Notation(=JSON) 형식을 사용한다</li>
	</ul>
</div>

<div class="content">
	<h3>AJAX를 쓰지 않더라도, JS의 이벤트 처리를 이용하면 페이지 새로고침 없이 내용을 변경할수 있다</h3>
	<button id="btn1">버튼1</button>
	<span id="span1"></span>
	
	<script>
		const btn1 = document.getElementById('btn1')
		let num = 1
		btn1.onclick = function(){
			const span1 = document.getElementById('span1')
			span1.innerText = 'Hello' + num
			num++
		}
	</script>
</div>
<div class="content">
	<h3>백엔드(컨트롤러)에 데이터를 요청하여 응답받고, 그 값을 문서에 반영하기</h3>
	<button id="btn2">버튼2</button>
	<span id="span2"></span>
	
	<script>
		const btn2 =document.getElementById('btn2')
		btn2.onclick = function(){
			const url = '${cpath}/ajax2'		// 요청할 주소를 지정한다
			
			fetch(url)							// 지정한 주소로 요청을 전송한다 (이후 컨트롤러 코드 실행)
			.then(resp => resp.text())			// 서버가 응답을 반환하면 텍스트 형식으로 변환한다
			.then(text => {						// 해당 텍스트를 이용하여 아래 코드를 수행한다
				const span2 = document.getElementById('span2')	// 문서의 span2를 불러와서
				span2.innerText = '서버에서 보낸값 : ' + text		// 글자를 넣는다
			})
		}
	</script>
</div>

<div class="content">
	<p><input type="text" name="name" placeholder="이름" required autofocus></p>	
	<p><input type="number" name="age" placeholder="나이" required></p>
	<p>
		<input id="btn3" type="button" value="GET" >
		<input id="btn4" type="button" value="POST" >
	</p>
	<p><input id="btn3" type="button" value="확인"></p>
	<p><span id="span3"></span></p>
	
	<script>
		const btn3 = document.getElementById('btn3')
		btn3.onclick = function(){
			const name = document.querySelector('input[name = "name"]')
			const age = document.querySelector('input[name = "age"]')
			
			// GET 요청이면 일반요청과 동일하게 쿼리스트링 형식을 이용하여 파라미터를 전달할수 있다
			// GET 은 body를 가지지 않기 때문에, 주소창을 통해서 전달해야 한다
			const url = '${cpath}/ajax3?name=' + name.value + '&age=' + age.value
			fetch(url)
			.then(resp => resp.text())
			.then(text => {
				const span3 = document.getElementById('span3')
				span3.innerText = text
			})
		}
	</script>
	
	<script>
		const btn4 = document.getElementById('btn4')
		btn4.onclick = function(){
			const name = document.querySelector('input[name = "name"]')
			const age = document.querySelector('input[name = "age"]')
			const param = {					// JS객체는 HashMap처럼 구성한다
				name: name.value,			// : 왼쪽에는 필드 및 메서드의 이름을 지정한다
				age: +age.value				// : 오른쪽에는 값을 지정하고 ,로 구분해야한다
			}								// 문자열앞에 +를 붙이면 Integer.parseInt() 와 같이 숫자로 변경한다
			
			console.log(param, typeof(param))
			console.log(JSON.stringify(param), typeof(JSON.stringify(param)))
			
			const url = '${cpath}/ajax4'
			const opt = {
					method: 'POST',
					body : JSON.stringify(param),	// JS객체를 문자열 형식으로 변환한다
					headers: {
						'Content-Type' : 'application/json;charset=utf-8'
						// 객체의 이름에 -가 들어가야 한다면 문자열 처럼 따음표로 묶어야 한다.
						// -는 산술연산자 빼기로 식별하기 때문
						// Context-Type은 body에담겨서 전송되는 데이터의 형식을 명시한다
					}
			}
			fetch(url, opt)
			.then(resp => resp.text())
			.then(text => {
				const span4 = document.getElementById('span4')
				span4.innerText = text
			})
		}
	</script>
</div>

<div class="content">
	<h3>회원가입</h3>
	<form id="joinForm">
	<p>
		<input type="text" name="userid" placeholder="ID">
		<input id="btn5" type="button" value="중복확인">
	</p>
	<p>
		<span id="span5"></span>
	</p>
	<P><input type="password" name="userpw" placeholder="Password" required></P>
	<P><input type="text" name="username" placeholder="Name" required autocomplete="off"></P>
	<p>
		<select name="gender" required>
			<option value="">===성별선택===</option>
			<option value="남성">남성</option>
			<option value="여성">여성</option>
		</select>
	</p>
	<p><input type="submit" value="가입"></p>
	</form>
	
	<script>
		// 1) 입력된 아이디가 사용중인 아이디 인지 체크하기
		const btn5 = document.getElementById('btn5')
		btn5.onclick = async function(){
			const userid = document.querySelector('input[name="userid"]')
			const url = '${cpath}/ajax5?userid=' + userid.value
			if(userid.value==''){
				alert('사용할 아이디를 먼저 입력하세요')
				userid.focus()
				return
			}
			
			
			
			// 지정한 주소로 요청한 후, 응답이 오면 응답을 json형태로 변환하여 result에 저장한다
			const result = await fetch(url).then(resp => resp.json())
			console.log(result)
			const span5 = document.getElementById('span5')
			span5.innerText = result.msg
			span5.style.coler = result.color
		}
		
		// 2) 회원가입
		const joinForm = document.getElementById('joinForm')
		joinForm.onsubmit = async function(event){
			event.preventDefault()	// 기본작동막기. form이 제출되지 않느다
			const formData = new FormData(joinForm)	// form 안에 있는 input을 다 불러온다
			const ob = {}							// 빈 JS 객체를 준비한다
			for(let element of formData.entries()){	// 내부에는 [key, value] 형식으로 되었다
				ob[element[0]] = element[1]			// 0번재 key, 1번째는 value
			}
			
			const url = '${cpath}/join'
			const opt = {
					method: 'POST',
					body : JSON.stringify(ob),
					headers: {
						'Content-Type' : 'application/json;charset=utf-8'
					}
			}
			const result = await fetch(url, opt).then(resp => resp.json())
			alert(result.status)
			if(result.status == '가입성공'){
				joinForm.reset()
				document.getElementById('span5').innerText = ''
			}
			
			
		}
	</script>
</div>

<div class="content">
	<h3>현재 가입된 목록</h3>
	<table id="table">
		<thead>
			<tr>
				<td>userid</td>
				<td>userpw</td>
				<td>username</td>
				<td>gender</td>
			</tr>
		</thead>
		<tbody></tbody>
	</table>
	<script>
		window.addEventListener('DOMContentLoaded', async function(){
			const tbody = document.querySelector('#table tbody')
			const url = '${cpath}/memberList'
			const memberList = await fetch(url).then(resp => resp.json())
			console.log(memberList)
			
			
			let tag = ''
			memberList.forEach(e => {
				tag += '<tr>'
				tag += '<td>' + e.userid + '</td>'
				tag += '<td>' + e.userpw + '</td>'
				tag += '<td>' + e.username + '</td>'
				tag += '<td>' + e.gender + '</td>'
				tag += '</tr>'
			})
			tbody.innerHTML = tag
		})	
	</script>
</div>






















	
	
	

</body>
</html>