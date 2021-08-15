package model.repository.employee;

import model.bean.Customer;
import model.bean.Employee;
import model.repository.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepositoryImlp implements EmployeeRepository {
    private static final String SELECT_ALL_EMPLOYEE = "select * from employee " +
            "join position on employee.position_id = position.position_id " +
            "join education_degree on employee.education_degree_id = education_degree.education_degree_id " +
            "join division on employee.division_id = division.division_id";

    private static final String SELECT_ALL_EMPLOYEE_BY_NAME = "select * from employee " +
            "join position on employee.position_id = position.position_id " +
            "join education_degree on employee.education_degree_id = education_degree.education_degree_id " +
            "join division on employee.division_id = division.division_id where employee_name = ?";

    @Override
    public List<Employee> findAll() {
        List<Employee> employeeList = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        if (connection != null) {
            try {
                statement = connection.prepareStatement(SELECT_ALL_EMPLOYEE);
                resultSet = statement.executeQuery();
                Employee employee = null;

                while (resultSet.next()) {
                    int id = resultSet.getInt("employee_id");
                    String name = resultSet.getString("employee_name");
                    String birthday = resultSet.getString("employee_birthday");
                    String idCard = resultSet.getString("employee_id_card");
                    double salary = resultSet.getDouble("employee_salary");
                    String phone = resultSet.getString("employee_phone");
                    String email = resultSet.getString("employee_email");
                    String address = resultSet.getString("employee_address");
                    int positionId = resultSet.getInt("position_id");
                    String position = resultSet.getString("position_name");
                    int educationDegreeId = resultSet.getInt("education_degree_id");
                    String educationDegree = resultSet.getString("education_degree_name");
                    int divisionId = resultSet.getInt("division_id");
                    String division = resultSet.getString("division_name");
                    String username = resultSet.getString("username");

                    employee = new Employee(id, name, birthday, idCard, salary, phone, email, address, positionId, position, educationDegreeId, educationDegree, divisionId, division, username);
                    employeeList.add(employee);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                try {
                    statement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                DBConnection.close();
            }
        }
        return employeeList;
    }

    @Override
    public void save(Employee employee) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;

        if (connection != null) {
            try {
                statement = connection.prepareStatement("insert into employee(employee_name, employee_birthday, employee_id_card, employee_salary, employee_phone, employee_email, employee_address, position_id, education_degree_id, division_id, username ) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
                statement.setString(1, employee.getName());
                statement.setString(2, employee.getBirthday());
                statement.setString(3, employee.getIdCard());
                statement.setDouble(4, employee.getSalary());
                statement.setString(5, employee.getPhone());
                statement.setString(6, employee.getEmail());
                statement.setString(7, employee.getAddress());
                statement.setInt(8, employee.getPositionId());
                statement.setInt(9, employee.getEducationDegreeId());
                statement.setInt(10, employee.getDivisionId());
                statement.setString(11, employee.getUsername());
                statement.executeUpdate();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
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
    public Employee findById(int id) {
        Employee employee = null;
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        if (connection != null) {
            try {
                statement = connection.prepareStatement("select * from employee where employee_id = ?");
                statement.setInt(1, id);
                resultSet = statement.executeQuery();

                while (resultSet.next()) {
                    String name = resultSet.getString("employee_name");
                    String birthday = resultSet.getString("employee_birthday");
                    String idCard = resultSet.getString("employee_id_card");
                    double salary = resultSet.getDouble("employee_salary");
                    String phone = resultSet.getString("employee_phone");
                    String email = resultSet.getString("employee_email");
                    String address = resultSet.getString("employee_address");
                    int positionId = resultSet.getInt("position_id");
                    int educationDegreeId = resultSet.getInt("education_degree_id");
                    int divisionId = resultSet.getInt("division_id");
                    String username = resultSet.getString("username");

                    employee = new Employee(id, name, birthday, idCard, salary, phone, email, address, positionId, educationDegreeId, divisionId, username);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                try {
                    statement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                DBConnection.close();
            }

        }
        return employee;
    }

    @Override
    public void update(Employee employee) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;

        if (connection != null) {
            try {
                statement = connection.prepareStatement("update employee set employee_name = ?, employee_birthday = ?, employee_id_card = ?, employee_salary = ?, employee_phone = ?, employee_email = ?, employee_address = ?, position_id = ?, education_degree_id = ?, division_id = ?, username = ? where employee_id = ?");
                statement.setString(1, employee.getName());
                statement.setString(2, employee.getBirthday());
                statement.setString(3, employee.getIdCard());
                statement.setDouble(4, employee.getSalary());
                statement.setString(5, employee.getPhone());
                statement.setString(6, employee.getEmail());
                statement.setString(7, employee.getAddress());
                statement.setInt(8, employee.getPositionId());
                statement.setInt(9, employee.getEducationDegreeId());
                statement.setInt(10, employee.getDivisionId());
                statement.setString(11, employee.getUsername());
                statement.setInt(12, employee.getId());
                statement.executeUpdate();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
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
    public void remove(int id) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;

        if (connection != null) {
            try {
                statement = connection.prepareStatement("delete from employee where employee_id = ?");
                statement.setInt(1, id);
                statement.executeUpdate();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
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
    public List<Employee> findByName(String name) {
        List<Employee> employeeList = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        if (connection != null) {
            try {
                statement = connection.prepareStatement(SELECT_ALL_EMPLOYEE_BY_NAME);
                statement.setString(1, name);
                resultSet = statement.executeQuery();
                Employee employee = null;

                while (resultSet.next()) {
                    int id = resultSet.getInt("employee_id");
                    String birthday = resultSet.getString("employee_birthday");
                    String idCard = resultSet.getString("employee_id_card");
                    double salary = resultSet.getDouble("employee_salary");
                    String phone = resultSet.getString("employee_phone");
                    String email = resultSet.getString("employee_email");
                    String address = resultSet.getString("employee_address");
                    int positionId = resultSet.getInt("position_id");
                    String position = resultSet.getString("position_name");
                    int educationDegreeId = resultSet.getInt("education_degree_id");
                    String educationDegree = resultSet.getString("education_degree_name");
                    int divisionId = resultSet.getInt("division_id");
                    String division = resultSet.getString("division_name");
                    String username = resultSet.getString("username");

                    employee = new Employee(id, name, birthday, idCard, salary, phone, email, address, positionId, position, educationDegreeId, educationDegree, divisionId, division, username);
                    employeeList.add(employee);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return employeeList;
    }
}
