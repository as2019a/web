create table guestbook(
    id number primary key,
    password VARCHAR2(10) not null,
    writer VARCHAR2(20) not null,
    ip VARCHAR2(15) not null,
    msg clob,
    writedate timestamp not null
);

create SEQUENCE seq_guestbook_id;

insert into guestbook values(seq_guestbook_id.nextval, '1111', 'TESTER',
'192.168.0.101', 'TEST GUSET BOOK', systimestamp);
insert into guestbook values(seq_guestbook_id.nextval, '2222', 'TESTER2',
'192.168.0.91', '테스트 방명록', systimestamp);

select * from guestbook;