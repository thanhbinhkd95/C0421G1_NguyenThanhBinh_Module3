package model.repository.contract;

import model.bean.Contract;
import model.bean.Service;
import model.repository.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContractRepositoryImlp implements ContractRepository {
    private static final String SELECT_ALL_CONTRACT = "select * from contract " +
            "join customer on contract.customer_id = customer.customer_id " +
            "join employee on contract.employee_id = employee.employee_id " +
            "join service on contract.service_id = service.service_id";

    @Override
    public List<Contract> findAll() {
        List<Contract> contractList = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        if (connection != null) {
            try {
                statement = connection.prepareStatement(SELECT_ALL_CONTRACT);
                resultSet = statement.executeQuery();
                Contract contract = null;

                while (resultSet.next()) {
                    int id = resultSet.getInt("contract_id");
                    String starDate = resultSet.getString("contract_start_date");
                    String endDate = resultSet.getString("contract_end_date");
                    double deposit = resultSet.getDouble("contract_deposit");
                    double totalMoney = resultSet.getDouble("contract_total_money");
                    int employeeId = resultSet.getInt("employee_id");
                    String employeeName = resultSet.getString("employee_name");
                    int customerId = resultSet.getInt("customer_id");
                    String customerName = resultSet.getString("customer_name");
                    int serviceId = resultSet.getInt("service_id");
                    String serviceName = resultSet.getString("service_name");

                    contract = new Contract(id, starDate, endDate, deposit, totalMoney, employeeId, employeeName, customerId, customerName, serviceId, serviceName);
                    contractList.add(contract);
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
        return contractList;
    }

    @Override
    public void save(Contract contract) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;

        if (connection != null) {
            try {
                statement = connection.prepareStatement("insert into contract (contract_start_date, contract_end_date, contract_deposit, contract_total_money, employee_id, customer_id, service_id) values (?, ?, ?, ?, ?, ?, ?)");
                statement.setString(1,contract.getStarDate());
                statement.setString(2,contract.getEndDate());
                statement.setDouble(3, contract.getDeposit());
                statement.setDouble(4, contract.getTotalMoney());
                statement.setInt(5, contract.getEmployeeId());
                statement.setInt(6, contract.getCustomerId());
                statement.setInt(7, contract.getServiceId());
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
}
