package com.inc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.inc.dao.UserDao;
import com.inc.domain.User;


@WebServlet("/dualcheck")
public class DualCheckServlet extends HttpServlet {
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		User user = UserDao.getInstance().selectOne(id);
		if(user == null) {
			response.getWriter().print("notexist");
		}else {
			response.getWriter().print("exist");
		}
		
	}

}






