create table member(
   member_no int not null auto_increment,
   name varchar(200) not null,
   id varchar(200) not null,
   pw varchar(200) not null,
   reg_date timestamp not null default now(),
   primary key(member_no)
);