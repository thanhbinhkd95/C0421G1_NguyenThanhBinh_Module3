package model.service.contract_detail;

import model.bean.ContractDetail;

import java.util.List;

public interface ContractDetailService {
    List<ContractDetail> findAll();

    void save(ContractDetail contractDetail);
}
