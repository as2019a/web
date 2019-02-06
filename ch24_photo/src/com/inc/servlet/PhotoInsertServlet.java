package com.inc.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.inc.dao.PhotoDao;
import com.inc.domain.Photo;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;


@WebServlet("/insert")
public class PhotoInsertServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/photo/insert.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getServletContext().getRealPath("/upload/");
		MultipartRequest mr = new MultipartRequest(request, path, 10*1024*1024, "utf-8", new DefaultFileRenamePolicy());
		String title = mr.getParameter("title");
		String password = mr.getParameter("password");
		String filename = mr.getFile("photo").getName(); 
		Photo photo = new Photo();
		photo.setTitle(title);
		photo.setPassword(password);
		photo.setFilename(filename);
		
		PhotoDao.getInstance().insert(photo);
		
		response.sendRedirect("/photo/list");
	}

}
