package com.lautaro.springexample.models;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
public abstract class Person {

    @Id
    @GeneratedValue
    protected String id;

    protected String name;
    protected String lastname;
    protected String address;
    protected String city;
    protected String country;

    @Temporal(TemporalType.TIMESTAMP)
    protected Date creation;

    @Temporal(TemporalType.TIMESTAMP)
    protected Date update;

    @Temporal(TemporalType.TIMESTAMP)
    protected Date deletion;

    public Person() {}

    public Person(String id, String name, String lastname, String address, String city, String country) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.address = address;
        this.city = city;
        this.country = country;
        this.creation = new Date();
    }

    public Person(String id, String name, String lastname, String address, String city, String country, Date creation, Date update, Date deletion) {
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public Date getCreation() {
        return creation;
    }

    public void setCreation(Date creation) {
        this.creation = creation;
    }

    public Date getUpdate() {
        return update;
    }

    public void setUpdate(Date update) {
        this.update = update;
    }

    public Date getDeletion() {
        return deletion;
    }

    public void setDeletion(Date deletion) {
        this.deletion = deletion;
    }
}
