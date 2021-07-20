package com.lautaro.springexample.services.implementations;

import com.lautaro.springexample.exceptions.ResourceNotFoundException;
import com.lautaro.springexample.exceptions.WebException;
import com.lautaro.springexample.models.Employee;
import com.lautaro.springexample.repositories.EmployeeRepository;
import com.lautaro.springexample.services.BossService;
import com.lautaro.springexample.services.EmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final BossService bossService;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, BossService bossService) {
        this.employeeRepository = employeeRepository;
        this.bossService = bossService;
    }

    @Override
    public Employee create(Employee employee) {
        Employee savedEmployee;

        validateEmployee(employee);
        employee.setCreation(new Date());

        savedEmployee = employeeRepository.save(employee);

        return savedEmployee;
    }

    @Override
    public Employee update(Long id,Employee employee) {
        Employee employeeForUpdate = getById(id);

        validateEmployee(employee);

        BeanUtils.copyProperties(employee,employeeForUpdate,"id","boss","bossId");

        if (!employee.getBossId().equals(employeeForUpdate.getBossId())){
            employeeForUpdate.setBossId(employee.getBossId());
            employeeForUpdate.setBoss(bossService.getById(employee.getBossId()));
        }

        employeeForUpdate.setUpdate(new Date());

        return employeeRepository.save(employeeForUpdate);
    }

    @Override
    public void deleteById(Long id) {
        Employee employee = findById(id);

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
    public Employee findById(Long id) {
        Optional<Employee> optional = employeeRepository.findById(id);

        return optional.isPresent() ? optional.get() : null;
    }

    @Override
    public Employee getById(Long id) {
        Employee employee = findById(id);

        if (employee != null) {
            return employee;
        }
        else throw new ResourceNotFoundException("Employee not found.");
    }

    private void validateEmployee(Employee employee) {

        //Person validation
        if (employee.getName() == null || employee.getName().isEmpty()) {
            throw new WebException("Employees' name cannot be null or void.");
        }

        if (employee.getLastname() == null || employee.getLastname().isEmpty()) {
            throw new WebException("Employees' lastname cannot be null or void.");
        }

        if (employee.getAddress() == null || employee.getAddress().isEmpty()) {
            throw new WebException("Employees' address cannot be null or void. ");
        }

        if (employee.getCity() == null || employee.getCity().isEmpty()) {
            throw new WebException("Employees' city cannot be null or void. ");
        }

        if (employee.getCountry() == null || employee.getCountry().isEmpty()) {
            throw new WebException("Employees' country cannot be null or void. ");
        }

        //Employee specific validation
        if (employee.getBossId() == null) {
            throw new WebException("Employees must have a boss selected. ");
        }
    }
}
