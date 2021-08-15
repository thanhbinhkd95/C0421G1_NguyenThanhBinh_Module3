package model.service.employee;

import model.bean.Employee;
import model.repository.employee.EmployeeRepository;
import model.repository.employee.EmployeeRepositoryImlp;
import model.service.common.Validate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeServiceImlp implements EmployeeService {
    EmployeeRepository repository = new EmployeeRepositoryImlp();

    @Override
    public List<Employee> findAll() {
        return repository.findAll();
    }

    @Override
    public Map<String, String> save(Employee employee) {
        Map<String, String> mapMessage = new HashMap<>();
        if (Validate.validateEmail(employee.getEmail()) != null
                || Validate.validatePhoneNumber(employee.getPhone()) != null
                || Validate.validateIdCard(employee.getIdCard()) != null
                || Validate.validateAmount(employee.getSalary()) != null){

            mapMessage.put("email", Validate.validateEmail(employee.getEmail()));
            mapMessage.put("phone", Validate.validatePhoneNumber(employee.getPhone()));
            mapMessage.put("idCard", Validate.validateIdCard(employee.getIdCard()));
            mapMessage.put("salary", Validate.validateAmount(employee.getSalary()));
        }else {
            repository.save(employee);
        }
        return mapMessage;
    }

    @Override
    public Employee findById(int id) {
        return repository.findById(id);
    }

    @Override
    public Map<String, String> update(Employee employee) {
        Map<String, String> mapMessage = new HashMap<>();
        if (Validate.validateEmail(employee.getEmail()) != null
                || Validate.validatePhoneNumber(employee.getPhone()) != null
                || Validate.validateIdCard(employee.getIdCard()) != null
                || Validate.validateAmount(employee.getSalary()) != null){

            mapMessage.put("email", Validate.validateEmail(employee.getEmail()));
            mapMessage.put("phone", Validate.validatePhoneNumber(employee.getPhone()));
            mapMessage.put("idCard", Validate.validateIdCard(employee.getIdCard()));
            mapMessage.put("salary", Validate.validateAmount(employee.getSalary()));
        }else {
            repository.update(employee);
        }
        return mapMessage;
    }

    @Override
    public void remove(int id) {
        repository.remove(id);
    }

    @Override
    public List<Employee> findByName(String name) {
        return repository.findByName(name);
    }
}
