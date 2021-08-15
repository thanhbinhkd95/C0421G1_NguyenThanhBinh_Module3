package model.service.contract;

import model.bean.Contract;
import model.bean.Service;

import java.util.List;
import java.util.Map;

public interface ContractService {
    List<Contract> findAll();

    Map<String, String> save(Contract contract);
}
