package model.repository.customer;

import model.bean.Customer;

import java.util.List;

public interface CustomerRepository {
    List<Customer> findAll();

    void save(Customer customer);

    Customer findById(int id);

    void update(Customer customer);

    void remove(int id);

    List<Customer> findByName(String name);

    List<Customer> selectAllCustomerUseService();
}
