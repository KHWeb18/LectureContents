  create table user(
   user_no int not null auto_increment,
   userName varchar(10) not null,
   id varchar(50) not null,
   pw varchar(50) not null,
   reg_date timestamp not null default now(),
   primary key(member_no)
);