package com.inc.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.inc.dao.BookDao;
import com.inc.domain.Book;

@WebServlet("/book/list")
public class BookListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String type = request.getParameter("type");
		String word = request.getParameter("word");
		List<Book> bookList = null;
		if(type == null) {
			bookList = BookDao.getInstance().selectList();
		}else {
			bookList = 
				BookDao.getInstance().selectList(type, word);
		}
		
		request.setAttribute("bookList", bookList);
		request.getRequestDispatcher("/views/book/list.jsp")
		       .forward(request, response);
	}

}






