package com.inc.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.inc.dao.CountryDao;
import com.inc.domain.Country;

@WebServlet("/country/list")
public class CountryListServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String[] idList = request.getParameterValues("id");
		for(String id : idList) {
			System.out.println(id);
		}
		List<Country> countryList = 
				CountryDao.getInstance().selectList(name, idList);
		request.setAttribute("countryList", countryList);
		request.getRequestDispatcher(
				"/WEB-INF/views/country/list.jsp")
				.forward(request, response);
		
	}

}
