package com.lautaro.springexample.repositories;

import com.lautaro.springexample.models.Boss;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BossRepository extends JpaRepository<Boss,Long> {
}
