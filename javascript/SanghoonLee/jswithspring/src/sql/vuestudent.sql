create table vuestudent(
    student_no int not null auto_increment,
    name varchar(200) not null,
    score int not null,
    reg_date timestamp not null default now(),
    primary key(student_no)
);

insert into vuestudent (name, score) values
('최강석', 20);

insert into vuestudent (name, score) values
('공명진', 85);

insert into vuestudent (name, score) values
('김미령', 73);

insert into vuestudent (name, score) values
('마승찬', 62);

insert into vuestudent (name, score) values
('심용수', 93);

insert into vuestudent (name, score) values
('김태형', 57);
