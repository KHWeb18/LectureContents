create table user(
   user_no int not null auto_increment,
   id varchar(20) not null,
   pw varchar(20) not null,
   name varchar(50) not null,
   pn varchar(13) not null,
   pn2 varchar(13) not null,
   email varchar(20) not null,
   email2 varchar(30) not null,
   addr varchar(200) not null,
   addr2 varchar(100) not null,
   addr3 varchar(100) not null,
   reg_date timestamp not null default now(),
   primary key(user_no)
);