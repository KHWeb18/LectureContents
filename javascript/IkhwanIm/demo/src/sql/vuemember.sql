create table vuemember(
                         member_no int not null auto_increment,
                         email varchar(30) not null,
                         password varchar(30) not null,
                         name varchar(20) not null,
                         reg_date timestamp not null default now(),
                         primary key(member_no)
);