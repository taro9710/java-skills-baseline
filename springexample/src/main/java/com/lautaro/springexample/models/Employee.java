package com.lautaro.springexample.models;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Employee extends Person{

    @Id
    @GeneratedValue
    protected Long id;

    @ManyToOne
    @JoinColumn(name = "boss_id")
    private Boss boss;

    public Employee() {
        super();
    }

    public Employee(String name, String lastname, String address, String city, String country, Long id, Boss boss) {
        super(name, lastname, address, city, country);
        this.id = id;
        this.boss = boss;
    }

    public Employee(String name, String lastname, String address, String city, String country, Date creation,
                    Date update, Date deletion, Long id, Boss boss) {
        super(name, lastname, address, city, country, creation, update, deletion);
        this.id = id;
        this.boss = boss;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boss getBoss() {
        return boss;
    }

    public void setBoss(Boss boss) {
        this.boss = boss;
    }
}
