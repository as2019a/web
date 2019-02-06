package com.inc.dao;

import org.apache.ibatis.session.SqlSession;

import com.inc.connector.MybatisConnector;
import com.inc.domain.Reply;

public class ReplyDao {
	private static ReplyDao single;

	private ReplyDao() {
	};

	public static ReplyDao getInstance() {
		if (single == null) {
			single = new ReplyDao();
		}
		return single;
	}

	public void insert(Reply reply) {
		SqlSession session = MybatisConnector.getInstance().getSqlSession();
		session.insert("reply.insert", reply);
		session.commit();
		session.close();
		
	}

	public void insertRereply(Reply reply) {
		SqlSession session = MybatisConnector.getInstance().getSqlSession();
		//depth계산
		Reply parentReply = session.selectOne("reply.selectOne", reply.getRef());
		reply.setDepth(parentReply.getDepth() + 1);
		
		//step계산
		int step = 0;
		
		//부모의 형제를 찾거나 그러지 못할경우 부모의 부모...
		//루트댓글일때까지 찾는다.
		while(true) {
			step = session.selectOne("reply.brotherStep", parentReply);
			if(step != 0) {
				//찾았을 경우
				reply.setStep(step);
				//해당 스텝보다 크거나 같은 스텝을 가진 댓글들의
				//스탭을 1씩 증가
				session.update("reply.pushReply", reply);
				break;
			}
			
			if(parentReply.getRef() == 0) {
				step = session.selectOne("reply.maxStep", reply.getBoard_id());
				reply.setStep(step);
				break;
			}
			
			parentReply = session.selectOne("reply.selectOne", 
										parentReply.getRef());
			
			
		}
		
		session.insert("reply.insertRereply", reply);
		session.commit();
		session.close();
		
	}
}
