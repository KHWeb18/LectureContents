create table vuemonster(
    monster_no int not null auto_increment,
    monster_name varchar(50) not null,
    monster_hp int not null,
    monster_exp int not null,
    monster_money int not null,
    monster_description text null,
    reg_date timestamp not null default now(),
    primary key(monster_no)
);