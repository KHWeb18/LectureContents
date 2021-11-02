create table vueboard(
    board_no int not null auto_increment,
    title varchar(200) not null,
    content text null,
    writer varchar(50) not null,
    reg_date timestamp not null default now(),
    primary key(board_no)
);


create table vuequiz89(
    quiz89_no int not null auto_increment,
    triangleWidth varchar(200) not null,
    triangleHeight varchar(200) not null,
    primary key(quiz89_no)
);
