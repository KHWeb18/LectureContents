create table vuestudent(
    student_no int not null auto_increment,
    name varchar(200) not null,
    score int not null,
    reg_date timestamp not null default now(),
    primary key(student_no)
);

insert into vuestudent (name, score) values
('최태팔', 12);

insert into vuestudent (name, score) values
('오석진', 99);

insert into vuestudent (name, score) values
('최승현', 77);

insert into vuestudent (name, score) values
('이아영', 88);

insert into vuestudent (name, score) values
('공효진', 55);

