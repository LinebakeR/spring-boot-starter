package com.testRestau.restaurant.service;

import com.testRestau.restaurant.model.RestauMenu;
import com.testRestau.restaurant.model.Restaurant;
import com.testRestau.restaurant.repository.MenuRepository;
import com.testRestau.restaurant.repository.RestauRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;


@Service
public class MenuService {

    @Autowired
    RestauRepository restauRepository;
    @Autowired
    MenuRepository menuRepository;

    public Set<RestauMenu> findAllMenu(String id) {
        return restauRepository.findById(id).get().getMenus();
    }

    public RestauMenu findMenuById(String id) {
        if (menuRepository.findById(id).isPresent()) {
            return menuRepository.findById(id).get();
        }
        return null;
    }

    public Restaurant createMenu(String id, RestauMenu menu) throws Exception {
        Restaurant resto = restauRepository.findById(id).get();
        if (resto.getId().equals(id)) {
            resto.getMenus().add(menu);
            return restauRepository.save(resto);
        }
        throw new Exception("no resto found");
    }

    public void updateMenu(String id, RestauMenu menu) {
        menu.setId(id);
        menuRepository.save(menu);
    }

    public void deleteMenu(String id, String idMenu) {
        Restaurant restoId = restauRepository.findById(id).get();
        Set<RestauMenu> menus = restoId.getMenus();
        RestauMenu menu = menus.stream().filter(m -> m.getId().equals(idMenu)).findFirst().get();
        menus.remove(menu);
        restoId.setMenus(menus);
        restauRepository.save(restoId);
    }
}
