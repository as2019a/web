package com.inc.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebFilter(value = {"/mypage", "/signout"})
public class AuthFilter implements Filter {

    
	public void destroy() {
		
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = 
				(HttpServletRequest)request;
		HttpServletResponse httpResponse = 
				(HttpServletResponse)response;
		if(httpRequest.getSession().getAttribute("user") != null) {
			chain.doFilter(request, response);
		}else {
			httpResponse.sendRedirect("/signin");
		}
		
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
