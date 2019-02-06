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

@WebServlet("/upload")
public class UploadServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher(
				"/WEB-INF/views/upload.jsp")
			   .forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//저장위치
		String path = 
				request.getServletContext()
				       .getRealPath("/upload/");
		//Multipart객체를 생성하면서 동시에 파일이 저장된다
		MultipartRequest mr = 
				new MultipartRequest(
						request, 
						path, //저장경로
						10*1024*1024, //사이즈
						"utf-8", //인코딩
						//파일이름 중복시 파일이름변경정책
						new DefaultFileRenamePolicy());
		//후처리
		String title = mr.getParameter("title");
		File file = mr.getFile("photo");
		String filename = file.getName();
		System.out.println(filename);
		
		request.setAttribute("title", title);
		request.setAttribute("filename", filename);
		
		request.getRequestDispatcher(
				"/WEB-INF/views/result.jsp")
				.forward(request, response);
		
	}

}