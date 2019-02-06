package com.inc.reply.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.inc.dao.ReplyDao;
import com.inc.domain.Reply;
import com.inc.domain.User;


@WebServlet("/reply/rereply")
public class RereplyInsertServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int board_id = Integer.parseInt(request.getParameter("board_id"));
		int ref = Integer.parseInt(request.getParameter("ref"));
		String content = request.getParameter("content");
		User user = (User)request.getSession().getAttribute("user");
		
		Reply reply = new Reply();
		reply.setBoard_id(board_id);
		reply.setRef(ref);
		reply.setContent(content);
		reply.setUsers_id(user.getId());
		
		ReplyDao.getInstance().insertRereply(reply);
		
		response.sendRedirect("/board/view?id="+board_id);
		
	}

}
