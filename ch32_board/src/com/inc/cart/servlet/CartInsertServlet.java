package com.inc.cart.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.inc.dao.CartDao;
import com.inc.domain.Cart;
import com.inc.domain.User;


@WebServlet("/cart/insert")
public class CartInsertServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String model = request.getParameter("model");
		User user = (User)request.getSession().getAttribute("user");
		String id = user.getId();
		
		Cart cart = new Cart();
		cart.setUsers_id(id);
		cart.setProduct_model(model);
		CartDao.getInstance().insert(cart);
		
		response.setContentType("text/html; charset=utf-8");
		response.getWriter().println("<script>");
		response.getWriter().println("var check = confirm('장바구니로 이동하시겠습니까?');");
		response.getWriter().println("if(check){location.href='/mypage'}");
		response.getWriter().println("else{location.href='/product/list'}");
		response.getWriter().println("</script>");
	}

}
