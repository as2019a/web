create table board(
    id number primary key,
    users_id varchar2(20) references users(id),
    title varchar2(100) not null,
    content clob not null,
    hit number,
    ip varchar2(30) not null,
    regdate date
);

create sequence seq_board_id;

insert into board values(seq_board_id.nextval, 'admin', '첫 게시물',
                        '테스트용 게시물 입니다', 10, '192.168.0.10', sysdate);
insert into board values(seq_board_id.nextval, 'admin', '첫 게시물',
                        '테스트용 게시물 입니다', 10, '192.168.0.10', '2018-11-20');

select * from board;

create table reply(
    id number primary key,
    board_id number references board(id) on delete cascade,
    users_id varchar2(20) references users(id),
    content varchar2(300) not null,
    regdate date,
    ref number,  -- 부모댓글(루트댓글 : 0)
    depth number, -- 깊이(루트댓글 : 0, 루트 댓글의 댓글 : 1)
    step number -- 댓글들간의 순서
);

create sequence seq_reply_id;

select max(step) + 1 from reply 
			where board_id = 18;

select * from reply;

