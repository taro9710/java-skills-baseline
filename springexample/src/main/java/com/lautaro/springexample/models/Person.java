package com.lautaro.springexample.models;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@MappedSuperclass
public abstract class Person {

    @Id
    @GeneratedValue
    protected Long id;

    protected String name;
    protected String lastname;
    protected String address;
    protected String city;
    protected String country;

    @Temporal(TemporalType.TIMESTAMP)
    protected LocalDate creation;

    @Temporal(TemporalType.TIMESTAMP)
    protected LocalDate update;

    @Temporal(TemporalType.TIMESTAMP)
    protected LocalDate deletion;

    public Person() {}

    public Person( Long id, String name, String lastname, String address, String city, String country) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.address = address;
        this.city = city;
        this.country = country;
        this.creation = LocalDate.now();
    }

    public Person( Long id, String name, String lastname, String address, String city, String country,
                   LocalDate creation, LocalDate update, LocalDate deletion) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.address = address;
        this.city = city;
        this.country = country;
        this.creation = creation;
        this.update = update;
        this.deletion = deletion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public LocalDate getCreation() {
        return creation;
    }

    public void setCreation(LocalDate creation) {
        this.creation = creation;
    }

    public LocalDate getUpdate() {
        return update;
    }

    public void setUpdate(LocalDate update) {
        this.update = update;
    }

    public LocalDate getDeletion() {
        return deletion;
    }

    public void setDeletion(LocalDate deletion) {
        this.deletion = deletion;
    }
}
