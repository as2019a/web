package com.inc.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.inc.connector.MybatisConnector;
import com.inc.domain.Product;

public class ProductDao {
	private static ProductDao single;

	private ProductDao() {
	};

	public static ProductDao getInstance() {
		if (single == null) {
			single = new ProductDao();
		}
		return single;
	}
	
	public List<Product> 
				selectListByCategory(Map<String, String> map){
		SqlSession session = MybatisConnector.getInstance().getSqlSession();
		List<Product> productList = session.selectList("product.selectListByCategory", map);
		session.close();
		return productList;
	}

	public List<String> selectCategoryList() {
		SqlSession session = MybatisConnector.getInstance().getSqlSession();
		List<String> categoryList =  session.selectList("product.categoryList");
		session.close();
		return categoryList;
	}

	public int categoryCount(String category) {
		//category를 들고가서 해당 카테고리와 일치하는 튜플의 갯수를 반환
		SqlSession session = MybatisConnector.getInstance().getSqlSession();
		int count = session.selectOne("product.categoryCount",category);
		session.close();
		return count;
	}

	public void categoryInsert(String category) {
		SqlSession session = MybatisConnector.getInstance().getSqlSession();
		session.insert("product.categoryInsert", category);
		session.commit();
		session.close();
		
	}

	public int productCount(String model) {
		SqlSession session = MybatisConnector.getInstance().getSqlSession();
		int count = session.selectOne("product.productCount" ,model);
		session.close();
		return count;
	}

	public void deleteCategory(String category) {
		SqlSession session = MybatisConnector.getInstance().getSqlSession();
		session.delete("product.deleteCategory", category);
		session.commit();
		session.close();
	}

	public void updateCategory(String category, String newCategory) {
		SqlSession session = MybatisConnector.getInstance().getSqlSession();
		Map<String, String> map = new HashMap<>();
		map.put("category", category);
		map.put("newCategory", newCategory);
		session.update("product.updateCategory", map);
		session.commit();
		session.close();
	}

	public void insert(Product product) {
		SqlSession session = MybatisConnector.getInstance().getSqlSession();
		session.insert("product.insert" ,product);
		session.commit();
		session.close();
	}

}
