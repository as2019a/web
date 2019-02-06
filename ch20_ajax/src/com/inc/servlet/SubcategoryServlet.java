package com.inc.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.inc.dao.CategoryDao;

@WebServlet("/subcategory/list")
public class SubcategoryServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String category = 
				request.getParameter("category");
		List<String> subList = 
			CategoryDao.getInstance()
			           .selectSubList(category);
		StringBuffer sb = new StringBuffer();
		sb.append("[");
		for(String sub : subList) {
			sb.append("\""+sub+"\",");
		}
		String result = sb.toString();
		result = result.substring(0, result.length()-1);
		result += "]";
		response.getWriter().print(result);
		//["java","javascript"]
	}

}
