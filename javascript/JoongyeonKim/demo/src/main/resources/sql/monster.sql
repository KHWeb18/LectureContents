create table vuemonster(
   monster_no int not null auto_increment,
   name varchar(200) not null,
   hp int not null,
   atk int not null,
   reg_date timestamp not null default now(),
   primary key(monster_no)
);