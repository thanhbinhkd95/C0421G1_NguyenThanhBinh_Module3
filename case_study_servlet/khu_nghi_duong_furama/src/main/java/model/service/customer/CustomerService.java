package model.service.customer;

import model.bean.Customer;

import java.util.List;
import java.util.Map;

public interface CustomerService {
    List<Customer> findAll();

    Map<String, String> save(Customer customer);

    Customer findById(int id);

    Map<String, String>  update(Customer customer);

    void remove(int id);

    List<Customer> findByName(String name);

    List<Customer> selectAllCustomerUseService();
}
