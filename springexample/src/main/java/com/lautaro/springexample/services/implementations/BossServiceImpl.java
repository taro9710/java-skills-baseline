package com.lautaro.springexample.services.implementations;

import com.lautaro.springexample.exceptions.ResourceNotFoundException;
import com.lautaro.springexample.exceptions.WebException;
import com.lautaro.springexample.models.Boss;
import com.lautaro.springexample.repositories.BossRepository;
import com.lautaro.springexample.services.BossService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BossServiceImpl implements BossService {

    private final BossRepository bossRepository;

    public BossServiceImpl(BossRepository bossRepository) {
        this.bossRepository = bossRepository;
    }

    @Override
    public Boss create(Boss boss) {

        validateBoss(boss);
        boss.setCreation(new Date());

        return bossRepository.save(boss);
    }

    @Override
    public Boss update(Long id,Boss boss) {
        Boss bossForUpdate = getById(id);

        validateBoss(boss);

        BeanUtils.copyProperties(boss,bossForUpdate,"id");

        boss.setUpdate(new Date());

        return bossRepository.save(bossForUpdate);
    }

    @Override
    public void deleteById(Long id) {
        Boss boss = findById(id);
        boss.setDeletion(new Date());

        bossRepository.save(boss);
    }


    @Override
    public Boss getById(Long id) {
        Boss boss = findById(id);
        if (boss != null) {
            return boss;
        }
        else throw new ResourceNotFoundException("Boss not found.");
    }

    @Override
    public List<Boss> findAll() {
        return bossRepository.findAll();
    }

    @Override
    public List<Boss> findActives() {
        return findAll()
                .stream()
                .filter(boss -> boss.getDeletion() == null)
                .collect(Collectors.toList());
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
        Optional<Boss> optional = findActives()
                .stream()
                .filter(boss -> boss.getCompany().equalsIgnoreCase(company))
                .filter(boss -> boss.getBusiness().equalsIgnoreCase(business))
                .findFirst();

        return optional.isPresent() ? optional.get() : null;
    }

    @Override
    public Boss getByCompanyAndBusiness(String company, String business) {
        Boss boss = findByCompanyAndBusiness(company,business);

        if (boss != null) {
            return boss;
        }
        else throw new ResourceNotFoundException("Boss not found with those company and business.");
    }


    @Override
    public Boss findById(Long id) {
        Optional<Boss> optional = bossRepository.findById(id);
        return optional.isPresent() ? optional.get() : null;
    }

    private void validateBoss(Boss boss) {

        //Person validation
        if (boss.getName() == null || boss.getName().isEmpty()) {
            throw new WebException("boss' name cannot be null or void.");
        }

        if (boss.getLastname() == null || boss.getLastname().isEmpty()) {
            throw new WebException("boss' lastname cannot be null or void.");
        }

        if (boss.getAddress() == null || boss.getAddress().isEmpty()) {
            throw new WebException("boss' address cannot be null or void. ");
        }

        if (boss.getCity() == null || boss.getCity().isEmpty()) {
            throw new WebException("boss' city cannot be null or void. ");
        }

        if (boss.getCountry() == null || boss.getCountry().isEmpty()) {
            throw new WebException("boss' country cannot be null or void. ");
        }

        //Boss specific validation
        if (boss.getCompany() == null || boss.getCompany().isEmpty()) {
            throw new WebException("boss' company cannot be null or void.");

        }if (boss.getBusiness() == null || boss.getBusiness().isEmpty()) {
            throw new WebException("boss' business cannot be null or void.");
        }
        if (findByCompanyAndBusiness(boss.getCompany(), boss.getBusiness()) != null) {
            throw new WebException("There is already a boss in that company's business");
        }
    }
}
