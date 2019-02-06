package com.inc.user.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.inc.dao.CartDao;
import com.inc.domain.Cart;
import com.inc.domain.User;


@WebServlet("/mypage")
public class MypageServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = (User)request.getSession().getAttribute("user");
		List<Cart> cartList = CartDao.getInstance().selectList(user.getId());
		request.setAttribute("cartList", cartList);
		
		int total = 0;
		
		for(Cart cart : cartList) {
			total += cart.getProduct().getPrice() * (1 - cart.getProduct().getDiscount() * cart.getCount());
		}
		
		request.setAttribute("total", total);
		
		request.getRequestDispatcher("/WEB-INF/views/user/mypage.jsp").forward(request, response);
	}

}
