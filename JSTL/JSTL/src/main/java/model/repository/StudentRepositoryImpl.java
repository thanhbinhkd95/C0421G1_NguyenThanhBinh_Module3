package model.repository;

import model.bean.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentRepositoryImpl implements StudentRepository{

//    private static Map<Integer, Student> studentList;
//
//    static {
//        studentList = new HashMap<>();
//        studentList.put(1, new Student(1, "Nguyen Van A", 1, 50, "avatar_1.jpg"));
//        studentList.put(2, new Student(2, "Nguyen Van B", 0, 70, "avatar_2.jpg"));
//        studentList.put(3, new Student(3, "Nguyen Van C", 2, 90, "avatar_3.jpg"));
//        studentList.put(4, new Student(4, "Nguyen Van D", 1, 100, "avatar_4.jpg"));
//    }


    @Override
    public List<Student> findAll() {
        List<Student> studentList = new ArrayList<>();
        Connection connection = DBConnection.getConnection();

//        Statement statement = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        if(connection != null){
            try {
//                statement = connection.createStatement();
//                resultSet = statement.executeQuery("select * from student");
//                resultSet = statement.executeQuery("INSERT INTO student(name, gender, point, image) VALUE(" + "Hung" + 10 + "");

                statement = connection.prepareStatement("select * from student");
                resultSet = statement.executeQuery();

                Student student = null;
                while (resultSet.next()){
                    int id = resultSet.getInt(1);
                    String name = resultSet.getString("nameStudent");
                    int gender = resultSet.getInt("gender");
                    int point = resultSet.getInt("point");
                    String image = resultSet.getString("image");

                    student = new Student(id, name, gender, point, image);
                    studentList.add(student);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                try {
                    resultSet.close();
                    statement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                DBConnection.close();
            }
        }
        return studentList;
    }

    @Override
    public void save(Student student) {
        Connection connection = DBConnection.getConnection();

        PreparedStatement statement = null;

        if(connection != null) {
            try {
                statement = connection.prepareStatement("INSERT INTO student(name, gender, point, image) VALUE(?, ?, ?)");
                statement.setString(1, student.getName());
                statement.setInt(2, student.getGender());
                statement.setInt(3, student.getPoint());
                statement.setString(4, student.getImage());

                statement.executeUpdate();

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }finally {
                try {
                    statement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                DBConnection.close();
            }
        }
    }

    @Override
    public Student findById(int id) {
        return  null;
    }

    @Override
    public void remove(int id) {

    }
}
