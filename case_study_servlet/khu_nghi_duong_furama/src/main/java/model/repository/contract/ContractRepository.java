package model.repository.contract;

import model.bean.Contract;
import model.bean.Service;

import java.util.List;

public interface ContractRepository {
    List<Contract> findAll();

    void save(Contract contract);
}
