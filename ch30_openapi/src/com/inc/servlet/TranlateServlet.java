package com.inc.servlet;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/translate")
public class TranlateServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String source = request.getParameter("source");
		String target = request.getParameter("target");
		String text = request.getParameter("text");
		text = URLEncoder.encode(text, "UTF-8");
		
		String clientId = "3wMXHuf60bTZtkF2UZvN";
		String clientSecret = "iR5yEUW71x";
		
		URL url = new URL("https://openapi.naver.com/v1/papago/n2mt");
		HttpURLConnection conn = 
				(HttpURLConnection)url.openConnection();
		conn.setRequestMethod("POST");
		conn.setRequestProperty("X-Naver-Client-Id", 
				                clientId);
		conn.setRequestProperty("X-Naver-Client-Secret", 
								clientSecret);
		String params = String.format(
				"source=%s&target=%s&text=%s",
					source, target, text);
		conn.setAllowUserInteraction(true);
		DataOutputStream ds = 
				new DataOutputStream(
						conn.getOutputStream());
		ds.writeBytes(params);
		ds.flush();
		ds.close();
		
		String line;
		StringBuffer sb = new StringBuffer();
		BufferedReader br = 
				new BufferedReader(
						new InputStreamReader(
								conn.getInputStream()));
		while((line=br.readLine()) != null) {
			sb.append(line);
		}
		br.close();
		response.setContentType(
				"application/json; charset=utf-8");
		response.getWriter().print(sb.toString());
		
	}
}
