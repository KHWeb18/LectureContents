create table vueboard(
    board_no int not null auto_increment,
    title varchar(200) not null,
    content text null,
    writer varchar(50) not null,
    reg_date timestamp not null default now(),
    primary key(board_no)
 );

 create table vuemonster(
         monster_no int not null auto_increment,
         name varchar(200) not null,
         description varchar(200) not null,
         hp int  not null,
         exp int  not null,
         dropMoney int not null,
         dropItem varchar(50) not null,
         reg_date timestamp not null default now(),
         primary key(monster_no)
         );

       create table vuedungeon(
           dungeon_no int not null auto_increment,
           name varchar(200) not null,
           description text null,
           monster_amount int not null,
           reg_date timestamp not null default now(),
           primary key(dungeon_no)
       );



insert into vendungeon (name, description, monster_amount) values
('불타는 대지', '끝없이 화염푹풍이 몰아치는전장', 2);
insert into vendungeon (name, description, monster_amount) values
('망각의 길', '끝없이 망각의길로 걸어가는 망각그자체전장.', 3);
insert into vendungeon (name, description, monster_amount) values
('후회의길', '끝없이 후회의길로 걸어가는 후회그자체전장', 4);
insert into vendungeon (name, description, monster_amount) values
('기쁨의 길', '끝없이 기쁨의길로 걸어가는 기쁨그자체전장', 5);
insert into vendungeon (name, description, monster_amount) values
('슬픔의 길', '끝없이 슬픔의길로 걸어가는 슬픔그자체전장', 6);
