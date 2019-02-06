package com.inc.domain;

import java.util.List;

public class Country {
	private String country_id;
	private String country_name;
	private List<Location> location_list;
	
	public String getCountry_id() {
		return country_id;
	}
	public void setCountry_id(String country_id) {
		this.country_id = country_id;
	}
	public String getCountry_name() {
		return country_name;
	}
	public void setCountry_name(String country_name) {
		this.country_name = country_name;
	}
	public List<Location> getLocation_list() {
		return location_list;
	}
	public void setLocation_list(List<Location> location_list) {
		this.location_list = location_list;
	}
	
	
}
