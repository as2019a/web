package com.inc.user.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.inc.dao.UserDao;
import com.inc.domain.User;

@WebServlet("/user/signout")
public class SignOutServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession().setAttribute("user", null);
		String msg = "로그아웃 되셨습니다.";
		response.setContentType("text/html; charset=UTF-8");
		response.getWriter().println("<script>");
		response.getWriter().println("alert('"+msg+"');");
		response.getWriter().println("location.href='/product/list';");
		response.getWriter().println("</script>");
	}

}
