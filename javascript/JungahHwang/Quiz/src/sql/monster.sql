create table monster(
    monster_no int not null auto_increment,
    name varchar(30) not null,
    hp int not null,
    exp int not null,
    money int not null,
    item varchar(50) not null,
    reg_date timestamp not null default now(),
    primary key(monster_no)
);