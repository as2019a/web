package com.inc.board.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.inc.dao.BoardDao;
import com.inc.domain.Board;
import com.inc.domain.User;


@WebServlet("/board/delete")
public class BoardDeleteServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		User user = (User)request.getSession().getAttribute("user");
		Board board = BoardDao.getInstance().selectOne(id);
		response.setContentType("text/html; charset=utf-8");
		if(user.getId().equals(board.getUsers_id())
				|| user.getId().equals("admin")) {
			BoardDao.getInstance().delete(id);
			//response.sendRedirect("/board/list");
			response.getWriter().println("<script>");
			response.getWriter().println("alert('게시물이 삭제가 완료되었습니다.');");
			response.getWriter().println("location.href='/board/list'");
			response.getWriter().println("</script>");
		}else {
			response.getWriter().println("<script>");
			response.getWriter().println("alert('잘못된 요청입니다.');");
			response.getWriter().println("location.href='/board/list'");
			response.getWriter().println("</script>");
		}
		
		
	}

}
