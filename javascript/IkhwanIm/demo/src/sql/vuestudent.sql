create table vuestudent(
                           student_no int not null auto_increment,
                           name varchar(200) not null,
                           student_grade int not null,
                           grades varchar(50) not null,
                           reg_date timestamp not null default now(),
                           primary key(student_no)
);

insert into vuestudent (name, student_grade, grades) values
('홍길동', 1, 'A');

insert into vuestudent (name, student_grade, grades) values
('손오공', 1, 'B');

insert into vuestudent (name, student_grade, grades) values
('김미김', 1, 'C');

insert into vuestudent (name, student_grade, grades) values
('한국인', 1, 'D');

insert into vuestudent (name, student_grade, grades) values
('민수민', 1, 'F');