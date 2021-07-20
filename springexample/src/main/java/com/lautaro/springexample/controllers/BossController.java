package com.lautaro.springexample.controllers;

import com.lautaro.springexample.models.Boss;
import com.lautaro.springexample.services.BossService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.lautaro.springexample.config.Texts.*;

@RestController
@RequestMapping(BOSS_BASEURL)
public class BossController {

    private final BossService bossService;

    public BossController(BossService bossService) {
        this.bossService = bossService;
    }

    @GetMapping
    public ResponseEntity<List<Boss>> getActives() {
        return new ResponseEntity<>(bossService.findActives(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Boss> create(@RequestBody Boss boss){
        return new ResponseEntity<>(bossService.create(boss), HttpStatus.CREATED);
    }

    @GetMapping(ALL_URL)
    public ResponseEntity<List<Boss>> getAll() {
        return new ResponseEntity<>(bossService.findAll(), HttpStatus.OK);
    }

    @GetMapping(ID_URL)
    public ResponseEntity<Boss> getBossById(@PathVariable Long id) {
        return new ResponseEntity<>(bossService.findById(id), HttpStatus.OK);
    }

    @PutMapping(ID_URL)
    public ResponseEntity<Boss> update(@PathVariable Long id,@RequestBody Boss boss){
        return new ResponseEntity<>(bossService.update(id,boss), HttpStatus.CREATED);
    }

    @DeleteMapping(ID_URL)
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id){
        bossService.deleteById(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
