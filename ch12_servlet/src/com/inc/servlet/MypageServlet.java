package com.inc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MypageServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//클라이언트로 부터 데이터를 받아온다.
		String id = request.getParameter("id");
		//데이터를 가지고 HTML코드를 생성한다.
		String html = "<h1>My page</h1>";
		html += "<p>아이디 : " + id + "</p>";
		//브라우저한테 만든 HTML을 보내준다.
		response.setContentType("text/html; charset=utf-8");
		response.getWriter().print(html);
	}
	
}
