package com.lautaro.springexample.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Boss extends Person {

    private String company;
    private String business; //This mean the branch of the company associated to this boss. Example Accounting.

    public Boss() {
        super();
    }

    public Boss(Long id, String name, String lastname, String address, String city, String country, String company,
                String business) {
        super(id,name, lastname, address, city, country);
        this.company = company;
        this.business = business;
    }

    public Boss(Long id, String name, String lastname, String address, String city, String country, Date creation, Date update,
                Date deletion, String company, String business) {
        super(id,name, lastname, address, city, country, creation, update, deletion);
        this.company = company;
        this.business = business;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getBusiness() {
        return business;
    }

    public void setBusiness(String business) {
        this.business = business;
    }
}
