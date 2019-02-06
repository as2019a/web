package com.inc.gallery.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.inc.dao.ImageDao;
import com.inc.domain.Image;


@WebServlet("/image")
public class ImageListServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String collection = request.getParameter("collection");
		String thumbnails = request.getParameter("thumbnails");
		String display_sitename = request.getParameter("display_sitename");
		String contents = request.getParameter("contents");
		List<Image> imageList = null;
		if(thumbnails == null) {
			imageList = ImageDao.getInstance().selectList();
		}else {
			imageList = 
				ImageDao.getInstance().selectList(collection, thumbnails, display_sitename, contents);
		}
		System.out.println(imageList.size());
		
		request.setAttribute("imageList", imageList);
		request.getRequestDispatcher("/gallery.jsp")
		       .forward(request, response);
	}

}
