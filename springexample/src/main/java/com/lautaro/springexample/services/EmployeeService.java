package com.lautaro.springexample.services;

import com.lautaro.springexample.models.Employee;

import java.util.List;

public interface EmployeeService extends CrudService<Employee,String> {
    
    List<Employee> findByBoss(String bossId);
}
