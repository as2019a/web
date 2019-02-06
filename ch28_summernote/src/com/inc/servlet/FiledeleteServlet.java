package com.inc.servlet;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;


@WebServlet("/filedelete")
public class FiledeleteServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String src = request.getParameter("src");
		
		String path = request.getServletContext().getRealPath(src);
		File target = new File(path);
		if(target.exists()) {
			target.delete();
			response.getWriter().print("성공");
		}else {
			response.getWriter().print("실패");
		}
		
	}

}
