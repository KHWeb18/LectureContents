create table vuedungeon(
dungeon_no int not null auto_increment,
name varchar(200) not null,
description text null,
monster_amount int not null,
reg_date timestamp not null default now(),
primary key(dungeon_no)
);


insert into test_member (id, pw, name,sex, phone_no, birth) values
('test','test','test','test','test','test');
insert into test_member (id, pw, name,sex, phone_no, birth) values
('test2','test2','test2','test2','test2','test2');
insert into test_member (id, pw, name,sex, phone_no, birth) values
('test3','test3','test3','test3','test3','test3');

insert into vuedungeon (name, description, monster_amount) values
('뇌전 도원', '시도때도 없이 벼락이 떨어지는 매우 위험한 던전', 5);

insert into vuedungeon (name, description, monster_amount) values
('심해빙원', '바다 깊은곳에 숨겨져 있는 얼음 던전', 3);

insert into vuedungeon (name, description, monster_amount) values
('망자들의 쉼터', '망령 계열의 몬스터들이 가장 많이 출몰하는 던전', 2);

insert into vuedungeon (name, description, monster_amount) values
('잊혀진 고대 던전', '빛 계열 몬스터들이 가장 많이 출몰하는 던전', 3);

insert into vuedungeon (name, description, monster_amount) values
('테스트', '테스트', 1);

insert into vuedungeon (name, description, monster_amount) values
('멸망의 시전', '혼돈 그 자체', 7);