create table signup(
signup_no int not null auto_increment,
userid varchar(200) not null,
password int not null,
name varchar(200) not null,
birthday int not null,
gender varchar(200) not null,
address varchar(200) not null,
phoneNo int not null,
reg_date timestamp not null default now(),
primary key(signup_no)
);

