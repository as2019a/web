package com.inc.board.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.annotations.Update;

import com.inc.dao.BoardDao;
import com.inc.domain.Board;
import com.inc.domain.User;


@WebServlet("/board/update")
public class BoardUpdateServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		User user = (User)request.getSession().getAttribute("user");
		Board board = BoardDao.getInstance().selectOne(id);
		response.setContentType("text/html; charset=utf-8");
		if(user.getId().equals(board.getUsers_id())) {
			//수정페이지로 포워드
			request.setAttribute("board", board);
			request.getRequestDispatcher("/WEB-INF/views/board/update.jsp").forward(request, response);
		}else {
			response.getWriter().println("<script>");
			response.getWriter().println("alert('잘못된 요청입니다.');");
			response.getWriter().println("location.href='/board/list'");
			response.getWriter().println("</script>");
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		User user = (User)request.getSession().getAttribute("user");
		Board board = BoardDao.getInstance().selectOne(id);
		response.setContentType("text/html; charset=utf-8");
		if(user.getId().equals(board.getUsers_id())) {
			board.setTitle(title);
			board.setContent(content);
			BoardDao.getInstance().update(board);
			response.sendRedirect("/board/view?id="+id);
		}else {
			response.getWriter().println("<script>");
			response.getWriter().println("alert('잘못된 요청입니다.');");
			response.getWriter().println("location.href='/board/list'");
			response.getWriter().println("</script>");
		}
		
	}

}
