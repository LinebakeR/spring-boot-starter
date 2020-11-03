package com.testRestau.restaurant.controller;

import com.testRestau.restaurant.model.Restaurant;
import com.testRestau.restaurant.repository.RestauRepository;
import com.testRestau.restaurant.service.RestauService;
import com.testRestau.restaurant.utils.checkUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/rest")
public class RestoController {

    @Autowired
    RestauService restauService;

    @GetMapping("/restau")
    public ResponseEntity<List<Restaurant>> findAll() {
        return ResponseEntity.ok(restauService.findAll());
    }

    @PostMapping("/new")
    public ResponseEntity<Restaurant> createRestau(@RequestBody Restaurant restaurant) {
        return ResponseEntity.ok(restauService.createRestau(restaurant));
    }

    @GetMapping("/restau/{id}")
    public ResponseEntity<Restaurant> findById(@PathVariable("id") String id, Restaurant restaurant) throws Exception {
        checkUtil.checkResto(restauService.findById(id));
        return ResponseEntity.ok(restauService.findById(id));
    }

    @PutMapping("update/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public void updateRestau(@PathVariable("id") String id, @RequestBody Restaurant restaurant) throws Exception {
        checkUtil.checkResto(restauService.findById(id));
        restauService.updateRestau(restaurant, id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public void updateRestau(@PathVariable("id") String id, @RequestBody Map<String, Object> updates) throws Exception {
        checkUtil.checkResto(restauService.findById(id));
        restauService.partialUpdate(id, updates);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public void deleteById(@PathVariable("id") String id) throws Exception {
        checkUtil.checkResto(restauService.findById(id));
        restauService.deleteRestau(id);
    }
}
