use quan_ly_khu_nghi_duong_furama;

insert into vi_tri
values
(1,'Giám đốc'),
(2,'Phó giám đốc'),
(3,'Quản Lý'),
(4,'Trưởng Phòng'),
(5,'Trưởng Nhóm'),
(6,'Nhân viên');

insert into trinh_do
values
(1,'Đại học'),
(2,'Cao đẳng'),
(3,'Trung cấp'),
(4,'Khác');

insert into bo_phan
values
(1,'Lễ Tân'),
(2,'Buồng Phòng'),
(3,'Ẩm thực'),
(4,'Kinh doanh'),
(5,'Hành chính - Nhân sự'),
(6,'Tài Chính - Kế Toán'),
(7,'Kỹ Thuật'),
(8,'An ninh');

insert into nhan_vien
values
(1,'Nguyễn Văn An',  1, 1, 4, '1990-01-15', 111453211, 30000000, 0905150190, 'nguyenan@gmail.com','Đà Nẵng'),
(2,'Nguyễn Văn Bình', 6, 2, 7, '1993-02-22', 112123456, 6000000, 0905220293, 'nguyenbinh@gmail.com','Quảng Nam'),
(3,'Hồ Thị Hoa', 3, 1, 3, '1995-11-04', 113980765, 10000000, 0935041194, 'hoaho@gmail.com','Huế'),
(4,'Trần Văn Đạt', 4, 1, 6, '1992-09-26', 114123165, 8000000, 0770260992, 'trandat@gmail.com','Nghệ An'),
(5,'Lê Thị Huyền', 5, 2, 2, '1996-05-05', 115742178, 6000000, 0905050596, 'huyenle@gmail.com','Quảng Trị'),
(6,'Phạm Thị Phương', 6, 3, 1, '1994-12-19', 116414141, 5000000, 0905191294, 'phuongpham@gmail.com','Quảnh Bình'),
(7,'Lê Văn Khương', 6, 3, 8, '1991-09-02', 117776527, 5000000, 0905020991, 'khuongle@gmail.com','Nha Trang'),
(8,'Huỳnh Thị Cẩm Tú', 2, 1, 5, '1997-12-10', 118453211, 20000000, 0905101297, 'camtu@gmail.com','Thanh Hoá'),
(9,'Nguyễn Văn C', 6, 3, 1, '1997-12-10', 118453211, 20000000, 0905101297, 'nguyenc@gmail.com','Quảng Bình');

insert into loai_khach
values
(1 ,'Diamond'),
(2 ,'Platinium'),
(3 ,'Gold'),
(4 ,'Silver'),
(5 ,'Member');

insert into khach_hang
values 
(1, 1, 'Nguyễn Đình Sơn Trà', '1997-11-26', 100261197, 0905261197, 'tranguyen@gmail.com', 'Đà Nẵng'),
(2, 1, 'Trương Quốc Pháp', '1990-10-20', 100201090, 0905201090, 'phaptruong@gmail.com', 'Quảng Ngãi'),
(3, 2, 'Nguyễn Thị Nhung', '1995-08-30', 100300895, 0905300895, 'nhungnguyen@gmail.com', 'Nghệ An'),
(4, 2, 'Nguyễn Thị Bích Thuý', '1996-02-28', 100280296, 0905280296, 'thuynguyen@gmail.com', 'Quảng Trị'),
(5, 1, 'Nguyễn Thanh Bình', '1994-05-01', 100010594, 0905010594, 'binhnguyen@gmail.com', 'Quảng Nam'),
(6, 5, 'Huỳnh Thị Bảo Trân', '1998-09-02', 100020998, 0905020998, 'tranhuynh@gmail.com', 'Huế'),
(7, 2, 'Nguyễn Văn Lý Huỳnh', '1993-07-02', 100020793, 0905020793, 'huynhnguyen@gmail.com', 'Vinh'),
(8, 1, 'Nguyễn Thị Nhung', '1996-10-20', 100201096, 0905201096, 'nguyennhung@gmail.com', 'Vinh');

insert into kieu_thue
values
(1, 'ngày', 1000000),
(2, 'tháng', 20000000),
(3, 'năm', 300000000);

insert into loai_dich_vu
values
(1, 'villa'),
(2, 'house'),
(3, 'room');

insert into dich_vu
values
(1, 'villa1', 300, 10, 20, 5000000, 1, 1, 'còn phòng'),
(2, 'house1', 200, 5, 10, 2000000, 2, 2, 'còn phòng'),
(3, 'room1', 100, 3, 3, 1000000, 3, 3, 'còn phòng');

insert into hop_dong (id_hop_dong, id_nhan_vien, id_khach_hang, id_dich_vu, ngay_lam_hop_dong, ngay_ket_thuc, tien_dat_coc)
values
(1, 1, 1, 1, '2021-03-10', '2021-03-11', 20000000),
(2, 2, 2, 2, '2018-01-11', '2018-02-11', 10000000),
(3, 3, 3, 3, '2019-11-10', '2020-02-10', 15000000),
(4, 4, 4, 1, '2021-01-20', '2021-01-21', 5000000),
(5, 5, 5, 2, '2021-03-09', '2021-04-09', 20000000),
(6, 6, 6, 3, '2021-04-30', '2021-04-30', 7000000),
(7, 7, 1, 2, '2021-03-10', '2021-04-10', 20000000),
(8, 1, 2, 3, '2019-12-10', '2020-02-10', 15000000),
(9, 2, 3, 1, '2019-03-10', '2020-03-10', 5000000);

insert into dich_vu_di_kem
values
(1, 'karaoke', 200000, 1, 'mở'),
(2, 'massage', 500000, 1, 'mở'),
(3, 'thuê xe', 100000, 1, 'mở');

insert into hop_dong_chi_tiet
values
(1, 1, 1, 2),
(2, 2, 1, 3),
(3, 3, 2, 1),
(4, 4, 3, 5),
(5, 5, 1, 3),
(6, 6, 2, 2),
(7, 7, 3, 2),
(8, 2, 1, 2),
(9, 8, 1, 2);




