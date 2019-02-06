package com.inc.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;


@WebServlet("/fileupload")
public class FileuploadServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getServletContext().getRealPath("/upload/board/");
		MultipartRequest mr = new MultipartRequest(request, path, 1024*1024*5, "utf-8", 
													new DefaultFileRenamePolicy());
		String filename = mr.getFile("upload").getName();
		response.setContentType("application/json");
		response.getWriter().print(
				"{\"url\":\"/upload/board/"+filename+"\"}"
		);
	}

}
