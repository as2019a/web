package com.inc.cart.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.inc.dao.CartDao;
import com.inc.domain.Cart;
import com.inc.domain.User;


@WebServlet("/cart/delete")
public class CartDeleteServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		User user = (User)request.getSession().getAttribute("user");
		Map<String, Object> map = new HashMap<>();
		int result = CartDao.getInstance().delete(id, user.getId());
		
		String msg = "";
		
		if(result == 0) {
			msg = "잘못된 요청입니다";
		}else {
			msg = "삭제되었습니다";
		}
		
		response.setContentType("text/html; charset=utf-8");
		response.getWriter().println("<script>");
		response.getWriter().println("alert('"+msg+"');");
		response.getWriter().println("if(check){location.href='/mypage'}");
		response.getWriter().println("</script>");
	}

}
