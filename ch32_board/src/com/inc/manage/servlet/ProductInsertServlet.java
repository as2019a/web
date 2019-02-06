package com.inc.manage.servlet;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.inc.dao.ProductDao;
import com.inc.domain.Product;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;


@WebServlet("/manage/product/insert")
public class ProductInsertServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getServletContext().getRealPath("/upload/image");
		MultipartRequest mr = new MultipartRequest(request, path, 5*1024*1024, "utf-8" ,new DefaultFileRenamePolicy());
		String model = mr.getParameter("model");
		String category = mr.getParameter("category");
		String manufacturer = mr.getParameter("manufacturer");
		File image = mr.getFile("image");
		String filename = image.getName();
		String content = mr.getParameter("content");
		int price = Integer.parseInt(mr.getParameter("price"));
		double discount = Double.parseDouble(mr.getParameter("discount"));
	    int count = Integer.parseInt(mr.getParameter("count"));
	    Product product = new Product();
		product.setModel(model);
		product.setCategory(category);
		product.setManufacturer(manufacturer);
		product.setImage(filename);
		product.setContent(content);
		product.setPrice(price);
		product.setDiscount(discount);
		product.setCount(count);
		
		ProductDao.getInstance().insert(product);
		
		response.getWriter().println("<script>");
		response.getWriter().println("alert('등록완료')");
		response.getWriter().println("location.href='/product/list?category="+category+"';");
		response.getWriter().println("</script>");
		
	}

}
