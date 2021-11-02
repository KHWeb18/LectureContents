create table vuestudent(
   student_no int not null auto_increment,
   name varchar(200) not null,
   score int not null,
   reg_date timestamp not null default now(),
   primary key(student_no)
);

insert into vuestudent (name, score) values
('시호', 85);
insert into vuestudent (name, score) values
('김수지', 90);
insert into vuestudent (name, score) values
('윤효경', 70);
insert into vuestudent (name, score) values
('김병진', 80);
insert into vuestudent (name, score) values
('김원석', 100);
insert into vuestudent (name, score) values
('최서원', 55);
insert into vuestudent (name, score) values
('박태준', 40);
insert into vuestudent (name, score) values
('기안', 60);
insert into vuestudent (name, score) values
('윤승호', 70);
insert into vuestudent (name, score) values
('이재웅', 33);

