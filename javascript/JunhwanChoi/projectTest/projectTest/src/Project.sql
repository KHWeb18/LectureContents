create table project(
   project_no int not null auto_increment,
   name varchar(200) not null,
   price int not null,
   description text not null,
   reg_date timestamp not null default now(),
   primary key(project_no)
);



create table project(
   username varchar(200) not null,
   birth int not null,
   id varchar(200) not null,
   password varchar(200) not null,
   reg_date timestamp not null default now(),
   primary key(username)
);


create table vueproject(
   member_no int not null auto_increment,
   username varchar(200) not null,
   birth int not null,
   id varchar(200) not null,
   password varchar(200) not null,
   reg_date timestamp not null default now(),
   primary key(member_no)
);



