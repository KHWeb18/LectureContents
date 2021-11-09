
create table vuestudent(
    student_no int not null auto_increment,
    name varchar(200) not null,
    score text null,
    reg_date timestamp not null default now(),
    primary key(student_no)
);

insert into vuestudent (name, score) values ('최강석',20);
insert into vuestudent (name, score) values ('이경환',100);
insert into vuestudent (name, score) values ('지민영',85);
insert into vuestudent (name, score) values ('권병수',70);
insert into vuestudent (name, score) values ('김재연',62);
insert into vuestudent (name, score) values ('안정환',35);
insert into vuestudent (name, score) values ('손흥민',81);
insert into vuestudent (name, score) values ('고종수',55);


