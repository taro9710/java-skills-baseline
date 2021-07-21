package com.lautaro.springexample.config;

import com.lautaro.springexample.models.Boss;
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

        Boss boss = new Boss();

        boss.setName("Jefe");
        boss.setLastname("Uno");
        boss.setAddress("Calle 1");
        boss.setCity("Mza");
        boss.setCountry("Argentina");
        boss.setCompany("Company SA");
        boss.setBusiness("Accounting");
        boss.setCreation(LocalDate.now());


        bossRepository.save(boss);

        Boss boss2 = new Boss();

        boss2.setName("Jefito");
        boss2.setLastname("Dos");
        boss2.setAddress("Calle 2");
        boss2.setCity("Mza");
        boss2.setCountry("Argentina");
        boss2.setCompany("Company SA");
        boss2.setBusiness("Legal");
        boss2.setCreation(LocalDate.now());


        bossRepository.save(boss2);

        System.out.println("Bosses loaded successfully");

    }

    private void loadEmployees() {

        System.out.println("Employees created successfully");
    }
}
