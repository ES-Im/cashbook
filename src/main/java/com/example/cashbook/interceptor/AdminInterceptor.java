package com.example.cashbook.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Component
public class AdminInterceptor implements HandlerInterceptor{
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
	
		log.debug(request.getRequestURL().toString() + "Admin session exist");
		
		HttpSession session = request.getSession();
		if(session.getAttribute("adminId") != null) {
			response.sendRedirect(request.getContextPath() + "/admin/home");
			return false;
		}
		
		return HandlerInterceptor.super.preHandle(request, response, handler);
	}
	

}