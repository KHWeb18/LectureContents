create table vueproduct(
    product_no int not null auto_increment,
    name varchar(200) not null,
    price varchar(50) not null,
    description text null,
    producer varchar(50) not null,
    reg_date timestamp not null default now(),
    primary key(product_no)
);