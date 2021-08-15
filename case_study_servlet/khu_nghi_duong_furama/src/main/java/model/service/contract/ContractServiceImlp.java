package model.service.contract;

import model.bean.Contract;
import model.bean.Service;
import model.repository.contract.ContractRepository;
import model.repository.contract.ContractRepositoryImlp;
import model.service.common.Validate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContractServiceImlp implements ContractService {
    ContractRepository repository = new ContractRepositoryImlp();
    @Override
    public List<Contract> findAll() {
        return repository.findAll();
    }

    @Override
    public Map<String, String> save(Contract contract) {
        Map<String, String> mapMessage = new HashMap<>();
        if (Validate.validateAmount(contract.getDeposit()) != null
                || Validate.validateAmount(contract.getTotalMoney()) != null){
            mapMessage.put("deposit", Validate.validateAmount(contract.getDeposit()));
            mapMessage.put("totalMoney", Validate.validateAmount(contract.getTotalMoney()));

        }else {
            repository.save(contract);
        }
        return mapMessage;
    }
}
