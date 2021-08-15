package model.service.customer;

import model.bean.Customer;
import model.repository.customer.CustomerRepository;
import model.repository.customer.CustomerRepositoryImlp;
import model.service.common.Validate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerServiceImlp implements CustomerService {

    CustomerRepository repository = new CustomerRepositoryImlp();

    @Override
    public List<Customer> findAll() {
        return repository.findAll();
    }

    @Override
    public Map<String, String> save(Customer customer) {
        Map<String, String> mapMessage = new HashMap<>();
        if (Validate.validateCustomerCode(customer.getCode()) != null
                || Validate.validateEmail(customer.getEmail()) != null
                || Validate.validatePhoneNumber(customer.getPhone()) != null
                || Validate.validateIdCard(customer.getIdCard()) != null){

            mapMessage.put("customerCode", Validate.validateCustomerCode(customer.getCode()));
            mapMessage.put("email", Validate.validateEmail(customer.getEmail()));
            mapMessage.put("phone", Validate.validatePhoneNumber(customer.getPhone()));
            mapMessage.put("idCard", Validate.validateIdCard(customer.getIdCard()));
        }else {
            repository.save(customer);
        }
        return mapMessage;
    }

    @Override
    public Customer findById(int id) {
        return repository.findById(id);
    }

    @Override
    public Map<String, String>  update(Customer customer) {
        Map<String, String> mapMessage = new HashMap<>();
        if (Validate.validateCustomerCode(customer.getCode()) != null
                || Validate.validateEmail(customer.getEmail()) != null
                || Validate.validatePhoneNumber(customer.getPhone()) != null
                || Validate.validateIdCard(customer.getIdCard()) != null){

            mapMessage.put("customerCode", Validate.validateCustomerCode(customer.getCode()));
            mapMessage.put("email", Validate.validateEmail(customer.getEmail()));
            mapMessage.put("phone", Validate.validatePhoneNumber(customer.getPhone()));
            mapMessage.put("idCard", Validate.validateIdCard(customer.getIdCard()));
        } else {
            repository.update(customer);
        }

        return mapMessage;
    }

    @Override
    public void remove(int id) {
        repository.remove(id);
    }

    @Override
    public List<Customer> findByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public List<Customer> selectAllCustomerUseService() {
        return repository.selectAllCustomerUseService();
    }
}
