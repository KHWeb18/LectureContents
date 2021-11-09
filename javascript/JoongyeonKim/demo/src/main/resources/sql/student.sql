create table vuestudent(
   student_no int not null auto_increment,
   name varchar(200) not null,
   score int not null,
   reg_date timestamp not null default now(),
   primary key(student_no)
);

insert into vuestudent (name, score) values
('이융', 23);

insert into vuestudent (name, score) values
('이황', 89);

insert into vuestudent (name, score) values
('김유신', 75);

insert into vuestudent (name, score) values
('계백', 67);

insert into vuestudent (name, score) values
('관창', 57);

insert into vuestudent (name, score) values
('궁예', 43);

insert into vuestudent (name, score) values
('장보고', 68);

insert into vuestudent (name, score) values
('이도', 100);

insert into vuestudent (name, score) values
('이방원', 95);

insert into vuestudent (name, score) values
('정몽주', 93);

insert into vuestudent (name, score) values
('견훤', 39);




