package com.inc.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.inc.connector.MybatisConnector;
import com.inc.domain.Cart;

public class CartDao {
	private static CartDao single;

	private CartDao() {
	};

	public static CartDao getInstance() {
		if (single == null) {
			single = new CartDao();
		}
		return single;
	}

	public void insert(Cart cart) {
		SqlSession session = MybatisConnector.getInstance().getSqlSession();
		session.insert("cart.insert", cart);
		session.commit();
		session.close();
	}

	//select * from cart where users_id = 'admin' <- 사용자 장바구니목록표(SQL - 오라클에서 표시)
	//Cart Dao로 Servlet으로 부터 데이터를 가져와서 jsp로 표시(장바구니 관련 부분)
	public List<Cart> selectList(String id) {
		SqlSession session = MybatisConnector.getInstance().getSqlSession();
		List<Cart> cartList = session.selectList("cart.selectList", id);
		session.close();
		return cartList;
	}

	public int delete(int id, String users_id) {
		SqlSession session = MybatisConnector.getInstance().getSqlSession();
		session.delete("cart.delete", id);
		Map<String, Object> map = new HashMap<>();
		map.put("id", id);
		map.put("users_id", users_id);
		
		int result = session.delete("cart.delete", map);
		session.commit();
		session.close();
		return result;
	}

	public void update(int id, int count) {
		SqlSession session =
				MybatisConnector.getInstance()
								.getSqlSession();
		
		Map<String, Integer> map = new HashMap<>();
		map.put("id", id);
		map.put("count", count);
		session.update("cart.update", map);
		session.commit();
		session.close();
		
	}
	
}
