package com.inc.board.servlet;

import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.inc.dao.BoardDao;
import com.inc.domain.Board;
import com.inc.util.Pager;


@WebServlet("/board/list")
public class BoardListServlet extends HttpServlet {
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. Board 도메인(클래스) 선언
		//2. BoardDao로 부터 게시물의 리스트를 받아온다.
		//3. request에 저장
		//4. /WEB-INF/views/board/list.jsp에게 포워드
		
		int page = 1;
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		
		//전체 게시물의 갯수
		int total = BoardDao.getInstance().getTotalCount();
		
		String pageHTML = Pager.paging(page, total);
		request.setAttribute("pageHTML", pageHTML);
		
		//시작번호1 - 1, 2 - 6
		int start = (page - 1) * Pager.BOARDS + 1;
		int end = start + Pager.BOARDS - 1;
		
		Map<String, Integer> map = new HashMap<>();
		map.put("start", start);
		map.put("end", end);
		
		List<Board> boardList = BoardDao.getInstance().selectboardList(map);
		Calendar today = Calendar.getInstance();
		int year = today.get(Calendar.YEAR);
		int month = today.get(Calendar.MONTH) + 1;
		int day = today.get(Calendar.DATE);
		String todayStr = year+""+month+"-"+day;
		//System.out.println(todayStr);
		for(Board board : boardList) {
			String date = board.getRegdate()
					   .substring(0, board.getRegdate()
							   			  .indexOf(" "));
			String time = board.getRegdate()
					   .substring(board.getRegdate()
							   	  .indexOf(" ")+1);
			if(todayStr.equals(date)) {
				board.setRegdate(date);
			}else{
				board.setRegdate(time);
			}
		}
		
		request.setAttribute("boardList", boardList);
		request.getRequestDispatcher("/WEB-INF/views/board/list.jsp").forward(request, response);
	}

}
