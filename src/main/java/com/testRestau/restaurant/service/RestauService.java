package com.testRestau.restaurant.service;

import com.testRestau.restaurant.model.Restaurant;
import com.testRestau.restaurant.repository.RestauRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class RestauService {

    @Autowired
    RestauRepository restauRepository;


    public List<Restaurant> findAll() {
        List<Restaurant> restau = new ArrayList<>();
        restauRepository.findAll().forEach(restau::add); //same as (rest -> restau.add(rest));
        return restau;
    }

    public Restaurant createRestau(Restaurant restaurant) {
        return restauRepository.save(restaurant);
    }

    public Restaurant findById(String id) {
        return restauRepository.findById(id).get();
    }

    public void updateRestau(Restaurant restaurant, String id) throws Exception {
        restaurant.setId(id);
        restauRepository.save(restaurant);
    }

    public void partialUpdate(String id, Map<String, Object> updates) {
       Restaurant restauToUpdate = restauRepository.findById(id).get();
        for(String key: updates.keySet()){
            switch (key){
                case "name":
                    restauToUpdate.setName((String) updates.get(key));
                    break;
                case "adress":
                    restauToUpdate.setAdress((String) updates.get(key));
                    break;
                default:
                    throw new IllegalArgumentException("Unexpected value " + key);
            }
        }
        restauRepository.save(restauToUpdate);
    }

    public void deleteRestau(String id) {
        restauRepository.deleteById(id);
    }
}
