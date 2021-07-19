package com.lautaro.springexample.services.implementations;

import com.lautaro.springexample.exceptions.ResourceNotFoundException;
import com.lautaro.springexample.exceptions.WebException;
import com.lautaro.springexample.models.Boss;
import com.lautaro.springexample.repositories.BossRepository;
import com.lautaro.springexample.services.BossService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class BossServiceImpl implements BossService {

    private final BossRepository bossRepository;

    public BossServiceImpl(BossRepository bossRepository) {
        this.bossRepository = bossRepository;
    }

    @Override
    public Boss create(Boss boss) {
        Boss savedBoss;

        validateBoss(boss);
        boss.setCreation(new Date());

        savedBoss = bossRepository.save(boss);

        return savedBoss;
    }

    private void validateBoss(Boss boss) {
        //TODO
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
        return findActives()
                .stream()
                .filter(boss -> boss.getCompany().equalsIgnoreCase(company))
                .collect(Collectors.toList());
    }

    @Override
    public List<Boss> findByBusiness(String business) {
        return findActives()
                .stream()
                .filter(boss -> boss.getBusiness().equalsIgnoreCase(business))
                .collect(Collectors.toList());    }

    @Override
    public Boss findByCompanyAndBusiness(String company, String business) {
        return null;
    }



    @Override
    public List<Boss> findActives() {
        return findAll()
                .stream()
                .filter(boss -> boss.getDeletion() == null)
                .collect(Collectors.toList());
    }

    @Override
    public List<Boss> findAll() {
        return bossRepository.findAll();
    }

    @Override
    public Boss findByID(String id) {
        Optional<Boss> optional = bossRepository.findById(id);

        if (optional.isPresent()){
            return optional.get();
        }
        else {
            throw new ResourceNotFoundException("Boss not found");
        }
    }

}
