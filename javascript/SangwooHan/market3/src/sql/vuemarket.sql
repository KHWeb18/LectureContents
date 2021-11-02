create table vuemarket(
vuemarket_no int not null auto_increment,
username varchar(200) not null,
name varchar(200) not null,
price varchar(200) not null,
description varchar (200) not null,
reg_date timestamp not null default now(),
primary key(vuemarket_no)
);