package model.repository.customer;

import model.bean.Customer;
import model.repository.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepositoryImlp implements CustomerRepository {

    private static final String SELECT_ALL_CUSTOMER = "select * from customer join customer_type on customer.customer_type_id = customer_type.customer_type_id";

    private static final String SELECT_ALL_CUSTOMER_USE_SERVICE = "select * , (service_cost + sum(quantity * attach_service_cost)) as total_money from customer " +
            "join contract on customer.customer_id = contract.customer_id " +
            "join contract_detail on contract.contract_id = contract_detail.contract_id " +
            "join attach_service on contract_detail.attach_service_id = attach_service.attach_service_id " +
            "join service on contract.service_id = service.service_id " +
            "group by customer.customer_id";
    @Override
    public List<Customer> findAll() {
        List<Customer> customerList = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        if (connection != null) {
            try {
                statement = connection.prepareStatement(SELECT_ALL_CUSTOMER);
                resultSet = statement.executeQuery();
                Customer customer = null;

                while (resultSet.next()) {
                    int id = resultSet.getInt("customer_id");
                    String code = resultSet.getString("customer_code");
                    int customerTypeId = resultSet.getInt("customer_type_id");
                    String name = resultSet.getString("customer_name");
                    String birthday = resultSet.getString("customer_birthday");
                    int gender = resultSet.getInt("customer_gender");
                    String idCard = resultSet.getString("customer_id_card");
                    String phone = resultSet.getString("customer_phone");
                    String email = resultSet.getString("customer_email");
                    String address = resultSet.getString("customer_address");
                    String customerType = resultSet.getString("customer_type_name");

                    customer = new Customer(id, code, customerTypeId, name, birthday, gender, idCard, phone, email, address, customerType);
                    customerList.add(customer);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }  finally {
                try {
                    statement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                DBConnection.close();
            }
        }
        return customerList;
    }

    @Override
    public void save(Customer customer) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;

        if (connection != null) {
            try {
                statement = connection.prepareStatement("insert into customer(customer_code ,customer_type_id, customer_name, customer_birthday, customer_gender, customer_id_card, customer_phone, customer_email, customer_address) values (?, ?, ?, ?, ?, ?, ?, ?, ?)");
                statement.setString(1,customer.getCode());
                statement.setInt(2,customer.getCustomerTypeId());
                statement.setString(3,customer.getName());
                statement.setString(4,customer.getBirthday());
                statement.setInt(5,customer.getGender());
                statement.setString(6,customer.getIdCard());
                statement.setString(7,customer.getPhone());
                statement.setString(8,customer.getEmail());
                statement.setString(9,customer.getAddress());
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
    public Customer findById(int id) {
        Customer customer = null;
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet =null;

        if (connection != null) {
            try {
                statement = connection.prepareStatement("select * from customer where customer_id = ?");
                statement.setInt(1, id);
                resultSet = statement.executeQuery();

                while (resultSet.next()){
                    String code = resultSet.getString("customer_code");
                    int customerTypeId = resultSet.getInt("customer_type_id");
                    String name = resultSet.getString("customer_name");
                    String birthday = resultSet.getString("customer_birthday");
                    int gender = resultSet.getInt("customer_gender");
                    String idCard = resultSet.getString("customer_id_card");
                    String phone = resultSet.getString("customer_phone");
                    String email = resultSet.getString("customer_email");
                    String address = resultSet.getString("customer_address");
                    customer = new Customer(id, code, customerTypeId, name, birthday, gender, idCard, phone, email,address);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }  finally {
                try {
                    statement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                DBConnection.close();
            }

        }
        return customer;
    }

    @Override
    public void update(Customer customer) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;

        if (connection != null) {
            try {
                statement = connection.prepareStatement("update customer set customer_code = ? ,customer_type_id = ?, customer_name = ?, customer_birthday = ?, customer_gender = ?, customer_id_card = ?, customer_phone = ?, customer_email = ?, customer_address = ? where customer_id = ?");
                statement.setString(1,customer.getCode());
                statement.setInt(2,customer.getCustomerTypeId());
                statement.setString(3,customer.getName());
                statement.setString(4,customer.getBirthday());
                statement.setInt(5,customer.getGender());
                statement.setString(6,customer.getIdCard());
                statement.setString(7,customer.getPhone());
                statement.setString(8,customer.getEmail());
                statement.setString(9,customer.getAddress());
                statement.setInt(10, customer.getId());
                statement.executeUpdate();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }  finally {
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
                statement = connection.prepareStatement("delete from customer where customer_id = ?");
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
    public List<Customer> findByName(String name) {
        List<Customer> customerList = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        if (connection != null) {
            try {
                statement = connection.prepareStatement("select * from customer join customer_type on customer.customer_type_id = customer_type.customer_type_id where customer_name = ?");
                statement.setString(1, name);
                resultSet = statement.executeQuery();
                Customer customer = null;

                while (resultSet.next()){
                    int id = resultSet.getInt("customer_id");
                    String code = resultSet.getString("customer_code");
                    int customerTypeId = resultSet.getInt("customer_type_id");
                    String customer_name = resultSet.getString("customer_name");
                    String birthday = resultSet.getString("customer_birthday");
                    int gender = resultSet.getInt("customer_gender");
                    String idCard = resultSet.getString("customer_id_card");
                    String phone = resultSet.getString("customer_phone");
                    String email = resultSet.getString("customer_email");
                    String address = resultSet.getString("customer_address");
                    String customerType = resultSet.getString("customer_type_name");

                    customer = new Customer(id, code, customerTypeId, customer_name, birthday, gender, idCard, phone, email, address, customerType);
                    customerList.add(customer);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return customerList;
    }

    @Override
    public List<Customer> selectAllCustomerUseService() {
        List<Customer> customerList = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        if (connection != null) {
            try {
                statement = connection.prepareStatement(SELECT_ALL_CUSTOMER_USE_SERVICE);
                resultSet = statement.executeQuery();
                Customer customer = null;

                while (resultSet.next()) {
                    int id = resultSet.getInt("customer_id");
                    String code = resultSet.getString("customer_code");
                    String name = resultSet.getString("customer_name");
                    String idCard = resultSet.getString("customer_id_card");
                    String address = resultSet.getString("customer_address");
                    int contractId = resultSet.getInt("contract_id");
                    int contractDetailId = resultSet.getInt("contract_detail_id");
                    String attachService = resultSet.getString("attach_service_name");
                    double totalMoney = resultSet.getDouble("total_money");

                    customer = new Customer(id, code, name, idCard, address, contractId, contractDetailId, attachService, totalMoney);
                    customerList.add(customer);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }  finally {
                try {
                    statement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                DBConnection.close();
            }
        }
        return customerList;
    }
}
