package com.inc.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/course")
public class CourseServlet extends HttpServlet {
       
   
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("courseList", 
				new String[] {"Web Course", "IOT Course", "Android Course", "Bigdata Course"});
		request.getRequestDispatcher("/WEB-INF/views/course.jsp").forward(request, response);
	}

}
