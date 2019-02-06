package com.inc.dao;

public class SpiderDao {
	private static SpiderDao single;

	private SpiderDao() {
	};

	public static SpiderDao getInstance() {
		if (single == null) {
			single = new SpiderDao();
		}
		return single;
	}
}
