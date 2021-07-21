package com.lautaro.springexample.config;

import com.lautaro.springexample.models.Boss;
import com.lautaro.springexample.models.Employee;
import com.lautaro.springexample.repositories.BossRepository;
import com.lautaro.springexample.repositories.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Date;

@Component
public class Bootstrap implements CommandLineRunner {

    private final BossRepository bossRepository;
    private final EmployeeRepository employeeRepository;
    private Boss boss;
    private Boss boss2;

    public Bootstrap(BossRepository bossRepository, EmployeeRepository employeeRepository) {
        this.bossRepository = bossRepository;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadBosses();
        loadEmployees();
    }

    private void loadBosses() {

        boss = new Boss();

        boss.setName("Jefe");
        boss.setLastname("Uno");
        boss.setAddress("Calle 1");
        boss.setCity("Mza");
        boss.setCountry("Argentina");
        boss.setCompany("Company SA");
        boss.setBusiness("Accounting");
        boss.setCreation(LocalDate.now());

        boss2 = new Boss();

        boss2.setName("Jefito");
        boss2.setLastname("Dos");
        boss2.setAddress("Calle 2");
        boss2.setCity("Mza");
        boss2.setCountry("Argentina");
        boss2.setCompany("Company SA");
        boss2.setBusiness("Legal");
        boss2.setCreation(LocalDate.now());


        bossRepository.save(boss);
        bossRepository.save(boss2);

        System.out.println("Bosses loaded successfully");

    }

    private void loadEmployees() {

        Employee employee = new Employee();

        employee.setName("Primer");
        employee.setLastname("Empleado");
        employee.setAddress("Calle 1.1");
        employee.setCity("Mza");
        employee.setCountry("Argentina");
        employee.setCreation(LocalDate.now());
        employee.setBoss(boss);
        employee.setBossId(boss.getId());

        Employee employee2 = new Employee();

        employee2.setName("Segundo");
        employee2.setLastname("Empleado");
        employee2.setAddress("Calle 2.2");
        employee2.setCity("Mza");
        employee2.setCountry("Argentina");
        employee2.setCreation(LocalDate.now());
        employee2.setBoss(boss);
        employee2.setBossId(boss.getId());

        Employee employee3 = new Employee();

        employee3.setName("Tercer");
        employee3.setLastname("Empleado");
        employee3.setAddress("Calle 3.3");
        employee3.setCity("Mza");
        employee3.setCountry("Argentina");
        employee3.setCreation(LocalDate.now());
        employee3.setBoss(boss2);
        employee3.setBossId(boss2.getId());

        Employee employee4 = new Employee();

        employee4.setName("Cuarto");
        employee4.setLastname("Empleado");
        employee4.setAddress("Calle 4.4");
        employee4.setCity("Mza");
        employee4.setCountry("Argentina");
        employee4.setCreation(LocalDate.now());
        employee4.setBoss(boss2);
        employee4.setBossId(boss2.getId());

        employeeRepository.save(employee);
        employeeRepository.save(employee2);
        employeeRepository.save(employee3);
        employeeRepository.save(employee4);

        System.out.println("Employees created successfully");
    }
}
