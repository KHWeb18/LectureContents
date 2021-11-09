use non_jpa_db;
create table join_mem(
    id_no int not null auto_increment,
    id varchar(20) not null,
    pw varchar(30) not null,
    name varchar(20) not null,
    tel varchar(30) not null,
    addr varchar(80) not null,
    gender varchar(5) not null,
    email varchar(30) not null,
    birth varchar(10) not null,
    reg_date timestamp not null default now(),
    primary key(id_no)
);