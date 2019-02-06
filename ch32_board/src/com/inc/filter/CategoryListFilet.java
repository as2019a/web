package com.inc.filter;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import com.inc.dao.ProductDao;


@WebFilter(value= {"/product/list", "/mypage", "/manage", "/board/list", "/board/view"})
public class CategoryListFilet implements Filter {

    
	public void destroy() {
		
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		List<String> categoryList = ProductDao.getInstance().selectCategoryList();
		request.setAttribute("categoryList", categoryList);
		chain.doFilter(request, response);
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
