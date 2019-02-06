package com.inc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.inc.dao.UserDao;
import com.inc.domain.User;


@WebServlet("/signin")
public class SigninServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher(
				"/WEB-INF/views/signin.jsp")
				.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String password = 
					request.getParameter("password");
		
		User user = UserDao.getInstance().selectOne(id);
		
		String msg = "";
		String path = "/main";
		if(user == null) {
			msg = "존재하지 않는 아이디 입니다";
			path = "/signin";
		}else if(!user.getPassword().equals(password)) {
			msg = "비밀번호가 일치하지 않습니다";
			path = "/signin";
		}else {
			msg = "로그인에 성공했습니다";
			request.getSession().setAttribute("user", user);
		}
		
		response.setContentType("text/html; charset=utf-8");
		response.getWriter().print(
				"<script>alert('"+msg+"');"+
				"location.href='"+path+"'</script>");		
	}

}






