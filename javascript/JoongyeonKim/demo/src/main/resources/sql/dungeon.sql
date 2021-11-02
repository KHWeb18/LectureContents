create table vuedungeon(
   dungeon_no int not null auto_increment,
   name varchar(200) not null,
   description text null,
   monster_amount int not null,
   reg_date timestamp not null default now(),
   primary key(dungeon_no)
);

insert into vuedungeon (name, description, monster_amount) values
('불타는 대지', '끝없는 화염폭풍이 몰아치는 과거 전장지역', 1);

insert into vuedungeon (name, description, monster_amount) values
('뇌명정원', '시도때도 없이 벼락이 떨어지는 매우 위험한 던전', 2);

insert into vuedungeon (name, description, monster_amount) values
('심해빙궁', '바다 깊은 곳에 숨겨져 있는 얼음 궁전', 4);

insert into vuedungeon (name, description, monster_amount) values
('망자들의 쉼터', '망령 계열의 몬스터들이 가장 많이 출몰하는 던전', 3);

insert into vuedungeon (name, description, monster_amount) values
('잊혀 진 고대의 신전', '빛 계열 몬스터들이 가장 많이 출몰하는 던전', 5);

