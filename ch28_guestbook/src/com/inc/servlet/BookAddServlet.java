package com.inc.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.inc.dao.BookDao;
import com.inc.domain.Book;

@WebServlet("/book/add")
public class BookAddServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher(
				"/views/book/add.jsp")
		        .forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String writer = request.getParameter("writer");
		String password = request.getParameter("password");
		String msg = request.getParameter("msg");
		String ip = request.getRemoteAddr();
		
		Book book = new Book();
		book.setWriter(writer);
		book.setPassword(password);
		book.setMsg(msg);
		book.setIp(ip);
		
		BookDao.getInstance().insert(book);
		
		response.sendRedirect("/book/list");
	}

}








