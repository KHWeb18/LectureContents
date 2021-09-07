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



create table board(
   board_no int not null auto_increment,
   age int not null,
   gender varchar(10) not null,
   vaccine varchar(20) not null,
   content varchar(200),
   reg_date timestamp not null default now(),
   primary key(board_no)
);



create table vueboard(
    board_no int not null auto_increment,
    age int not null,
    gender varchar(10) not null,
    vaccine varchar(20) not null,
    content text null,
    reg_date timestamp not null default now(),
    primary key(board_no)
);



create table book(
    book_no int not null auto_increment,
    month int not null,
    day int not null,
    time int not null,
    place varchar(100) not null,
    reg_date timestamp not null default now(),
    primary key(book_no)
);


CREATE TABLE reserve (
  id INT NOT NULL,
  date DATETIME NOT NULL,
  place VARCHAR(45) NOT NULL,
  userId BIGINT NOT NULL,
  PRIMARY KEY (id),
  INDEX id_idx (userId ASC) VISIBLE,
  CONSTRAINT userid
    FOREIGN KEY (userId)
    REFERENCES test_joon.account (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE);
);


