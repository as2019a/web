package com.inc.gallery.servlet;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.inc.dao.ImageDao;
import com.inc.domain.Image;


@WebServlet("/image/delete")
public class ImageDeleteServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String collection = request.getParameter("collection");
		
		ImageDao.getInstance().delete(collection);
		response.sendRedirect("/image");
		
		
		
	}

}
