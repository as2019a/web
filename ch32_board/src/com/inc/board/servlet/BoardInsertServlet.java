package com.inc.board.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.inc.dao.BoardDao;
import com.inc.domain.Board;
import com.inc.domain.User;


@WebServlet("/board/insert")
public class BoardInsertServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/board/insert.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String users_id = ((User)request.getSession().getAttribute("user")).getId();
		
		String ip = request.getRemoteAddr();
		
		Board board = new Board();
		board.setTitle(title);
		board.setContent(content);
		board.setUsers_id(users_id);
		board.setIp(ip);
		BoardDao.getInstance().insert(board);
		response.sendRedirect("/board/list");
	}

}
