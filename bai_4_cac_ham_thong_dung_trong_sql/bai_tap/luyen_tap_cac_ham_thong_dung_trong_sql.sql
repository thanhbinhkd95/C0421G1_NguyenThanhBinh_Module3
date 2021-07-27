use quan_ly_sinh_vien;

-- Hiển thị tất cả các thông tin môn học (bảng subject) có credit lớn nhất.--
select * 
from subject
where credit = (select max(credit) from subject);

-- Hiển thị các thông tin môn học có điểm thi lớn nhất.--
select subject.sub_id, sub_name, credit,Status,mark 
from subject
inner join mark on subject.sub_id = mark.mark_id
where mark = (select max(mark) from mark);

-- Hiển thị các thông tin sinh viên và điểm trung bình của mỗi sinh viên, xếp hạng theo thứ tự điểm giảm dần--
select student.student_id, student_name, address, phone, status, class_id, avg(mark) as 'average'
from student
inner join mark on student.student_id = mark.student_id
group by student.student_id
order by average desc;
