package com.inc.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/signin")
public class SigninServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/signin.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String saveId = request.getParameter("save-id");
		String savePassword = request.getParameter("save-password");
		//System.out.println(saveId);
		//System.out.println(savePassword);
		
		if(saveId != null) {
			//쿠키 생성
			Cookie idCookie = new Cookie("id", id);
			//쿠키 수명 설정
			idCookie.setMaxAge(60*60); //second
			response.addCookie(idCookie);
		}else {
			//쿠키삭제
			Cookie idCookie = new Cookie("id","");
			idCookie.setMaxAge(0);
			response.addCookie(idCookie);
		}
		if(savePassword != null) {
			//쿠키 생성
			Cookie passwordCookie = new Cookie("password", password);
			//쿠키 수명 설정
			passwordCookie.setMaxAge(60*60); //second
			response.addCookie(passwordCookie);
		}else {
			//쿠키삭제
			Cookie passwordCookie = new Cookie("password","");
			passwordCookie.setMaxAge(0);
			response.addCookie(passwordCookie);
		}
		response.setContentType("text/html; charset=utf-8");
		response.getWriter().print("<script>alert('로그인성공');location='/signin'</script>");
	}

}
