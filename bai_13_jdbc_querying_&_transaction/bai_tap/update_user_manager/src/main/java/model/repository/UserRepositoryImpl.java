package model.repository;

import model.bean.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl implements UserRepository {

    private static final String INSERT_USERS_SQL = "INSERT INTO users(name, email, country) VALUE(?, ?, ?)";
//    private static final String SELECT_FROM_USERS = "select * from users";
//    private static final String DELETE_FROM_USERS_WHERE_ID = "delete from users where id = ?";
//    private static final String UPDATE_USERS_SQL = "update users set name = ?,email= ?, country =? where id = ?";
    private static final String SELECT_FROM_USERS_WHERE_COUNTRY = "select * from users where country = ?";
    private static final String SORT_BY_NAME = "select * ,(substring_index(name ,\" \", -1)) as \"first_name\" from users order by first_name";
    private static final String CALL_SELECT_ALL = "call select_all()";
    private static final String CALL_UPDATE_USER = "call update_user(?, ?, ?, ?)";
    private static final String SELECT_FROM_USERS_WHERE_ID = "select * from users where id = ?";
    private static final String CALL_DELETE_USER = "call delete_user(?)";

    @Override
    public void insertUser(User user){
        Connection connection = DBConnection.getConnection();

        PreparedStatement statement = null;

        if(connection != null) {
            try {
                statement = connection.prepareStatement(INSERT_USERS_SQL);
                statement.setString(1, user.getName());
                statement.setString(2, user.getEmail());
                statement.setString(3, user.getCountry());

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
    public User selectUser(int inputId) {
        User user = null;
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if (connection != null) {
            try {
                statement = connection.prepareStatement(SELECT_FROM_USERS_WHERE_ID);
                statement.setInt(1, inputId);
                resultSet = statement.executeQuery();

                while (resultSet.next()) {
                    String name = resultSet.getString("name");
                    String email = resultSet.getString("email");
                    String country = resultSet.getString("country");
                    user = new User(inputId, name, email, country);
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
        return user;
    }

    //Gọi Stored Procedures từ JDBC sử dụng CallableStatement cho chức năng hiển thị danh sách users
    @Override
    public List<User> selectAllUsers() {
        List<User> userList = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        CallableStatement statement = null;
        ResultSet resultSet = null;

        if (connection != null) {
            try {
                statement = connection.prepareCall(CALL_SELECT_ALL);
                resultSet = statement.executeQuery();
                User user = null;

                while (resultSet.next()){
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    String email = resultSet.getString("email");
                    String country = resultSet.getString("country");

                    user = new User(id, name, email, country);
                    userList.add(user);
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
        return userList;
    }

    //Gọi Stored Procedures từ JDBC sử dụng CallableStatement cho chức năng xoá user
    @Override
    public void deleteUser(int id){
        Connection connection = DBConnection.getConnection();
        CallableStatement statement = null;
        if (connection != null) {
            try {
                statement = connection.prepareCall(CALL_DELETE_USER);
                statement.setInt(1, id);
                statement.executeUpdate();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    //Gọi Stored Procedures từ JDBC sử dụng CallableStatement cho chức năng sửa thông tin user
    @Override
    public void updateUser(User user) {
        Connection connection = DBConnection.getConnection();
        CallableStatement statement = null;
        if (connection != null) {
            try {
                statement = connection.prepareCall(CALL_UPDATE_USER);
                statement.setString(1, user.getName());
                statement.setString(2, user.getEmail());
                statement.setString(3, user.getCountry());
                statement.setInt(4, user.getId());
                statement.executeUpdate();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    @Override
    public List<User> findByCountry(String inputName) throws SQLException {
        List<User> userList = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet =null;

        if (connection != null) {
            try {
                statement = connection.prepareStatement(SELECT_FROM_USERS_WHERE_COUNTRY);
                statement.setString(1, inputName);
                resultSet = statement.executeQuery();
                User user = null;

                while (resultSet.next()){
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    String email = resultSet.getString("email");
                    String country = resultSet.getString("country");

                    user = new User(id, name, email, country);
                    userList.add(user);
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
        return userList;
    }

    @Override
    public List<User> sortByName() throws SQLException {
        List<User> userList = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet =null;

        if (connection != null) {
            try {
                statement = connection.prepareStatement(SORT_BY_NAME);
                resultSet = statement.executeQuery();
                User user = null;

                while (resultSet.next()){
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    String email = resultSet.getString("email");
                    String country = resultSet.getString("country");

                    user = new User(id, name, email, country);
                    userList.add(user);
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
        return userList;
    }

    @Override
    public void addUserTransaction(User user, int[] permisions) {

        Connection conn = null;

        // for insert a new user

        PreparedStatement pstmt = null;

        // for assign permision to user

        PreparedStatement pstmtAssignment = null;

        // for getting user id

        ResultSet rs = null;

        try {

            conn = DBConnection.getConnection();

            conn.setAutoCommit(false);

            pstmt = conn.prepareStatement(INSERT_USERS_SQL, Statement.RETURN_GENERATED_KEYS);

            pstmt.setString(1, user.getName());

            pstmt.setString(2, user.getEmail());

            pstmt.setString(3, user.getCountry());

            int rowAffected = pstmt.executeUpdate();


            rs = pstmt.getGeneratedKeys();

            int userId = 0;

            if (rs.next())

                userId = rs.getInt(1);



            if (rowAffected != 1) {


                String sqlPivot = "INSERT INTO user_permision(user_id,permision_id) "

                        + "VALUES(?,?)";

                pstmtAssignment = conn.prepareStatement(sqlPivot);

                for (int permisionId : permisions) {

                    pstmtAssignment.setInt(1, userId);

                    pstmtAssignment.setInt(2, permisionId);

                    pstmtAssignment.executeUpdate();

                }

                conn.commit();

            } else {

                conn.rollback();

            }

        } catch (SQLException ex) {


            try {

                if (conn != null)

                    conn.rollback();

            } catch (SQLException e) {

                System.out.println(e.getMessage());

            }

            System.out.println(ex.getMessage());

        } finally {

            try {

                if (rs != null) rs.close();

                if (pstmt != null) pstmt.close();

                if (pstmtAssignment != null) pstmtAssignment.close();

                if (conn != null) conn.close();

            } catch (SQLException e) {

                System.out.println(e.getMessage());

            }

        }

    }
}
