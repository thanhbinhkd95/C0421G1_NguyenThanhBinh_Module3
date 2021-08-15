package model.repository.contract_detail;

import model.bean.Contract;
import model.bean.ContractDetail;
import model.repository.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContractDetailRepositoryImlp implements ContractDetailRepository {
    private static final String SELECT_ALL_CONTRACT_DETAIL = "select * from contract_detail join attach_service on contract_detail.attach_service_id = attach_service.attach_service_id";

    @Override
    public List<ContractDetail> findAll() {
        List<ContractDetail> contractDetailList = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        if (connection != null) {
            try {
                statement = connection.prepareStatement(SELECT_ALL_CONTRACT_DETAIL);
                resultSet = statement.executeQuery();
                ContractDetail contractDetail = null;

                while (resultSet.next()) {
                    int id = resultSet.getInt("contract_detail_id");
                    int contractID = resultSet.getInt("contract_id");
                    int attachServiceID = resultSet.getInt("attach_service_id");
                    String attachServiceName = resultSet.getString("attach_service_name");
                    int quantity = resultSet.getInt("quantity");
                    contractDetail = new ContractDetail(id, contractID, attachServiceID, attachServiceName, quantity);
                    contractDetailList.add(contractDetail);
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
        return contractDetailList;
    }

    @Override
    public void save(ContractDetail contractDetail) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;

        if (connection != null) {
            try {
                statement = connection.prepareStatement("insert into contract_detail (contract_id,attach_service_id,quantity) values (?, ?, ?)");
                statement.setInt(1,contractDetail.getContractId());
                statement.setInt(2,contractDetail.getAttachServiceId());
                statement.setInt(3, contractDetail.getQuantity());

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
