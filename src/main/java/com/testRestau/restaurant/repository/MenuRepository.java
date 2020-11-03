package com.testRestau.restaurant.repository;

import com.testRestau.restaurant.model.RestauMenu;
import org.springframework.data.repository.CrudRepository;

public interface MenuRepository  extends CrudRepository<RestauMenu, String> {

}
