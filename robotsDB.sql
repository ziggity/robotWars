create database if not exists robots;

use robots;

drop table if exists robots;

create table robots(
		id int(10) not null auto_increment,
		name varchar(50) not null,
		primary key(id)
);
