package com.inc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.inc.dao.BookDao;
import com.inc.domain.Book;


@WebServlet("/book/update")
public class BookUpdateServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int id = Integer.parseInt(
					request.getParameter("id"));
		String msg = request.getParameter("msg");
		String writer = request.getParameter("writer");
		
		if(writer == null) {
			Book book = BookDao.getInstance().selectOne(id);
			request.setAttribute("book", book);
			request.getRequestDispatcher(
	 "/views/book/update.jsp").forward(request, response);;
		}else {
			Book book = new Book();
			book.setId(id);
			book.setWriter(writer);
			book.setMsg(msg);
			book.setIp(request.getRemoteAddr());
			BookDao.getInstance().update(book);
			response.sendRedirect("/book/list");
		}
		
		
	}

}
