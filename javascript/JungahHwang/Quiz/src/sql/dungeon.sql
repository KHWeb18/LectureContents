create table dungeon(
    dungeon_no int not null auto_increment,
    name varchar(30) not null,
    description text null,
    monster_amount int not null,
    reg_date timestamp not null default now(),
    primary key(dungeon_no)
);

insert into dungeon (name, description, monster_amount) values ('SS', 'SS급', 10);
insert into dungeon (name, description, monster_amount) values ('S', 'S급', 7);
insert into dungeon (name, description, monster_amount) values ('A', 'A급', 5);
insert into dungeon (name, description, monster_amount) values ('B', 'B급', 3);
insert into dungeon (name, description, monster_amount) values ('C', 'C급', 1);