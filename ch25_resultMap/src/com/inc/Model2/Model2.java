package com.inc.Model2;

public class Model2 {
	//기본 개념
	//1. servlet - controller
	// -> 요청을 받아 데이터를 생성
	// -> view에 데이터 전달
	//2. dao
	// -> servlet으로 부터 데이터를 생성후 리턴 작업
	//3. jsp - view
	// -> 데이터를 받아 화면에 표시
	//데이터는 DB커넥터, Mybatis커넥터에 보관되어있고 그 보관된 데이터를 가지고 
	//Servlet -> dto 생성 요청  후 -> dao -> 데이터를 받아서 -> jsp로 표시
	
	//장점 : 유지보수, 가독성, 전문성이 높다. Model1에서는 간단하고 빠른 장점이 있다.
	//단점 : 복잡하고 느리다. Model1에서는 유지보수, 가독성, 전문성이 Model2보다 낮은 단점이 있다.
	
	// <select> <- dao -> <resertMap>
	// <select> -> <resertMap> <-> <select>
	// <select> -> <resertMap> -> <select> -> <resultMap> -> <resertMap>
	
	// Employee -> Department
	// dao는 servlet으로 부터 데이터를 생성후 리턴 작업하고 그 과정에서 employee?id = 100번을 jsp로 화면에 표시되어야 한다.
	// 출력시 표시화면
	// 사원번호  사원명  멘티들      부서명     부서장명
	//   100     Steven  100번 해당  Executive   null
	
}
