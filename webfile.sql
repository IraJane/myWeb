#personal bloggger

create table Pal (
	id varchar(255),
    password varchar(255),
    nickname varchar(255)
);

select * from members;

insert into musiclist(title, body, user_id)
values ('3게시물4', '본문4', 'sd'),
('게시물23', '본문21', 'jay'),
('게시물32', '본문31', 'kay'),
('게시sd', '본문sd', 'may');


create table booklist (
	id int primary key auto_increment, 
	title varchar(255),
    body varchar(3000),
    user_id varchar(255),
	created datetime default now()
);

create table musiclist (
	id int primary key auto_increment, 
	title varchar(255),
    body varchar(3000),
    user_id varchar(255),
	created datetime default now(),
    file varchar(255)
);



create table commenthoop (
id int primary key auto_increment,
comment varchar(1000),
item_id int,
user_id varchar(255),
created datetime default now()
);




create table commenthread (
id int primary key auto_increment,
comment varchar(1000),
item_id int,
user_id varchar(255),
created datetime default now()
);


alter table commenthread
add column nickName varchar(255);

alter table booklist
add column file varchar(255);

alter table members
add column file varchar(255);



select * from members;
select * from booklist;
select * from musiclist;
select * from commenthread;
select * from commenthoop;