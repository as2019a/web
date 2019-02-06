package com.inc.http.servlet;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/getimage")
public class HttpServlet extends javax.servlet.http.HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("image/png");

        ServletContext sc = getServletContext();
        InputStream is = sc.getResourceAsStream("images/mushroom.png");

        BufferedImage bi = ImageIO.read(is);
        OutputStream os = response.getOutputStream();
        ImageIO.write(bi, "png", os);
	}

}
