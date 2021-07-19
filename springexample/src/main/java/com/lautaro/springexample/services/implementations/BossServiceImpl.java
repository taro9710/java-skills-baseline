package com.lautaro.springexample.services.implementations;

import com.lautaro.springexample.models.Boss;
import com.lautaro.springexample.repositories.BossRepository;
import com.lautaro.springexample.services.BossService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BossServiceImpl implements BossService {

    private final BossRepository bossRepository;

    public BossServiceImpl(BossRepository bossRepository) {
        this.bossRepository = bossRepository;
    }

    @Override
    public Boss create(Boss boss) {
        Boss savedBoss = validateBoss(boss);
        savedBoss.setCreation(new Date());

        return savedBoss;
    }

    private Boss validateBoss(Boss boss) {
        //TODO
        return boss;
    }

    @Override
    public Boss update(Boss object) {
        return null;
    }

    @Override
    public void deleteById(String id) {
        Boss boss = findByID(id);
        boss.setDeletion(new Date());

        bossRepository.save(boss);
    }


    @Override
    public List<Boss> findByCompany(String company) {
        return null;
    }

    @Override
    public List<Boss> findByBusiness(String business) {
        return null;
    }

    @Override
    public Boss findByCompanyAndBusiness(String company, String business) {
        return null;
    }

    @Override
    public List<Boss> findAll() {
        return null;
    }

    @Override
    public List<Boss> findActives() {
        return null;
    }

    @Override
    public Boss findByID(String id) {
        Optional<Boss> optional = bossRepository.findById(id);

        if (optional.isPresent()){
            return optional.get();
        }
        return null;
    }

}
