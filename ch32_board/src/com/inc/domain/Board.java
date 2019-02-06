package com.inc.domain;

import java.util.List;

/*id number primary key,
users_id varchar2(20) references users(id),
title varchar2(100) not null,
content clob not null,
hit number,
ip varchar2(30) not null,
regdate date*/
//number, date -> int(숫자)
//varchar2, clob -> String(문자)

public class Board{
	private int id, hit;
	private String users_id, title, content, ip, regdate;
	private List<Reply> replyList;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public String getUsers_id() {
		return users_id;
	}
	public void setUsers_id(String users_id) {
		this.users_id = users_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public List<Reply> getReplyList() {
		return replyList;
	}
	public void setReplyList(List<Reply> replyList) {
		this.replyList = replyList;
	};
	
	
}	