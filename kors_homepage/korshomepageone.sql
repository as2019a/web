-- create user kors identified by 1111; --
-- grant dba to kors; --

create table employeek(
    id number primary key,
    name varchar2(50) not null,
    age number,
    email VARCHAR2(25) NOT NULL,
    photo_number VARCHAR2(20), 
    hide_date DATE NOT NULL,
    jobs varchar2(80),
    rank varchar2(50),
    Work_place varchar(50),
    salary number(8,2),
    department_id number(4),
    department_name VARCHAR(80),
    location_id NUMBER(4),
    regdate date not null
);

select * from employeek;
desc employeek;
create sequence seq_employeek_id;
alter table employeek add gender varchar2(50);

insert into employeek values(seq_employeek_id.nextval, 'LeeHyena', 45,
                            'hayer@naver.com', '010-7820-9959', '98/01/03',
                            'AD_PRES', 'CEO', 'kors', 9500000, 10, 
                            'Administration', 01, '1998-01-03');

