package model.service.service;

import model.bean.Employee;
import model.bean.Service;

import java.util.List;
import java.util.Map;

public interface ServiceService {
    List<Service> findAll();

    Map<String, String> save(Service service);
}
