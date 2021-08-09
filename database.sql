CREATE DATABASE student_jdbc;
USE student_jdbc;

CREATE TABLE student(
id INT AUTO_INCREMENT PRIMARY KEY,
`name` VARCHAR(50),
gender INT, 
`point` INT, 
image VARCHAR(255)
);

INSERT INTO student(name, gender, point, image) 
VALUES("Nguyen Van A", 1, 50, "avatar_1.jpg"),
("Nguyen Van B", 0, 70, "avatar_2.jpg"),
("Nguyen Van C", 2, 90, "avatar_3.jpg"),
("Nguyen Van D", 1, 100, "avatar_4.jpg");