package com.chat.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component("loginInterceptor")
public class InterCeptor extends HandlerInterceptorAdapter{
	/**
	 * 컨트롤러 호출 되기전에 채가는 메소드
	 */
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler){
		try {
			//loginInfo 세션값이 null일경우
			if(request.getSession().getAttribute("loginInfo") == null ){
				//로그인 페이지로 redirect
				response.sendRedirect("../");
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		//null이 아니면 정상적으로 컨트롤러 호출
		return true;
	}
}