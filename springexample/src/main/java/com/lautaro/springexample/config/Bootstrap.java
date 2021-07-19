package com.lautaro.springexample.config;

import com.lautaro.springexample.models.Boss;
import com.lautaro.springexample.repositories.BossRepository;
import com.lautaro.springexample.repositories.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

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

        bossRepository.save(boss);

        Boss boss2 = new Boss();

        boss2.setName("Jefito");
        boss2.setLastname("Dos");

        bossRepository.save(boss2);

        System.out.println("Bosses created");

    }

    private void loadEmployees() {
        
    }
}
