package model.repository.service;

import model.bean.Employee;
import model.bean.Service;
import model.repository.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceRepositoryImlp implements ServiceRepository {
    private static final String SELECT_ALL_SERVICE = "select * from service " +
            "join rent_type on service.rent_type_id = rent_type.rent_type_id " +
            "join service_type on service.service_type_id = service_type.service_type_id";
    @Override
    public List<Service> findAll() {
        List<Service> serviceList = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        if (connection != null) {
            try {
                statement = connection.prepareStatement(SELECT_ALL_SERVICE);
                resultSet = statement.executeQuery();
                Service service = null;

                while (resultSet.next()) {
                    int id = resultSet.getInt("service_id");
                    String code = resultSet.getString("service_code");
                    String name = resultSet.getString("service_name");
                    int area = resultSet.getInt("service_area");
                    double cost = resultSet.getDouble("service_cost");
                    int maxPeople = resultSet.getInt("service_max_people");
                    int rentType_id = resultSet.getInt("rent_type_id");
                    String rentType = resultSet.getString("rent_type_name");
                    int serviceTypeId = resultSet.getInt("service_type_id");
                    String serviceType = resultSet.getString("service_type_name");
                    String standardRoom = resultSet.getString("standard_room");
                    String description = resultSet.getString("description_other_convenience");
                    double poolArea = resultSet.getDouble("pool_area");
                    int numberFloor  = resultSet.getInt("number_of_floors");
                    service = new Service(id, code, name, area, cost, maxPeople, rentType_id, rentType,serviceTypeId,serviceType,standardRoom, description, poolArea, numberFloor);
                    serviceList.add(service);
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
        return serviceList;
    }

    @Override
    public void save(Service service) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;

        if (connection != null) {
            try {
                statement = connection.prepareStatement("insert into service(service_code, service_name, service_area, service_cost, service_max_people, rent_type_id, service_type_id, standard_room, description_other_convenience, pool_area, number_of_floors) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
                statement.setString(1,service.getCode());
                statement.setString(2,service.getName());
                statement.setInt(3, service.getArea());
                statement.setDouble(4, service.getCost());
                statement.setInt(5, service.getMaxPeople());
                statement.setInt(6, service.getRentTypeId());
                statement.setInt(7, service.getServiceTypeId());
                statement.setString(8, service.getStandardRoom());
                statement.setString(9, service.getDescription());
                statement.setDouble(10, service.getPoolArea());
                statement.setInt(11, service.getNumberFloor());
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
