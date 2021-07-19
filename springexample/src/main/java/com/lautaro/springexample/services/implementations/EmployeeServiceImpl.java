package com.lautaro.springexample.services.implementations;

import com.lautaro.springexample.models.Employee;
import com.lautaro.springexample.services.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Override
    public List<Employee> findAll() {
        return null;
    }

    @Override
    public List<Employee> findActives() {
        return null;
    }

    @Override
    public Employee save(Employee object) {
        return null;
    }

    @Override
    public Employee findByID(String s) {
        return null;
    }

    @Override
    public Employee create(Employee object) {
        return null;
    }

    @Override
    public Employee update(Employee object) {
        return null;
    }

    @Override
    public void deleteById(String s) {

    }

    @Override
    public List<Employee> findByBoss(String bossId) {
        return null;
    }
}
