create table student(
    student_no int not null auto_increment,
    name varchar(20) not null,
    score int not null,
    primary key(student_no)
);

insert into student (name, score) values ('나은', 85);
insert into student (name, score) values ('철수', 55);
insert into student (name, score) values ('영희', 65);
insert into student (name, score) values ('미진', 100);
insert into student (name, score) values ('영수', 70);
insert into student (name, score) values ('유진', 35);
insert into student (name, score) values ('은혜', 40);
insert into student (name, score) values ('승우', 90);
insert into student (name, score) values ('수지', 60);
insert into student (name, score) values ('예은', 25);