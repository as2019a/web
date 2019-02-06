package com.inc.manage.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.inc.connector.MybatisConnector;
import com.inc.dao.ProductDao;


@WebServlet("/manage/category/update")
public class CategoryUpdateServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String category = request.getParameter("category");
		String newCategory = request.getParameter("new");
		ProductDao.getInstance().updateCategory(category, newCategory);
		
		response.sendRedirect("/manage");
		
	}

}
