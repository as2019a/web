package com.inc.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.inc.dao.BookDao;


@WebServlet("/checkpassword")
public class BookCheckPasswordServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(
					request.getParameter("id"));
		String password = request.getParameter("password");
		
		String realPassword = 
				BookDao.getInstance().selectOne(id)
									 .getPassword();
		if(password.equals(realPassword)) {
			response.getWriter().print("correct");
		}else {
			response.getWriter().print("incorrect");
		}
	}

}
