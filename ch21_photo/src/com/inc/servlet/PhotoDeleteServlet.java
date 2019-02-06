package com.inc.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.inc.dao.photoDao;


@WebServlet("/photo/delete")
public class PhotoDeleteServlet extends HttpServlet {
	
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String password = request.getParameter("password");
		int result = photoDao.getInstance().delete(id, password);
		response.setContentType("text/plan; charset=utf8");
		if(result == 0) {
			response.getWriter().print("비밀번호가 다릅니다.");
		}else {
			response.getWriter().print("삭제에 성공했습니다.");
		}
		
	}

}
