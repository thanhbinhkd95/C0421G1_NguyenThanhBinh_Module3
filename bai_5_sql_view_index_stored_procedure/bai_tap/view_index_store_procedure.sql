create database demo;

use demo;

create table products(
id int primary key,
product_code varchar(45),
product_name varchar(45),
product_price int,
product_amount int,
product_description varchar(45),
product_status varchar(45)
);

insert into products
values
(1, 'p-001', 'Iphone', 20000000, 10, 'Đây là điện thoại Iphone', 'còn hàng'),
(2, 'p-002', 'Samsung', 15000000, 8, 'Đây là điện thoại Samsung', 'còn hàng'),
(3, 'p-003', 'Nokia', 5000000, 5, 'Đây là điện thoại Nokia', 'còn hàng'),
(4, 'p-004', 'Oppo', 7000000, 7, 'Đây là điện thoại Oppo', 'còn hàng');

-- Tạo Unique Index trên bảng Products (sử dụng cột productCode để tạo chỉ mục)--
create unique index unique_products
ON products (product_code);

explain select * from products 
where product_code = 'p-003'; 

-- Tạo Composite Index trên bảng Products (sử dụng 2 cột productName và productPrice)--
create index index_products
ON products(product_name, product_price);

explain select * from products 
where product_name = 'Samsung' or product_name = 'Oppo';

-- Tạo view lấy về các thông tin: productCode, productName, productPrice, productStatus từ bảng products.--
create view view_products as
select product_code, product_name, product_price, product_status
from  products;

-- Tiến hành sửa đổi view--
update view_products
set product_status = 'hết hàng'
where product_name = 'Samsung';

-- Tiến hành xoá view--
drop view view_products;

-- Tạo store procedure lấy tất cả thông tin của tất cả các sản phẩm trong bảng product--
delimiter //
create procedure find_all_products()
begin
select * from products;
end //
delimiter ;
call find_all_products();
 
 -- Tạo store procedure thêm một sản phẩm mới--
delimiter //
create procedure add_products()
begin
insert into Products
values
(5, 'p-005', 'Xiaomi', 8000000, 6, 'Đây là điện thoại Xiaomi', 'còn hàng');
end //
delimiter ;
call add_products();

-- Tạo store procedure sửa thông tin sản phẩm theo id--
delimiter //
create procedure edit_products(in input_id int, in input_name varchar(45))
begin
update products
set product_name = input_name
where id = input_id;
end //
delimiter ;
call edit_products(1, 'Iphone X');

-- Tạo store procedure xoá sản phẩm theo id
delimiter //
create procedure delete_products(in input_id int)
begin
delete  from products
where id = input_id;
end //
delimiter ;
call delete_products(3);



