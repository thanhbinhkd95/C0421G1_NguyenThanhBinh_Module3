create database quan_ly_ban_hang;

use quan_ly_ban_hang;

create table customer(
	customer_id varchar(255) primary key,
    customer_name varchar(255),
    customer_age int
);

create table orderr(
	order_id varchar(255) primary key,
    customer_id varchar(255),
    order_date datetime,
    order_total_price double,
    foreign key(customer_id) references customer(customer_id)
);

create table product(
	product_id varchar(255) primary key,
    product_name varchar(255),
    product_price double
);

create table order_detail(
	order_id varchar(255),
    product_id varchar(255),
    order_detail_qty varchar(255),
    primary key(order_id,product_id),
    foreign key (order_id) references orderr(order_id),
	foreign key (product_id) references product(product_id)
);    



    


    
    
    
    
