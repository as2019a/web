package com.inc.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.inc.dao.ScoreDao;
import com.inc.domain.Score;


@WebServlet("/score/update")
public class ScoreUpdateServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int id = Integer.parseInt(request.getParameter("id"));
		//String writer = request.getParameter("writer");
		
		/*if(writer == null) {
			Score score = ScoreDao.getInstance().selectOne(id);
			request.setAttribute("score", score);
			request.getRequestDispatcher("/WEB-INF/score/update.jsp")
			.forward(request, response);*/
		/*}else {
			Score score = new Score();
			score.setId(id);
			score.getName();
			score.getKor();
			score.getEng();
			score.getMath();
			ScoreDao.getInstance().update(score);
			response.sendRedirect("/score/list");
		}*/
	}

}
