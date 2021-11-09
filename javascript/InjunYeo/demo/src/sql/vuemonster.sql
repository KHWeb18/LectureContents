create table vuemonster(
    monster_no int not null auto_increment,
    name varchar(200) not null,
    description text null,
    hp int not null,
    exp int not null,
    dropMoney int not null,
    dropItem varchar(50) not null,
    reg_date timestamp not null default now(),
    primary key(monster_no)
);