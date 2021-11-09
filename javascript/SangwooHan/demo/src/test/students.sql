 create table vuestudent(
           student_no int not null auto_increment,
           name varchar(200) not null,
           score int not null,
           reg_date timestamp not null default now(),
           primary key(student_no)
       );



insert into vuestudent (name, score) values
('김철수', '45');
insert into vuestudent (name, score) values
('나진수', '60');
insert into vuestudent (name, score) values
('남기철', '71');
insert into vuestudent (name, score) values
('최창신', '12');
insert into vuestudent (name, score) values
('김사랑', '100');