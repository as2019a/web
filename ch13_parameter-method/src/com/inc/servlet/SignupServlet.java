package com.inc.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/signup")
public class SignupServlet extends HttpServlet {
	
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//공통적인 작업
		response.setContentType("text/html; charset=utf-8");
		System.out.println(request.getMethod());
		if(request.getMethod().equals("GET")) {
			doGet(request, response);
		}else if(request.getMethod().equals("POST")) {
			doPost(request, response);
		}
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//회원가입 페이지를 보여주기
		StringBuffer sb = new StringBuffer();
		sb.append("<!Doctype html>");
		sb.append("<html>");
			sb.append("<head>");
				sb.append("<meta charset='UTF-8'>");
				sb.append("<title>signup</title>");
			sb.append("</head>");
			sb.append("<body>");
				sb.append("<form action='/signup' method='post'>");
					sb.append("아이디<input type='text' name='id'><br>");
					sb.append("비밀번호<input type='password' name='password'><br>");
					sb.append("운동<input type='checkbox' name='hobby' value='sports'>");
					sb.append("영화<input type='checkbox' name='hobby' value='movie'><br>");
					sb.append("<button type='submit'>회원가입</button>");
				sb.append("</form>");
			sb.append("</body>");
		sb.append("</html>");
		response.getWriter().print(sb.toString());
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//회원가입 시켜주고 결과화면 보여주기
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String[] hobbyArray = request.getParameterValues("hobby");
		System.out.printf("%s, %s, %s, %s", id, password, hobbyArray[0], hobbyArray[1]);
		response.getWriter().print("<h1>회원가입을 축하드립니다.</h1><a href='/main'>메인으로</a>");
	}

}
