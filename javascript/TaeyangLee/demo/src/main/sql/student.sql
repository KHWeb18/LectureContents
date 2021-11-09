create table student(
   studentNo int not null auto_increment,
   name varchar(30) not null,
   age int not null,
   sex varchar(20),
   score int not null,
   regDate timestamp not null default now(),
   primary key(studentNo)
);