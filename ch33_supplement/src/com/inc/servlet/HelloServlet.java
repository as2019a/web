package com.inc.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		//1.직접응답
		/*response.setContentType("text/html; charset=utf-8");
		response.getWriter().println("<h1>"+name+"님 안녕하세요</h1>");*/
		//2.JSP에게 Forward
		/*request.setAttribute("name", name);
		request.getRequestDispatcher("/WEB-INF/views/hello.jsp").forward(request, response);*/
		//3.주소를 응답
		response.sendRedirect("/bye");
		//response.getWriter().print("<script>location.href='/bye';</script>");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
