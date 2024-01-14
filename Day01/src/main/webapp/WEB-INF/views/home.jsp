<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cpath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>home.jsp</title>
</head>
<body>

<h1>home.jsp</h1>
<hr>

<h3>Hello</h3>
<h3>접손된 DB의 버전 ${version }</h3>

<ul>
	<li><a href="${cpath }/ex01">ex01 - 파라미터 전달 및 출력</a></li>
	<li><a href="${cpath }/ex02">ex02 - 파라미터 전달 및 출력</a></li>
	<li><a href="${cpath }/ex03">ex03 - DB 데이터 리스트 불러와서 출력</a></li>
</ul>






<div>
	<ul>
		<li>@Controller 지정한 클래스를 스프링 빈으로 등록하고, MVC구조의 컨트롤러 역활을 수행하도록 한다</li>
		<li>@Service 지정한 클래스를 스프링 빈으로 등록하고, MVC구조의 서비스 역할을 수행하도록 한다</li>
		<li>@Repository 지정한 클래스를 스프링 빈으로 등록하고, MVC구조의 서비스역할을 수행하도록 한다<br>
			해당 클래스에서 발생하는 예외는 SQLException 형식으로 변경하여 throws한다</li>
		<li>@Autowired 필드, setter, 생성자에 붙어서 스프링 빈 간의 의존관계를 자동으로 연결한다 <br>
			타입(자료형)을 우선으로 탐색하고, 타입이 일치하는 요소가 있다면 id로 판별할 수 있다</li>
		<li>@RequestMapping value에는 요청 주소를 지정하고, method에는 요청 메서드를 지정한다<br>
			일치하는 요청이 발생하면, 메서드를 호출한다<br>
			컨트롤러 클래스에 지정하면, 해당 컨트롤러 하위 모든 메서드가 공통으로 주소를 적용 받는다<br>
			문자열만 작성하면 value를 지정하는것이 된다</li>
		<li>@GetMapping @RequestMapping(value="", method=RequestMethod.GET) 과 같다 (스프링 4.1.0이상에서만 가능)<br></li>
		<li>@PostMapping @RequestMaiing(value="", method=RequestMethod.POST) 과 같다(스프링 4.1.0이상에서만 가능)<br></li>
		<li>@select 마이바티스 함수에서 select쿼리를 전달 받아 executeQuery()를 수행하고 결과를 반환한다</li>
		<li>@insert 마이바티스 함수에서 insert쿼리를 전달받아 executeUpdate()를 수행하고, 정수를 반환한다</li>
	</ul>
</div>
<div>
	<ul>
		<li>컨트롤러 함수 매개변수 타입</li>
		<li>primitive 파라미터를 받을수 있다</li>
		<li>String 파라미터를 문자열 형식으로 받는다</li>
		<li>HashMap 파라미터 이름을 key 값을 value로 받는다</li>
		<li>DTO 파라미터를 dto객체의 필드에 넣어서 받는다</li>
	</ul>
</div>
<div>
	<ul>
		<li>HttpServletRequest jsp내장객체 request를 참조한다</li>
		<li>HttpServletResponse jsp내장객체 response를 참조한다</li>
		<li>HttpSession jsp내장 객체 session을 참조한다</li>
		<li>Model request.setAttribute를 대신하기 위한 객체</li>
	</ul>
</div>
<div>
	<ul>
		<li>컨트롤러 함수 주요 반환형</li>
		<li>String 컨트롤러 함수가 수행된 이후, 화면을 보여줄 viewName을 지정한다</li>
		<li>void 컨트롤러 함수가 수행된 이후, 요청주소 문자열을 viewName으로 활용한다</li>
		<li>ModelAndView jsp의 이름 viewName과 attribute르 ㄹ하나의 객체로 묶어서 반환한다</li>
	</ul>
</div>

</body>
</html>