package com.lautaro.springexample.models;

import javax.persistence.Entity;
import java.util.Date;

@Entity
public class Boss extends Person {

    private String company;
    private String business; //This mean the branch of the company associated to this boss. Example Accounting.

    public Boss() {
        super();
    }

    public Boss(String id, String name, String lastname, String address, String city, String country, String company,
                String business) {
        super(id, name, lastname, address, city, country);
        this.company = company;
        this.business = business;
    }

    public Boss(String id, String name, String lastname, String address, String city, String country, Date creation,
                Date update, Date deletion, String company, String business) {
        super(id, name, lastname, address, city, country, creation, update, deletion);
        this.company = company;
        this.business = business;
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
