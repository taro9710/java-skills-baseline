package com.lautaro.springexample.controllers;

import com.lautaro.springexample.models.Boss;
import com.lautaro.springexample.services.BossService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.lautaro.springexample.config.Texts.*;

@RestController(BOSS_BASEURL)
public class BossController {

    private final BossService bossService;

    public BossController(BossService bossService) {
        this.bossService = bossService;
    }

    @GetMapping(ID_URL)
    public ResponseEntity<Boss> getBossById(@PathVariable String id) {
        return new ResponseEntity<>(bossService.findByID(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Boss>> getAll() {
        return new ResponseEntity<>(bossService.findAll(), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Boss>> getActives(@PathVariable String id) {
        return new ResponseEntity<>(bossService.findActives(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Boss> create(@RequestBody Boss boss){
        return new ResponseEntity<>(bossService.create(boss), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Boss> update(@RequestBody Boss boss){
        return new ResponseEntity<>(bossService.update(boss), HttpStatus.CREATED);
    }

    @DeleteMapping({"/{id}"})
    public ResponseEntity<Void> deleteCustomer(@PathVariable String id){
        bossService.deleteById(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
