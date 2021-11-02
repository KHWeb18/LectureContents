create table user(
   user_no int not null auto_increment,
   u_id varchar(20) not null,
   u_pw varchar(20) not null,
   u_name varchar(50) not null,
   u_pn varchar(13) not null,
   u_pn2 varchar(13) not null,
   u_email varchar(20) not null,
   u_email2 varchar(30) not null,
   u_addr varchar(200) not null,
   u_addr2 varchar(100) not null,
   u_addr3 varchar(100) not null,
   reg_date timestamp not null default now(),
   primary key(user_no)
);