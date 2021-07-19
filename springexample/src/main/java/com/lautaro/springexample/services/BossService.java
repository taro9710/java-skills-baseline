package com.lautaro.springexample.services;

import com.lautaro.springexample.models.Boss;

import java.util.List;

public interface BossService extends CrudService<Boss,String> {

    List<Boss> findByCompany(String company);

    List<Boss> findByBusiness(String business);

    Boss findByCompanyAndBusiness(String company,String business);
}
