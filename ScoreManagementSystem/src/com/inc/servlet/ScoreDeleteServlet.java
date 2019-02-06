package com.inc.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.inc.dao.ScoreDao;

@WebServlet("/score/delete") //삭제경로
public class ScoreDeleteServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//getParameter로 "id"를 받아서 parseInt로 변환(String(문자) -> int(숫자)) id가 변환된다.
		//int(변수종류) id(변수이름)
		int id = Integer.parseInt(request.getParameter("id"));
		//받은 id는 ScoreDao로 가서 delete함수를 계산 작동한다.(id는 받아온다.) 
		ScoreDao.getInstance().delete(id);
		//이후 삭제하고 나서 화면을 sendRedirect : "/score/list"를 보여준다.(Dao를 거친다.)
		response.sendRedirect("/score/list");
		//response = 응답
	}

}
