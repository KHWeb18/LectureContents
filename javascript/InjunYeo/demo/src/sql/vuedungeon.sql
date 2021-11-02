create table vuedungeon(
    dungeon_no int not null auto_increment,
    name varchar(200) not null,
    description text null,
    monster_amount int not null,
    reg_date timestamp not null default now(),
    primary key(dungeon_no)
);

insert into vuedungeon (name, description, monster_amount ) values
('몽환의 숲','하늘에 날린 아드레날린이 많은 곳', 2);

insert into vuedungeon (name, description, monster_amount ) values
('무릉도원','물온도가 어떤지 물어보는 곳', 3);

insert into vuedungeon (name, description, monster_amount ) values
('잿빛숲','남은건 오직 나무였던 것의 흔적', 4);

insert into vuedungeon (name, description, monster_amount ) values
('하얀강','어디선가 들리는 로렐라이의 노래', 2);

insert into vuedungeon (name, description, monster_amount ) values
('숲의 기억','숲이 나비인걸까 나비가 숲인 걸까', 3);
