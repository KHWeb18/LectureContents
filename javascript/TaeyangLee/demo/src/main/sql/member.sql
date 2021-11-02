create table Member(
   memberNo int not null auto_increment,
   id varchar(30) not null,
   pw varchar(30) not null,
regDate timestamp not null default now(),
   primary key(memberNo)
);