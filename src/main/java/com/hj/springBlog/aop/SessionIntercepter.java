package com.hj.springBlog.aop;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class SessionIntercepter extends HandlerInterceptorAdapter{
//어댑터 패턴
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session=request.getSession();
		if(session.getAttribute("principal")==null) {
			System.out.println("인증 실패");
			response.sendRedirect("/user/login");
			return false;//컨트롤러의 함수가 실행이 안됨
		}
		System.out.println("인증 성공");
		return true;
	}
}
