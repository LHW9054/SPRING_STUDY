package com.itbank.intercepter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

// 스흐링4 에서는 extends HandlerInterceptorAdapter
// 스프링5 에서는 implements HandlerInterceptor
// HandlerInterceptor는 인터페이스 이지만, 내부 함수가 default 키워드를 가지기 때문에 함수 바디가 완성 되어 있다
// 따라서, 미구현 메서드(추상 메서드)가 아니므로, 의무적으로 오버라이딩 하지는 않는다.
public class LoginIntercepter implements HandlerInterceptor{
	
	@Override	// preHandle : 요청이 컨트롤러에 도달하기 '전에' 작동하는 함수
				// 아직 컨트롤러에 요청이 도달하기 전이므로, 이후 작업을 계속 할지 말지에 대해 반환값을 전달할수 있다
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("1. preHandle");
		System.out.println("handler : " + handler);
		
		// 세션에 회원정보가 없으면 로그인 페이지로 강제로 이동시키는 코드
		HttpSession session = request.getSession();	// 없으면 새로운 session을 생성해준다
													// request.getSession(false)이면 없을때 null변환
		
		Object login = session.getAttribute("login");
		
		if(login==null) {
			System.out.println("로그인된 사용자가 없음");
			String cpath = request.getContextPath();
			response.sendRedirect(cpath + "/login");
			return false;		// 원래 예정되었던 컨트롤러의 함수로 진입하지 않고, 새로 만들어준 응답을 활용한다
								// (continue : false)
		}
		
		return true;			// 원래 예정되었던 컨트롤러의 함수로 그대로 연결한다 (continue:true)
	}
	
	@Override	// postHandle : 요청이 컨트롤러에 도달한 이후, jsp로 포워드 되기 전에 작동하는 함수
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("2. postHandle");
	}
	
	@Override	// afterCompletion : jsp로 포워딩 된후 응답이 서버에서 클라이언트에게 출발한 이후 작동하는 함수
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
		System.out.println("3. afterHandle");
		
	}

}
