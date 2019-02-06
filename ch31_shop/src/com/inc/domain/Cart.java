package com.inc.domain;

public class Cart {
	private int id, count;
	private String product_model, users_id;
	private Product product;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getProduct_model() {
		return product_model;
	}
	public void setProduct_model(String product_model) {
		this.product_model = product_model;
	}
	public String getUsers_id() {
		return users_id;
	}
	public void setUsers_id(String users_id) {
		this.users_id = users_id;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	
	
}