package com.testRestau.restaurant.repository;

import com.testRestau.restaurant.model.Restaurant;
import org.springframework.data.repository.CrudRepository;

public interface RestauRepository extends CrudRepository<Restaurant, String> {

}
