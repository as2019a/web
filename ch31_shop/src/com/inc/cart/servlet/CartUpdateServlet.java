package com.inc.cart.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.inc.dao.CartDao;
import com.inc.domain.User;

@WebServlet("/cart/update")
public class CartUpdateServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(
				request.getParameter("id"));
		int count = Integer.parseInt(
					request.getParameter("count"));
		
		CartDao.getInstance().update(id, count);
		
		response.sendRedirect("/mypage");
		
	}

}






