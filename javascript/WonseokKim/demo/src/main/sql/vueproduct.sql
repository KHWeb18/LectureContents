create table vueproduct(
    product_no int not null auto_increment,
    title varchar(200) not null,
    price varchar(200) not null,
    content text null,
    writer varchar(50) not null,
    reg_date timestamp not null default now(),
    primary key(product_no)
);