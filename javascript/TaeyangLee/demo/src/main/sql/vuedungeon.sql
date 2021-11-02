create table vuedungeon(
   dungeon_no int not null auto_increment,
   name varchar(200) not null,
   description text null,
   monster_amount int not null,
   regDate timestamp not null default now(),
   primary key(dungeon_no)
);
insert into vuedungeon (name, description, monster_amount) values
 ('불타는 대지','끝없이 화염폭풍이 몰아치는 전장 지역', 2);

 insert into vuedungeon (name, description, monster_amount) values
  ('무릉도원','천도과수원', 3);

  insert into vuedungeon (name, description, monster_amount) values
  ('황혼의 페리온','거친 황야', 2);

   insert into vuedungeon (name, description, monster_amount) values
   ('소멸의 여로','동굴 깊숙한 곳', 3);

   insert into vuedungeon (name, description, monster_amount) values
   ('고통의 미궁','미궁의 중심 내부', 2);