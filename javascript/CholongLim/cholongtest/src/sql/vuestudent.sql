create table vuestudent(
    student_no int not null auto_increment,
    name varchar(200) not null,
    grade int not null,
    reg_date timestamp not null default now(),
    primary key(student_no)
);

insert into vuestudent (name, grade) values
('김가가', 65);

insert into vuestudent (name, grade) values
('이나나', 30);

insert into vuestudent (name, grade) values
('박다다', 100);

insert into vuestudent (name, grade) values
('권라라', 93);

insert into vuestudent (name, grade) values
('강마마', 71);

insert into vuestudent (name, grade) values
('최바바', 57);