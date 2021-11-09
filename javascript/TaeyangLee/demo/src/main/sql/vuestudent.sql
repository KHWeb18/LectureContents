create table vuestudent(
   student_no int not null auto_increment,
   name varchar(200) not null,
   score int not null,
   regDate timestamp not null default now(),
   primary key(student_no)
);
insert into vuestudent (name, score) values
 ('최강석', 20);

 insert into vuestudent (name, score) values
  ('유재석',80);

  insert into vuestudent (name, score) values
  ('강호동',70);

   insert into vuestudent (name, score) values
   ('붐',50);

   insert into vuestudent (name, score) values
   ('김범수',40);
   insert into vuestudent (name, score) values
   ('나얼',55);
    insert into vuestudent (name, score) values
   ('박효신',75);
