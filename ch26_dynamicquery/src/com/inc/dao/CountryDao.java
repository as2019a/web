package com.inc.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.inc.connector.MybatisConnector;
import com.inc.domain.Country;

public class CountryDao {
	private static CountryDao single;

	private CountryDao() {};

	public static CountryDao getInstance() {
		if (single == null) {
			single = new CountryDao();
		}
		return single;
	}

	public List<Country> selectList(String name, String[] idList) {
		SqlSession session = 
				MybatisConnector.getInstance().getSqlSession();
		Map<String, Object> map = new HashMap<>();
		map.put("name", name);
		map.put("idList", idList);
		List<Country> countryList = 
				session.selectList("countries.selectList", map);
		System.out.println("출력");
		session.close();
		return countryList;
	}
}
