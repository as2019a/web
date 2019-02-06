package com.inc.dao;

public class KorsDao {
	private static KorsDao single;

	private KorsDao() {
	};

	public static KorsDao getInstance() {
		if (single == null) {
			single = new KorsDao();
		}
		return single;
	}
}
