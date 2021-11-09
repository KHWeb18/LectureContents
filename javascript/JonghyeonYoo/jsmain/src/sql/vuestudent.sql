create table vuestudent(
    student_no int not null auto_increment,
    name varchar(200) not null,
    score text null,
    reg_date timestamp not null default now(),
    primary key(student_no)
);

insert into vuestudent (name, score) values
('김아영', 20);

insert into vuestudent  (name, score) values
('기무라', 75);

insert into vuestudent  (name, score) values
('고승찬', 63);

insert into vuestudent  (name, score) values
('송길범', 82);

insert into vuestudent  (name, score) values
('윤정현', 37);

insert into vuestudent  (name, score) values
('유종현', 99);