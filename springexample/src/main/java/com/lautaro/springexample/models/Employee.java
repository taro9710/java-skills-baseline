package com.lautaro.springexample.models;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Employee extends Person{

    @ManyToOne
    @JoinColumn(name = "boss")
    private Boss boss;
    private Long bossId;

    public Employee() {
        super();
    }

    public Employee(Long id, String name, String lastname, String address, String city, String country, Boss boss,
                    Long bossId) {
        super(id, name, lastname, address, city, country);
        this.boss = boss;
        this.bossId = bossId;
    }

    public Employee(Long id, String name, String lastname, String address, String city, String country, LocalDate creation,
                    LocalDate update, LocalDate deletion, Boss boss, Long bossId) {
        super(id, name, lastname, address, city, country, creation, update, deletion);
        this.boss = boss;
        this.bossId = bossId;
    }

    public Boss getBoss() {
        return boss;
    }

    public void setBoss(Boss boss) {
        this.boss = boss;
    }

    public Long getBossId() {
        return bossId;
    }

    public void setBossId(Long bossId) {
        this.bossId = bossId;
    }
}
