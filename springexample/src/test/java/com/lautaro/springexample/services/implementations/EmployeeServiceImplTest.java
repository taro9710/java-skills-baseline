package com.lautaro.springexample.services.implementations;

import com.lautaro.springexample.models.Boss;
import com.lautaro.springexample.models.Employee;
import com.lautaro.springexample.repositories.EmployeeRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;;

class EmployeeServiceImplTest {

    EmployeeServiceImpl employeeService;

    @Mock
    EmployeeRepository employeeRepository;

    @Mock
    BossServiceImpl bossService;

    AutoCloseable autoCloseable;

    Boss boss;
    Employee employee;
    Employee employee2;

    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);

        boss = getBoss();
        employee = getEmployee();
        employee2 = getEmployee2();

        employeeService = new EmployeeServiceImpl(employeeRepository,bossService);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void create() {
        //Given
        Employee newEmployee;
        given(bossService.getById(anyLong())).willReturn(boss);
        given(employeeRepository.save(employee)).willReturn(employee);

        //When
        newEmployee = employeeService.create(employee);

        //Then
        then(bossService).should().getById(anyLong());
        then(employeeRepository).should().save(any(Employee.class));
        assertEquals(employee,newEmployee);
    }

    @Test
    void update() {
        //TODO unit test of the update() method of EmployeeServiceImpl
    }

    @Test
    void deleteById() {
        //TODO unit test of the deleteById() method of EmployeeServiceImpl
    }


    @Test
    void findAll() {
        //Given
        List<Employee> allEmployees;

        given(employeeRepository.findAll()).willReturn(Arrays.asList(employee,employee2));

        //When
        allEmployees = employeeService.findAll();

        //Then
        then(employeeRepository).should().findAll();
        assertEquals(2,allEmployees.size());
        assertEquals(Arrays.asList(employee,employee2),allEmployees);
    }

    @Test
    void findById() {
        //Given
        Employee foundEmployee;

        given(employeeRepository.findById(anyLong())).willReturn(Optional.of(employee));

        //When
        foundEmployee = employeeService.findById(1L);

        //Then
        then(employeeRepository).should().findById(anyLong());
        assertEquals(employee,foundEmployee);
    }

    @Test
    void getById() {
        //Given
        Employee foundEmployee;

        given(employeeRepository.findById(anyLong())).willReturn(Optional.of(employee));

        //When
        foundEmployee = employeeService.getById(1L);

        //Then
        then(employeeRepository).should().findById(anyLong());
        assertEquals(employee,foundEmployee);
    }

    @Test
    void findByBoss() {
        //Given
        List<Employee> employees;
        given(employeeRepository.findAll()).willReturn(Arrays.asList(employee,employee2));

        //when
        employees = employeeService.findByBoss(boss.getId());

        //then
        then(employeeRepository).should().findAll();
        assertEquals(2,employees.size());
        assertEquals(Arrays.asList(employee,employee2),employees);
    }

    @Test
    void findActives() {
        //Given
        List<Employee> activeEmployees;
        List<Employee> allEmployees;
        Employee deleted = getEmployee();

        deleted.setId(3L);
        deleted.setDeletion(LocalDate.now());
        allEmployees = Arrays.asList(employee,employee2,deleted);

        given(employeeRepository.findAll()).willReturn(allEmployees);

        //When
        activeEmployees = employeeService.findActives();

        //Then
        then(employeeRepository).should().findAll();
        assertEquals(2,activeEmployees.size());
        assertEquals(Arrays.asList(employee,employee2),activeEmployees);
    }

    private Boss getBoss(){
        Boss boss = new Boss();

        boss.setId(1L);
        boss.setName("Jefe");
        boss.setLastname("Uno");
        boss.setAddress("Calle 1");
        boss.setCity("Mza");
        boss.setCountry("Argentina");
        boss.setCompany("Company SA");
        boss.setBusiness("Sales");
        boss.setCreation(LocalDate.now());

        return boss;
    }

    private Employee getEmployee() {
        Employee employee = new Employee();

        employee.setId(1L);
        employee.setName("Primer");
        employee.setLastname("Empleado");
        employee.setAddress("Calle 1.1");
        employee.setCity("Mza");
        employee.setCountry("Argentina");
        employee.setCreation(LocalDate.now());
        employee.setBoss(boss);
        employee.setBossId(boss.getId());
        return employee;
    }

    private Employee getEmployee2() {
        Employee employee = new Employee();

        employee.setId(2L);
        employee.setName("Segundo");
        employee.setLastname("Empleado");
        employee.setAddress("Calle 2.2");
        employee.setCity("Mza");
        employee.setCountry("Argentina");
        employee.setCreation(LocalDate.now());
        employee.setBoss(boss);
        employee.setBossId(boss.getId());
        return employee;
    }
}