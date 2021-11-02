create table vuestudent(
    student_no int not null auto_increment,
    name varchar(200) not null,
    score int not null,
    reg_date timestamp not null default now(),
    primary key(student_no)
);

insert into vuestudent (name, score) values
('최준환', 50);

insert into vuestudent (name, score) values
('조현철', 60);

insert into vuestudent (name, score) values
('최준영', 30);

insert into vuestudent (name, score) values
('최백준', 80);

insert into vuestudent (name, score) values
('유재석', 90);

