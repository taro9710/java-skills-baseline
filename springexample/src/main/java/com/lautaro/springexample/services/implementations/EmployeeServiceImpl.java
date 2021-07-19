package com.lautaro.springexample.services.implementations;

import com.lautaro.springexample.exceptions.ResourceNotFoundException;
import com.lautaro.springexample.exceptions.WebException;
import com.lautaro.springexample.models.Employee;
import com.lautaro.springexample.repositories.EmployeeRepository;
import com.lautaro.springexample.services.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee create(Employee employee) {
        Employee savedEmployee;

        validateEmployee(employee);
        employee.setCreation(new Date());

        savedEmployee = employeeRepository.save(employee);
        
        return savedEmployee;
    }

    private void validateEmployee(Employee employee) {
    }

    @Override
    public Employee update(Employee employee) {
        return null;
    }

    @Override
    public void deleteById(String id) {
        Employee employee = findByID(id);

        employee.setDeletion(new Date());
        employeeRepository.save(employee);
    }

    @Override
    public List<Employee> findByBoss(String bossId) {
        return findAll()
                .stream()
                .filter(employee -> employee.getBossId().equals(bossId))
                .collect(Collectors.toList());
    }

    @Override
    public List<Employee> findActives() {
        return findAll()
                .stream()
                .filter(employee -> employee.getDeletion() == null)
                .collect(Collectors.toList());
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }


    @Override
    public Employee findByID(String id) {
        Optional<Employee> optional = employeeRepository.findById(id);

        if (optional.isPresent()) {
            return optional.get();
        }
        else {
            throw new ResourceNotFoundException("Employee not found");
        }
    }
}
