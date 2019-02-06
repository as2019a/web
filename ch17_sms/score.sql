create user webprog IDENTIFIED by 1111;

grant dba to webprog;
drop table socre;
create table score(
    id number primary key,
    name varchar2(20) not null,
    kor number(3),
    eng number(3),
    math number(3)
);

create or replace view score_view
as select id, name, kor, eng, math, 
nvl(kor,0) + nvl(eng,0) + nvl(math,0) total,
trunc((nvl(kor,0) + nvl(eng,0) + nvl(math,0))/3) average from score;

create SEQUENCE seq_score_id;

insert into score values(seq_score_id.nextval, 'harry', 100, 90, 100);
insert into score values(seq_score_id.nextval, 'lone', 70, 50, 40);
insert into score values(seq_score_id.nextval, 'harmione', 90, 90, 80);
select * from score_view;

create table Person(
    id char(9) primary key,
    name varchar2(20) not null,
    age number(3)
);

desc Person;
select * from score;

