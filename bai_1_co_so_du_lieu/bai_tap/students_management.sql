create database students_managements;

use students_managements;

create table student (
id int primary key,
`name` varchar(60),
date_of_birth date,
`country` varchar(60)
);

insert into student
values (1,'Tien','1989-02-12','VietNam');

insert into student
values (2,'Dung','1999-02-12','VietNam');

insert into student
values (3,'Lan','2001-02-12','VietNam');
 
