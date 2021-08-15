package model.repository.service;

import model.bean.Employee;
import model.bean.Service;

import java.util.List;

public interface ServiceRepository {
    List<Service> findAll();

    void save(Service service);
}
