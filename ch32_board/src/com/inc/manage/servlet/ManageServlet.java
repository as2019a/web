package com.inc.manage.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.inc.dao.ProductDao;

@WebServlet("/manage")
public class ManageServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("categoryList",ProductDao.getInstance().selectCategoryList());
		request.getRequestDispatcher("/WEB-INF/views/manage/view.jsp").forward(request, response);
	}

}
