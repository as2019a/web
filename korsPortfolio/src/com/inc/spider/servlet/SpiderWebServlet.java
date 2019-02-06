package com.inc.spider.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.inc.dao.spiderDao;
import com.inc.domain.spiderweb;


@WebServlet("/spiderweb")
public class SpiderWebServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String category = request.getParameter("category");
		String order = request.getParameter("order");
		String base = request.getParameter("base");
		String type = request.getParameter("type");
		String text = request.getParameter("text");
		
		Map<String, String> map = new HashMap<>();
		map.put("category", category);
		map.put("order", order);
		map.put("base", base);
		map.put("type", type);
		map.put("text", text);
		
		List<String> categoryList = spiderDao.getInstance().();
		request.setAttribute("spiderList", spiderList);
		
		request.getRequestDispatcher("/WEB-INF/views/spider/web.jsp").forward(request, response);
		
	}

}
