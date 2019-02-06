package com.inc.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.inc.dao.ScoreDao;
import com.inc.domain.Score;


@WebServlet("/score/add")
public class ScoreAddServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/score/add.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		int kor = request.getContentLength();
		int eng = request.getContentLength(); 
		int math = request.getContentLength();
		int total = request.getContentLength();
		int average = request.getContentLength();
		
		Score score = new Score();
		score.setName(name);
		score.setKor(kor);
		score.setEng(eng);
		score.setMath(math);
		score.setTotal(total);
		score.setAverage(average);
		
		ScoreDao.getInstance().insert(score);
		response.sendRedirect("score/list");
		
		}
	}
