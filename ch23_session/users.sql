create table users(
    id varchar2(20) primary key,
    password varchar2(10) not null,
    name varchar2(50) not null,
    regdate date not null
);

insert into users values('as2019a', '1239', '이영섭', sysdate);

