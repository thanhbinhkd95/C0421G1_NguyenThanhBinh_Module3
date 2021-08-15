package model.service.contract_detail;

import model.bean.ContractDetail;
import model.repository.contract_detail.ContractDetailRepository;
import model.repository.contract_detail.ContractDetailRepositoryImlp;

import java.util.List;

public class ContractDetailServiceImlp implements ContractDetailService {
    ContractDetailRepository repository = new ContractDetailRepositoryImlp();
    @Override
    public List<ContractDetail> findAll() {
        return repository.findAll();
    }

    @Override
    public void save(ContractDetail contractDetail) {
        repository.save(contractDetail);
    }
}
