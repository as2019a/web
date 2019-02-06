create table category(
    name varchar2(20) primary key
);

insert into category values('database');
insert into category values('language');
insert into category values('library');

create table subcategory(
    name varchar2(20) primary key,
    category_name varchar2(20) references category(name)
);

insert into subcategory values('oracle','database');
insert into subcategory values('mysql','database');
insert into subcategory values('mongodb','database');

insert into subcategory values('java','language');
insert into subcategory values('javascript','language');

insert into subcategory values('jquery','library');
insert into subcategory values('jdbc','library');
select * from subcategory;