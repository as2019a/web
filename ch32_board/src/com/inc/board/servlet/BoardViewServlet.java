package com.inc.board.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.inc.dao.BoardDao;
import com.inc.domain.Board;


@WebServlet("/board/view")
public class BoardViewServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		BoardDao.getInstance().hitUp(id);
		Board board = BoardDao.getInstance().selectOne(id);
		request.setAttribute("board", board);
		request.getRequestDispatcher("/WEB-INF/views/board/view.jsp").forward(request, response);
	}

}
