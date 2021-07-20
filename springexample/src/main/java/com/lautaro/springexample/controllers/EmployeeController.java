package com.lautaro.springexample.controllers;

import com.lautaro.springexample.models.Employee;
import com.lautaro.springexample.services.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.lautaro.springexample.config.Texts.*;

@RestController
@RequestMapping(EMPLOYEE_BASEURL)
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getActives() {
        return new ResponseEntity<>(employeeService.findActives(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Employee> create(@RequestBody Employee employee){
        return new ResponseEntity<>(employeeService.create(employee), HttpStatus.CREATED);
    }

    @GetMapping(ALL_URL)
    public ResponseEntity<List<Employee>> getAll() {
        return new ResponseEntity<>(employeeService.findAll(), HttpStatus.OK);
    }

    @GetMapping(ID_URL)
    public ResponseEntity<Employee> getById(@PathVariable Long id) {
        return new ResponseEntity<>(employeeService.getById(id), HttpStatus.OK);
    }

    @PutMapping(ID_URL)
    public ResponseEntity<Employee> update(@PathVariable Long id,@RequestBody Employee employee){
        return new ResponseEntity<>(employeeService.update(id,employee), HttpStatus.CREATED);
    }

    @DeleteMapping(ID_URL)
    public ResponseEntity<Void> delete(@PathVariable Long id){
        employeeService.deleteById(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }


}
