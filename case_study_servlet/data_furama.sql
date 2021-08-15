create database database_furama;

use database_furama;


-- vị trí
create table position (
position_id int primary key auto_increment,
position_name varchar(45)
);

insert into position (position_name)
values
('Giám đốc'),
('Phó giám đốc'),
('Quản Lý'),
('Trưởng Phòng'),
('Trưởng Nhóm'),
('Nhân viên');

-- trình độ
create table education_degree (
education_degree_id int primary key auto_increment,
education_degree_name varchar(45)
);

insert into education_degree (education_degree_name)
values
('Đại học'),
('Cao đẳng'),
('Trung cấp'),
('Khác');

-- bộ phận
create table division ( 
division_id int primary key auto_increment,
division_name varchar(45)
);

insert into division (division_name)
values
('Lễ Tân'),
('Buồng Phòng'),
('Ẩm thực'),
('Kinh doanh'),
('Hành chính - Nhân sự'),
('Tài Chính - Kế Toán'),
('Kỹ Thuật'),
('An ninh');

-- tài khoản
create table `user`(
username varchar(255) primary key,
`password` varchar(255)
);

insert into `user`
values
('nguyenan', '123123'),
('nguyenbinh', '123123'),
('hoaho', '123123'),
('trandat', '123123'),
('huyenle', '123123'),
('phuongpham', '123123'),
('khuongle', '123123'),
('camtu', '123123'),
('nguyenc', '123123');

-- nhân viên
create table employee (
employee_id int auto_increment primary key,
employee_name varchar(45) not null,
employee_birthday date not null,
employee_id_card varchar(45) not null,
employee_salary double not null,
employee_phone varchar(45),
employee_email varchar(45),
employee_address varchar(45),
position_id int not null,
education_degree_id int not null,
division_id int not null, 
username varchar(255),
foreign key (position_id) references position (position_id) on delete cascade on update cascade,
foreign key (education_degree_id) references education_degree(education_degree_id)  on delete cascade on update cascade,
foreign key (division_id) references division(division_id) on delete cascade on update cascade,
foreign key (username) references `user` (username) on delete cascade on update cascade
);

insert into employee(employee_name, employee_birthday, employee_id_card, employee_salary, employee_phone, employee_email, employee_address, position_id, education_degree_id, division_id, username )
values 
('Nguyễn Văn An', '1990-01-15', 111453211, 30000000, 0905150190, 'nguyenan@gmail.com','Đà Nẵng', 1, 1, 4, 'nguyenan'),
('Nguyễn Văn Bình', '1993-02-22', 112123456, 6000000, 0905220293, 'nguyenbinh@gmail.com','Quảng Nam', 6, 2, 7, 'nguyenbinh'),
('Hồ Thị Hoa', '1995-11-04', 113980765, 10000000, 0935041194, 'hoaho@gmail.com','Huế', 3, 1, 3, 'hoaho'),
('Trần Văn Đạt', '1992-09-26', 114123165, 8000000, 0770260992, 'trandat@gmail.com','Nghệ An', 4, 1, 6, 'trandat'),
('Lê Thị Huyền', '1996-05-05', 115742178, 6000000, 0905050596, 'huyenle@gmail.com','Quảng Trị', 5, 2, 2, 'huyenle'),
('Phạm Thị Phương', '1994-12-19', 116414141, 5000000, 0905191294, 'phuongpham@gmail.com','Quảnh Bình', 6, 3, 1, 'phuongpham'),
('Lê Văn Khương', '1991-09-02', 117776527, 5000000, 0905020991, 'khuongle@gmail.com','Nha Trang', 6, 3, 8, 'khuongle'),
('Huỳnh Thị Cẩm Tú', '1997-12-10', 118453211, 20000000, 0905101297, 'camtu@gmail.com','Thanh Hoá',  2, 1, 5, 'camtu'),
('Nguyễn Văn C', '1997-12-10', 118453211, 20000000, 0905101297, 'nguyenc@gmail.com','Quảng Bình', 6, 3, 1, 'nguyenc');

create table `role` (
role_id int primary key auto_increment,
role_name varchar(255)
);

insert into `role` (role_name)
values 
('admin'),
('user');

create table user_role (
role_id int,
username varchar(255), 
foreign key(role_id) references `role`(role_id) on delete cascade on update cascade,
foreign key(username) references `user`(username) on delete cascade on update cascade
);

insert into user_role
values
(1, 'nguyenan'),
(2, 'nguyenbinh'),
(1, 'hoaho'),
(2, 'trandat'),
(2, 'huyenle'),
(2, 'phuongpham'),
(2, 'khuongle'),
(1, 'camtu'),
(2, 'nguyenc');

-- loại khách hàng
create table customer_type(
	customer_type_id int auto_increment primary key,
    customer_type_name varchar(45)
);

insert into customer_type (customer_type_name)
values
('Diamon'),
('platinum'),
('Gold'),
('Silver'),
('Member');

-- khách hàng
create table customer(
	customer_id int auto_increment primary key,
    customer_code varchar(45) not null unique,
    customer_type_id int not null ,
    customer_name varchar(45) not null ,
    customer_birthday date not null ,
	customer_gender int,
    customer_id_card varchar(45) not null ,
    customer_phone varchar(45) not null,
    customer_email varchar(45),
    customer_address varchar(45),
    foreign key (customer_type_id) references customer_type(customer_type_id) on delete cascade on update cascade
);

insert into customer(customer_code ,customer_type_id, customer_name, customer_birthday, customer_gender, customer_id_card, customer_phone, customer_email, customer_address)
values
('KH-1001', 1, 'Nguyễn Đình Sơn Trà', '1997-11-26', 0, 100261197, 0905261197, 'tranguyen@gmail.com', 'Đà Nẵng'),
('KH-1002', 1, 'Trương Quốc Pháp', '1990-10-20', 0,100201090, 0905201090, 'phaptruong@gmail.com', 'Quảng Ngãi'),
('KH-1003', 2, 'Nguyễn Thị Nhung', '1995-08-30', 1, 100300895, 0905300895, 'nhungnguyen@gmail.com', 'Nghệ An'),
('KH-1004', 2, 'Nguyễn Thị Bích Thuý', '1996-02-28', 1, 100280296, 0905280296, 'thuynguyen@gmail.com', 'Quảng Trị'),
('KH-1005', 1, 'Nguyễn Thanh Bình', '1994-05-01', 0, 100010594, 0905010594, 'binhnguyen@gmail.com', 'Quảng Nam'),
('KH-1006', 5, 'Huỳnh Thị Bảo Trân', '1998-09-02', 1, 100020998, 0905020998, 'tranhuynh@gmail.com', 'Huế'),
('KH-1007', 2, 'Nguyễn Văn Lý Huỳnh', '1993-07-02', 0, 100020793, 0905020793, 'huynhnguyen@gmail.com', 'Vinh');

-- loại dịch vụ
CREATE TABLE service_type(
service_type_id int auto_increment primary key,
service_type_name varchar(45)
);

insert into service_type (service_type_name)
values
('villa'),
('house'),
('room');

-- kiểu thuê
create table rent_type(
rent_type_id int auto_increment primary key,
rent_type_name varchar(45),
rent_type_cost double
);

insert into rent_type (rent_type_name, rent_type_cost)
values
('năm', 50000000),
('tháng', 40000000),
('ngày', 30000000),
('giờ', 20000000);

-- dịch vụ
create table service(
service_id int auto_increment primary key, 
service_code varchar(45) not null ,
service_name varchar(45) not null,
service_area int,
service_cost double not null, 
service_max_people int,
rent_type_id int ,
service_type_id int ,
standard_room varchar(45),
description_other_convenience varchar(45),
pool_area double,
number_of_floors int ,
foreign key (rent_type_id) references rent_type(rent_type_id)  on delete cascade on update cascade,
foreign key (service_type_id) references service_type(service_type_id)  on delete cascade on update cascade
);

insert into service(service_code, service_name, service_area, service_cost, service_max_people, rent_type_id, service_type_id, standard_room, description_other_convenience, pool_area, number_of_floors)
values 
("DV-0001", "villa1", 200, 5000000, 15, 1, 1, "vip", "có hồ bơi", 70, 5),
("DV-0002", "house1", 100, 2000000, 10, 2, 2, "good", "có hồ bơi", 50, 3),
("DV-0003", "room1", 50, 1000000, 5, 3, 3, "good", "view đẹp", 0, 2),
("DV-0003", "room1", 50, 1000000, 3, 4, 3, "normal", "view đẹp", 0, 1);

-- hợp đồng
create table contract(
contract_id int auto_increment primary key,
contract_start_date date not null,
contract_end_date date not null,
contract_deposit double not null,
contract_total_money double not null,
employee_id int not null,
customer_id int not null,
service_id int not null,
foreign key (employee_id) references employee(employee_id) on delete cascade on update cascade ,
foreign key (customer_id) references customer(customer_id) on delete cascade on update cascade ,    
foreign key (service_id) references service(service_id) on delete cascade on update cascade 
);

insert into contract (contract_start_date, contract_end_date, contract_deposit, contract_total_money, employee_id, customer_id, service_id)
values
('2021-03-10', '2021-03-11', 1000000, 10000000, 1, 1, 1),
('2018-01-11', '2018-02-11', 1000000, 5000000, 2, 2, 2),
('2019-11-10', '2020-02-10', 1000000, 10000000, 3, 3, 3),
('2021-01-20', '2021-01-21', 1000000, 5000000, 4, 4, 1),
('2021-03-09', '2021-04-09', 1000000, 10000000, 5, 5, 2),
('2021-04-30', '2021-04-30', 1000000, 5000000, 6, 6, 4),
('2021-03-10', '2021-04-10', 1000000, 10000000, 7, 1, 2),
('2019-12-10', '2020-02-10', 1000000, 5000000, 1, 2, 3),
('2019-03-10', '2020-03-10', 1000000, 10000000, 2, 3, 4);

-- dịch vụ đi kèm
 create table attach_service (
attach_service_id int auto_increment primary key,
attach_service_name varchar(45) not null,
attach_service_cost int not null,
attach_service_unit int not null,
attach_service_status varchar(45)
);

insert into attach_service (attach_service_name, attach_service_cost, attach_service_unit, attach_service_status)
values
('karaoke', 200000, 1, 'mở'),
('massage', 500000, 1, 'mở'),
('thuê xe', 100000, 1, 'mở');

-- hợp đồng chi tiết
create table contract_detail(
contract_detail_id int auto_increment primary key,
contract_id int ,
attach_service_id int ,
quantity int not null,
foreign key (contract_id) references contract(contract_id)  on delete cascade on update cascade,
foreign key (attach_service_id) references attach_service(attach_service_id)  on delete cascade on update cascade
);

insert into contract_detail (contract_id,attach_service_id,quantity)
values
(1, 1, 2),
(2, 1, 3),
(3, 2, 1),
(4, 3, 5),
(5, 1, 3),
(6, 2, 2),
(7, 3, 2),
(2, 1, 2),
(8, 1, 2);

select * from customer
join customer_type on customer.customer_type_id = customer_type.customer_type_id;

select * from customer join customer_type on customer.customer_type_id = customer_type.customer_type_id where customer_name = "Nguyễn Đình Sơn Trà";

select * from employee 
join position on employee.position_id = position.position_id
join education_degree on employee.education_degree_id = education_degree.education_degree_id
join division on employee.division_id = division.division_id;

select * from employee where employee_id = 1;

select * from service
join rent_type on service.rent_type_id = rent_type.rent_type_id
join service_type on service.service_type_id = service_type.service_type_id;

select * from contract
join customer on contract.customer_id = customer.customer_id
join employee on contract.employee_id = employee.employee_id
join service on contract.service_id = service.service_id;

select * from contract_detail
join attach_service on contract_detail.attach_service_id = attach_service.attach_service_id;

insert into contract_detail (contract_id,attach_service_id,quantity) values (1, 1, 1);

select * , sum(service_cost + quantity * attach_service_cost) as total_money from customer 
join contract on customer.customer_id = contract.customer_id 
join contract_detail on contract.contract_id = contract_detail.contract_id 
join attach_service on contract_detail.attach_service_id = attach_service.attach_service_id
join service on contract.service_id = service.service_id
group by contract_detail_id;

update customer set customer_code = "KH-1010" ,customer_type_id = 1, customer_name = "Nguyễn Đình Sơn Trà", customer_birthday = "1997-11-26", customer_gender = 0, customer_id_card = '100261197', customer_phone = '905261197', customer_email = 'tranguyen@gmail.com', customer_address = 'Đà Nẵng' where customer_id = 1
