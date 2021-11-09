create table vuemember(
    member_no int not null auto_increment,
    id varchar(200) not null,
    pw text null,
    address varchar(50) not null,
    reg_date timestamp not null default now(),
    primary key(member_no)
  );