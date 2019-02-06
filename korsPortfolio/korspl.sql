create table jobtype(
    id number primary key,
    category_name varchar2(60),
    job_name varchar2(60),
    min_salary NUMBER(6),    
    max_salary NUMBER(6)
);

SELECT * FROM jobtype;

create table image(
    collection varchar2(30),
    thumbnails varchar2(50),
    display_sitename varchar2(50) not null,
    contents varchar2(50)
);

desc image;
select * from image;

insert into image values(
    'Movie', 'Moives.jpg', '배급사', '영화'
);

insert into image values(
    'Mobile', 'cars.jpg', '자체개발자01', '모바일콘텐츠'
);

insert into image values(
    'Book', 'wouldbook.jpg', '출판사01', '도서'
);