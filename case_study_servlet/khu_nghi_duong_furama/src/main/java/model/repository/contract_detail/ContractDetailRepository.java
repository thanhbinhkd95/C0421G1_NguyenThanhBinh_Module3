package model.repository.contract_detail;

import model.bean.Contract;
import model.bean.ContractDetail;

import java.util.List;

public interface ContractDetailRepository {
    List<ContractDetail> findAll();

    void save(ContractDetail contractDetail);
}
