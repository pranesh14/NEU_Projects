package com.fifa.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.fifa.entity.UsersTable;

public class TransferInterceptors implements HandlerInterceptor {

	String errorPage;

	public String getErrorPage() {
		return errorPage;
	}

	public void setErrorPage(String errorPage) {
		this.errorPage = errorPage;
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub

		HttpSession session = (HttpSession) request.getSession();

		UsersTable u = (UsersTable) session.getAttribute("user");
		String uri = request.getRequestURI();		

		if (u == null) {
			session.setAttribute("errorMessage", "You were logged out!");
			System.out.println("No user");
			response.sendRedirect(request.getContextPath());
			return false;
		}

		if (uri.contains("org")) {
			if (u.getRole().equalsIgnoreCase("ORGANIZATION_ADMIN")) {
				return true;
			}
		} else if (uri.contains("team")) {
			if (!u.getRole().equalsIgnoreCase("ORGANIZATION_ADMIN")) {
				return true;
			}
		} else if (uri.contains("player/sell")) {
			return true;
		} else if (uri.contains("ajax")) {
			return true;
		}

		session.setAttribute("errorMessage", "You were logged out!");
		System.out.println("Invalid user");
		response.sendRedirect(request.getContextPath());
		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub

	}

}
