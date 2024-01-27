<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<div>
	<h1>회원가입</h1>
	<form method="POST">
		<p><input type="text" name="userid" placeholder="아이디" required autofocus></p>
		<p><input type="password" name="userpw" placeholder="비밀번호" required></p>
		<p><input type="text" name="username" placeholder="사용자 이름" required></p>
		<p><input type="email" id="email" name="email" placeholder="이메일" required></p>
		<p>
			<input id="birth" type="date" name="birth">
			<label for="birth">생일</label>
		</p>
		<p>
			<input id="text" name="authNumber" placeholder="인증번호 입력" required>
			<input type="button" id="sendAuthNumber" value="인증번호 발송">
		</p>
		<p><input type="submit" value="가입신청"></p>
	</form>
</div>

<script>
	const sendAuthNumber = document.getElementById('sendAuthNumber')
	sendAuthNumber.onclick = function(event){
		const url = '${cpath}/ajax/sendAuthNumber'
		const email = document.getElementById('email')
		
		if(email.value == ''){
			alert('인증번호를 받을 이메일을 정확하게 입력해 주세요')
			email.focus()
			return
		}
		
		fetch(url + '?email=' + email.value)
		.then(resp => resp.text())
		.then(text => {
			alert(text)
		})
	}
	
	// 회원가입시 인증번호부터 체크하고 이후 인증번호가 일치하면 가입 프로세스를 진행
	const form = document.forms[0]
	
	form.onsubmit = async function(event){
		event.preventDefault()	// 일반 회원가입 시도를 막아두고
								// 사용자가 입력한 인증번호를 서버로 전달하기 위해 불러온다
		const authNumber = document.querySelector('input[name="authNumber"]')
		
		// @PathVariable 형태로 전달
		const url = '${cpath}/ajax/checkAuthNumber/' + authNumber.value
		
		// @요청 결과는 1 아니면 0
		const authResult = await fetch(url).then(resp => resp.text())
		
		
		if(authResult == 0){					// 결과가 0이면
			alert('인증번호가 맞지 않습니다')			// 경고창을 띄우고
			return								// 함수를 종료한다(프로세스를 중단하여 가입을 진행하지 않는다)
		
		}else{									// 0이 아니면1, 인증 성공이므로 가입으로 진행한다
			event.target.submit()
		}e
	}
	
</script>


































</body>
</html>