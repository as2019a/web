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
import javax.servlet.http.HttpSession;

import com.inc.domain.User;


@WebFilter(value={"/manage/*", "/mypage/*", "/cart/*", "/board/insert", "/board/delete", "/board/update",
					"/board/view", "/reply/*"})
public class AuthorityFilter implements Filter {


    public AuthorityFilter() {
        
    }


	public void destroy() {
		
	}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest 
				= (HttpServletRequest)request;
		HttpServletResponse httpResponse
				= (HttpServletResponse)response;
		HttpSession session = httpRequest.getSession();
		User user = (User)session.getAttribute("user");
		if(user == null) {
			httpResponse.setContentType(
					"text/html; charset=utf-8");
			httpResponse.getWriter().print("<script>");
			httpResponse.getWriter().print(
						"alert('로그인 후 이용 가능합니다');");
			httpResponse.getWriter().print(
						"location.href='/product/list';</script>");
			return;
		}else if(httpRequest.getRequestURI().indexOf("/manage") != -1
				 && !user.getId().equals("admin")) {
			httpResponse.setContentType(
					"text/html; charset=utf-8");
			httpResponse.getWriter().print("<script>");
			httpResponse.getWriter().print(
						"alert('관리자만 접근 가능합니다');");
			httpResponse.getWriter().print(
						"location.href='/product/list';</script>");
			return;
		}
		
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}