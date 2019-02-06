package com.inc.domain;

public class Reply {
	/*id number primary key,
    board_id number references board(id) on delete cascade,
    users_id varchar2(20) references users(id),
    content varchar2(300) not null,
    regdate date,
    ref number,  -- 부모댓글(루트댓글 : 0)
    depth number, -- 깊이(루트댓글 : 0, 루트 댓글의 댓글 : 1)
    step number*/
	
	private int id, board_id, ref, depth, step;
	private String users_id, content, regdate;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getBoard_id() {
		return board_id;
	}
	public void setBoard_id(int board_id) {
		this.board_id = board_id;
	}
	public int getRef() {
		return ref;
	}
	public void setRef(int ref) {
		this.ref = ref;
	}
	public int getDepth() {
		return depth;
	}
	public void setDepth(int depth) {
		this.depth = depth;
	}
	public int getStep() {
		return step;
	}
	public void setStep(int step) {
		this.step = step;
	}
	public String getUsers_id() {
		return users_id;
	}
	public void setUsers_id(String users_id) {
		this.users_id = users_id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	
	
}
