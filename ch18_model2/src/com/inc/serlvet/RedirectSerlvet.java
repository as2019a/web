package com.inc.serlvet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/redirect")
public class RedirectSerlvet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, 
						HttpServletResponse response) 
								throws ServletException, IOException {
		int num1 = Integer.parseInt(request.getParameter("num1"));
		int num2 = Integer.parseInt(request.getParameter("num2"));
		int result = num1 + num2;
		//JSP에게 전달할 데이터를 request객체에 저장
		request.setAttribute("result", result);
		
		//redirect(전화번호로 응답)
		response.sendRedirect("/view.jsp");
	}

}
