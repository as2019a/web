package com.inc.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.catalina.Session;
import org.apache.ibatis.session.SqlSession;

import com.inc.connector.MybatisConnector;
import com.inc.domain.Image;

public class ImageDao {
	private static ImageDao single;
	private Object image;

	private ImageDao() {
	};

	public static ImageDao getInstance() {
		if (single == null) {
			single = new ImageDao();
		}
		return single;
	}

	public List<Image> selectList() {
		SqlSession session = MybatisConnector.getInstance().getSqlSession();
		List<Image> imageList = session.selectList("image.imageList", image);
		session.close();
		return imageList;
	}

	public List<Image> selectList(String collection, String thumbnails, String display_sitename, String contents) {
		SqlSession session = MybatisConnector.getInstance().getSqlSession();
		Map<String, String> conditionMap = new HashMap<>();
		conditionMap.put("collection", collection);
		conditionMap.put("thumbnails", thumbnails);
		conditionMap.put("display_sitename", display_sitename);
		conditionMap.put("contents", contents);
		List<Image> imageList = session.selectList("image.imageListConditio", conditionMap);
		session.close();
		return imageList;
	}

	public void delete(String collection) {
		SqlSession session = MybatisConnector.getInstance().getSqlSession();
		session.delete("image.delete", collection);
		session.commit();
		session.close();
		
	}

	
}
