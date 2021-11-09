create table vuedungeon(
    dungeon_no int not null auto_increment,
    name varchar(200) not null,
    description text null,
    monster_amount int not null,
    reg_date timestamp not null default now(),
    primary key(dungeon_no)
);

insert into vuedungeon (name, description, monster_amount) values
('불의 던전', '화염 폭풍 전장 지역', 2);

insert into vuedungeon (name, description, monster_amount) values
('번개의 던전', '벼락 전장 지역', 5);

insert into vuedungeon (name, description, monster_amount) values
('얼음의 던전', '빙해 전장 지역', 3);

insert into vuedungeon (name, description, monster_amount) values
('망자의 던전', '망령 전장 지역', 4);

insert into vuedungeon (name, description, monster_amount) values
('고대 던전', '빛의 전장 지역', 3);

insert into vuedungeon (name, description, monster_amount) values
('멸망 던전', '혼돈 전장 지역', 7);

insert into vuedungeon (name, description, monster_amount) values
('멸망 던전', '혼돈 전장 지역', 7);