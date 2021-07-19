package com.lautaro.springexample.config;

import com.lautaro.springexample.models.Boss;
import com.lautaro.springexample.repositories.BossRepository;
import com.lautaro.springexample.repositories.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;

public class Bootstrap implements CommandLineRunner {

    private final BossRepository bossRepository;
    private final EmployeeRepository employeeRepository;

    public Bootstrap(BossRepository bossRepository, EmployeeRepository employeeRepository) {
        this.bossRepository = bossRepository;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void run(String... args) throws Exception {
//        loadBosses();
//        loadEmployees();
    }

    private void loadBosses() {

        Boss boss = new Boss();

        boss.setName("Jefe");
        boss.setLastname("Uno");

    }

    private void loadEmployees() {
    }
}
