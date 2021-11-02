create table vuestudent(
    student_no int not null auto_increment,
    name varchar(200) not null,
    score int not null,
    reg_date timestamp not null default now(),
    primary key(student_no)
);

insert into vuestudent (name, score) values
('논논', 20);

insert into vuestudent (name, score) values
('몬몬', 30);

insert into vuestudent (name, score ) values
('손손', 40);

insert into vuestudent (name, score) values
('공공', 50);

insert into vuestudent (name, score) values
('돈돈', 80);
