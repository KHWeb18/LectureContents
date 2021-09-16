create table vueboard(
    board_no int not null auto_increment,
    title varchar(200) not null,
    content text null,
    writer varchar(50) not null,
    reg_date timestamp not null default now(),
    primary key(board_no)
    );

create table review(
    review_no int not null auto_increment,
    writer varchar(50) not null,
    content text not null,
    reg_date timestamp not null default now(),
    upd_date timestamp not null default now(),
    primary key(review_no)
    );
)