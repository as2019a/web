package com.inc.manage.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.inc.dao.ProductDao;

@WebServlet("/manage/product/dualcheck")
public class ProductDualcheckServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.모델명을 파라미터로부터 받는다.
		String model = request.getParameter("model");
		
		//2.DAO에게 모델명을 전달해 주면서 갯수를 받아온다
		int count = ProductDao.getInstance().productCount(model);
		
		//3.갯수에 따라 적절한 응답
		response.setContentType("text/plain; charset=utf-8");
		if(count != 0) {
			//중복
			response.getWriter().print("duplicated");
		}else {
			//중복 x
			response.getWriter().print("notduplicated");
		}
		
	}
	
}
