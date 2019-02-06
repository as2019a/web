package com.inc.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.inc.dao.photoDao;
import com.inc.domain.Photo;


@WebServlet("/photo/list")
public class PhotoListServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Photo> photoList = photoDao.getInstance().setlectList();
		request.setAttribute("photoList", photoList);
		request.getRequestDispatcher("/WEB-INF/views/photo/list.jsp").forward(request, response);
	}

}
