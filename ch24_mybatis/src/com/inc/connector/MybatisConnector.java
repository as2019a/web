package com.inc.connector;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisConnector {
	private static MybatisConnector single;
	private static SqlSessionFactory factory;
	private MybatisConnector() {
		SqlSessionFactoryBuilder builder =
				new SqlSessionFactoryBuilder();
		Reader reader = null;
		try {
			reader =
				Resources.getResourceAsReader(
					"config/mybatis/mybatis-context.xml");
			factory = builder.build(reader);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	};

	public static MybatisConnector getInstance() {
		if (single == null) {
			single = new MybatisConnector();
		}
		return single;
	}
	
	public SqlSession getSqlSession() {
		return factory.openSession();
	}
}
