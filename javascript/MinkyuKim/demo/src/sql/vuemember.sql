- VueMemberController sql -
create table vuemember(
member_no int not null auto_increment,
id varchar(50) not null,
pw varchar(50) not null,
reg_date timestamp not null default now(),
primary key(member_no)
);