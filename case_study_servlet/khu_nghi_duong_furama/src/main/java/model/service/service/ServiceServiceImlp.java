package model.service.service;

import model.bean.Service;
import model.repository.service.ServiceRepository;
import model.repository.service.ServiceRepositoryImlp;
import model.service.common.Validate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ServiceServiceImlp implements  ServiceService{
    ServiceRepository repository = new ServiceRepositoryImlp();
    @Override
    public List<Service> findAll() {
        return repository.findAll();
    }

    @Override
    public Map<String, String> save(Service service) {
        Map<String, String> mapMessage = new HashMap<>();
        if ( Validate.validateServiceCode(service.getCode()) != null
                ||Validate.validateNumber(service.getArea()) != null
                || Validate.validateAmount(service.getCost()) != null
                || Validate.validateNumber(service.getMaxPeople()) != null
                || Validate.validateAmount(service.getPoolArea()) != null
                || Validate.validateNumber(service.getNumberFloor()) != null) {

            mapMessage.put("code",  Validate.validateServiceCode(service.getCode()));
            mapMessage.put("area", Validate.validateNumber(service.getArea()));
            mapMessage.put("cost", Validate.validateAmount(service.getCost()));
            mapMessage.put("maxPeople", Validate.validateNumber(service.getMaxPeople()));
            mapMessage.put("poolArea", Validate.validateAmount(service.getPoolArea()));
            mapMessage.put("numberFloor", Validate.validateNumber(service.getNumberFloor()));

        }else {
            repository.save(service);
        }
        return mapMessage;
    }
}
