package model.service.employee;

import model.bean.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeService {
    List<Employee> findAll();

    Map<String, String> save(Employee employee);

    Employee findById(int id);

    Map<String, String> update(Employee employee);

    void remove(int id);

    List<Employee> findByName(String name);
}
