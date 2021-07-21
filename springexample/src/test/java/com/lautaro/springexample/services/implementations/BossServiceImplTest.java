package com.lautaro.springexample.services.implementations;

import com.lautaro.springexample.models.Boss;
import com.lautaro.springexample.repositories.BossRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

class BossServiceImplTest {

    BossServiceImpl bossService;

    AutoCloseable autoCloseable;

    @Mock
    BossRepository bossRepository;

    Boss boss1;
    Boss boss2;

    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        bossService = new BossServiceImpl(bossRepository);

        boss1 = getBoss1();
        boss2 = getBoss2();
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void create() {
        //Given
        Boss createdEntity;
        given(bossRepository.save(any(Boss.class))).willReturn(boss1);

        //When
        createdEntity = bossService.create(boss1);

        //Then
        then(bossRepository).should().save(any(Boss.class));
        assertEquals(createdEntity,boss1);
    }

    @Test
    void update() {
        //TODO
//        //Given
//        Boss modifiedBoss;
//        Boss expectedBoss = getBoss1();
//        expectedBoss.setName("Boss");
//        expectedBoss.setLastname("modified");
//        expectedBoss.setUpdate(LocalDate.now());
//
//        given(bossRepository.findById(anyLong())).willReturn(Optional.of(boss1));
//        given(bossRepository.save(any(Boss.class))).willReturn(expectedBoss);
//
//        //Then
//        modifiedBoss = bossService.update(1L,expectedBoss);
//
//        //Then
//        then(bossRepository).should().findById(anyLong());
//        assertEquals("Boss",modifiedBoss.getName());
//        assertEquals("modified",modifiedBoss.getLastname());
    }

    @Test
    void deleteById() {
        //Given

        //When

        //Then
    }

    @Test
    void getById() {
        //Given
        Boss foundBoss;
        given(bossRepository.findById(anyLong())).willReturn(Optional.of(boss1));

        //When
        foundBoss = bossService.getById(1L);

        //Then
        then(bossRepository).should().findById(anyLong());
        assertEquals(boss1,foundBoss);
    }

    @Test
    void findAll() {
        //Given
        List<Boss> bosses;
        given(bossRepository.findAll()).willReturn(Arrays.asList(boss1,boss2));

        //When
        bosses = bossService.findAll();

        //Then
        then(bossRepository).should().findAll();
        assertEquals(Arrays.asList(boss1,boss2),bosses);
    }

    @Test
    void findActives() {
        //Given
        Boss deleted = getBoss1();
        List<Boss> allBosses;
        List<Boss> activeBosses;

        deleted.setDeletion(LocalDate.now());
        allBosses = Arrays.asList(boss1,boss2,deleted);

        given(bossRepository.findAll()).willReturn(allBosses);

        //When
        activeBosses = bossService.findActives();

        //then
        then(bossRepository).should().findAll();
        assertEquals(2,activeBosses.size());
        assertEquals(Arrays.asList(boss1,boss2),activeBosses);
    }

    @Test
    void findByCompany() {
        //Given
        List<Boss> bosses;
        given(bossRepository.findAll()).willReturn(Arrays.asList(boss1,boss2));

        //When
        bosses = bossService.findByCompany(boss1.getCompany());

        //then
        then(bossRepository).should().findAll();
        assertEquals(2,bosses.size());
        assertEquals(Arrays.asList(boss1,boss2),bosses);
    }

    @Test
    void findByBusiness() {
        //Given
        List<Boss> bosses;
        given(bossRepository.findAll()).willReturn(Arrays.asList(boss1,boss2));

        //When
        bosses = bossService.findByBusiness(boss1.getBusiness());

        //then
        then(bossRepository).should().findAll();
        assertEquals(1,bosses.size());
        assertEquals(Arrays.asList(boss1),bosses);
    }

    @Test
    void findByCompanyAndBusiness() {
        //Given
        Boss foundBoss;
        given(bossRepository.findAll()).willReturn(Arrays.asList(boss1,boss2));

        //When
        foundBoss = bossService.findByCompanyAndBusiness(boss1.getCompany(),boss1.getBusiness());

        //Then
        then(bossRepository).should().findAll();
        assertEquals(foundBoss,boss1);
    }

    @Test
    void getByCompanyAndBusiness() {
        //Given
        Boss foundBoss;
        given(bossRepository.findAll()).willReturn(Arrays.asList(boss1,boss2));

        //When
        foundBoss = bossService.getByCompanyAndBusiness(boss1.getCompany(),boss1.getBusiness());

        //Then
        then(bossRepository).should().findAll();
        assertEquals(foundBoss,boss1);
    }

    @Test
    void findById() {
        //Given
        Boss foundBoss;
        given(bossRepository.findById(anyLong())).willReturn(Optional.of(boss1));

        //When
        foundBoss = bossService.findById(1L);

        //Then
        then(bossRepository).should().findById(anyLong());
        assertEquals(boss1,foundBoss);
    }


    private Boss getBoss1(){
        Boss boss = new Boss();

        boss.setName("Jefe");
        boss.setLastname("Uno");
        boss.setAddress("Calle 1");
        boss.setCity("Mza");
        boss.setCountry("Argentina");
        boss.setCompany("Company SA");
        boss.setBusiness("Sales");
        boss.setCreation(LocalDate.now());

        return boss;
    }

    private Boss getBoss2(){
        Boss boss = new Boss();

        boss.setName("Jefito");
        boss.setLastname("Dos");
        boss.setAddress("Calle 2");
        boss.setCity("Mza");
        boss.setCountry("Argentina");
        boss.setCompany("Company SA");
        boss.setBusiness("Legal");
        boss.setCreation(LocalDate.now());

        return boss;
    }
}