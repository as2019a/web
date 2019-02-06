create table photo(
    id number primary key,
    title varchar2(30) not null,
    filename varchar2(50) not null,
    password varchar2(10),
    regdate date
);

create sequence seq_photo_id;

insert into photo values(
 seq_photo_id.nextval, '풍경사진', '풍경.jpg', '1234', sysdate);