create table vueproduct(
    product_no int not null auto_increment,
    title varchar(100) not null,
    price varchar(50) not null,
    content text null,
    writer varchar(50) not null,
    reg_date timestamp not null default now(),
    primary key(product_no)
);

create table board(
    board_no int not null auto_increment,
    title varchar(100) not null,
    content text null,
    writer varchar(50) not null,
    reg_date timestamp not null default now(),
    primary key(board_no)
);