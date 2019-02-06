package com.inc.user.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.inc.dao.UserDao;
import com.inc.domain.User;

@WebServlet("/user/signin")
public class SignInServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		User checkUser = new User();
		checkUser.setId(id);
		checkUser.setPassword(password);
		User user = UserDao.getInstance()
						   .selectOne(checkUser);
		String msg;
		if(user == null) {
			msg = "아이디 또는 비밀번호가 다릅니다.";
		}else {
			msg = "로그인에 성공했습니다.";
			request.getSession().setAttribute("user",user);
		}
		response.setContentType("text/html; charset=UTF-8");
		response.getWriter().println("<script>");
		response.getWriter().println("alert('"+msg+"');");
		response.getWriter().println("location.href='/product/list';");
		response.getWriter().println("</script>");
	}

}
