package com.lautaro.springexample.models;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

public class Employee extends Person{

    @ManyToOne
    @JoinColumn(name = "boss_id")
    private Boss boss;

    public Employee() {
        super();
    }

    public Employee(String id, String name, String lastname, String address, String city, String country, Boss boss) {
        super(id, name, lastname, address, city, country);
        this.boss = boss;
    }

    public Employee(String id, String name, String lastname, String address, String city, String country,
                    Date creation, Date update, Date deletion, Boss boss) {
        super(id, name, lastname, address, city, country, creation, update, deletion);
        this.boss = boss;
    }

    public Boss getBoss() {
        return boss;
    }

    public void setBoss(Boss boss) {
        this.boss = boss;
    }
}
