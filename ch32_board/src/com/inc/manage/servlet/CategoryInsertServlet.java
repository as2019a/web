package com.inc.manage.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.inc.dao.ProductDao;

@WebServlet("/manage/category/insert")
public class CategoryInsertServlet extends HttpServlet {
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String category = request.getParameter("category");
		int count = ProductDao.getInstance().categoryCount(category);
		response.setContentType("text/html; charset=utf-8");
		if(count == 1) {
			response.getWriter().println("<script>");
			response.getWriter().println("alert('이미 존재하는 카테고리 입니다.');");
			response.getWriter().println("location.href='/manage'");
			response.getWriter().println("</script>");
		}else {
			ProductDao.getInstance().categoryInsert(category);
			response.getWriter().println("<script>");
			response.getWriter().println("alert('등록에 성공했습니다.');");
			response.getWriter().println("location.href='/manage'");
			response.getWriter().println("</script>");
		}
	}

}
