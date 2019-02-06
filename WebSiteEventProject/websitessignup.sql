create table websignup(
    id number primary key,
    password varchar2(10),
    name varchar2(50) not null,
    email varchar(50)
);

create sequence seq_websignup_id;

insert into websignup values('as2019a', 
'@koreas2030', '이영섭', 'as2006a@naver.com');