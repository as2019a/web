package com.inc.servlet;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LifeCycleServlet extends HttpServlet {
	
	//0.톰캣 실행
	//1./lifecycle로 가장 처음 요청
	//2.Tomcat은 web.xml을 참조해서 /lifecycle에 해당하는 서블릿이 있는지 확인
	//3.해당 서블릿클래스로부터 객체생성
	//4.init()호출, service()호출
	//5./lifecycle로 두번째 요청
	//6.service()호출
	//...실행
	//9.서버종료 -> destory()호출
	
	public void init(ServletConfig config) throws ServletException {
		//servlet이 서비스를 하기전 사전작업(리소스 로딩)
		System.out.println("---init()---");
		System.out.println(config.getInitParameter("company"));
	}
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//요청정보를 토대로 응답 생성(html, 데이터, 이미지) 생성
		System.out.println("---service()---");
	}
	
	public void destroy() {
		//서블릿 컨테이너(톰캣)이 종료되기전 마무리작업(스트림 닫기)
		System.out.println("---destory()---");
	}
	
}
