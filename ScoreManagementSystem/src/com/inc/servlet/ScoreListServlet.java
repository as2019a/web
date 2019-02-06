package com.inc.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.inc.dao.ScoreDao;
import com.inc.domain.Score;


@WebServlet("/score/list")
public class ScoreListServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//ScoreDao로 부터 selectList함수를 호출하여 scoreList를 받아온다.
		List<Score> scoreList = ScoreDao.getInstance().selectList();
		//scoreList를 request.setAttribute에 저장하여 list.jsp에 뿌려준다.
		request.setAttribute("scoreList", scoreList);
		//request(요청)을 list.jsp에게 forward(전달) 
		request.getRequestDispatcher("/WEB-INF/score/list.jsp").forward(request, response);
	}

}
