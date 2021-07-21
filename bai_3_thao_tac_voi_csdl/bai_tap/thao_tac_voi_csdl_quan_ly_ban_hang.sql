use quan_ly_ban_hang;

insert into customer
values
(1, "Minh Quan", 10),
(2, "Ngoc Anh", 20),
(3, "Hong Ha", 50);

RENAME TABLE  `orderr` TO  `order`;

insert into `order`(order_id,customer_id,order_date)
values
(1, 1, '2006-03-21 00:00:00'),
(2, 2, '2006-03-23 00:00:00'),
(3, 1, '2006-03-16 00:00:00');

insert into product
values
(1, "May Giat", 3),
(2, "Tu Lanh", 5),
(3, "Dieu Hoa", 7),
(4, "Quat", 1),
(5, "Bep Dien", 2);

insert into order_detail
values
(1, 1, 3),
(1, 3, 7),
(1, 4, 2),
(2, 1, 1),
(3, 1, 8),
(2, 5, 4),
(2, 3, 3);

-- Hiển thị các thông tin  gồm oID, oDate, oPrice của tất cả các hóa đơn trong bảng Order--
select order_id, order_date, order_total_price
from `order`;

-- Hiển thị danh sách các khách hàng đã mua hàng, và danh sách sản phẩm được mua bởi các khách--
select customer_name, product.product_name
from customer
inner join `order` on customer.customer_id = `order`.customer_id
inner join order_detail on `order`.order_id = order_detail.order_id
inner join product on order_detail.product_id = product.product_id;

-- Hiển thị tên những khách hàng không mua bất kỳ một sản phẩm nào--
select customer_name 
from customer 
where customer_id not in (select `order`.customer_id from `order`);

-- Hiển thị mã hóa đơn, ngày bán và giá tiền của từng hóa đơn (giá một hóa đơn được tính bằng tổng giá bán của từng loại mặt hàng xuất hiện trong hóa đơn. Giá bán của từng loại được tính = odQTY*pPrice)--
select `order`.order_id, order_date, sum(order_detail.order_detail_qty * product.product_price)
from `order`
inner join order_detail on `order`.order_id = order_detail.order_id
inner join product on order_detail.product_id = product.product_id
group by `order`.order_id;