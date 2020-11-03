package com.testRestau.restaurant.controller;

import com.testRestau.restaurant.model.RestauMenu;
import com.testRestau.restaurant.model.Restaurant;
import com.testRestau.restaurant.service.MenuService;
import com.testRestau.restaurant.service.RestauService;
import com.testRestau.restaurant.utils.checkUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
public class MenuController {

    @Autowired
    MenuService menuService;
    @Autowired
    RestauService restauService;

    @GetMapping("restau/{id}/menus")
    @ResponseStatus(value = HttpStatus.OK)
    public Set<RestauMenu> findAllMenus(@PathVariable("id") String id) throws Exception {
        checkUtil.checkResto(restauService.findById(id));
        return menuService.findAllMenu(id);
    }

    @GetMapping("menu/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public RestauMenu findMenuById(@PathVariable("id") String id) throws Exception {
        checkUtil.checkResto(menuService.findMenuById(id));
        return menuService.findMenuById(id);
    }

    @PostMapping("create/{id}/menu")
    @ResponseStatus(value = HttpStatus.OK)
    public Restaurant createMenu(@PathVariable("id") String id, @RequestBody RestauMenu menu) throws Exception {
        checkUtil.checkResto(restauService.findById(id));
        return menuService.createMenu(id, menu);
    }

    @PutMapping("update/{id}/menu")
    @ResponseStatus(value = HttpStatus.OK)
    public void updateMenu(@PathVariable("id") String id, @RequestBody RestauMenu menu) {
        menuService.updateMenu(id, menu);
    }

    @DeleteMapping("delete/{id}/menu/{idMenu}")
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteMenu(@PathVariable("id") String id, @PathVariable("idMenu") String idMenu) {
        menuService.deleteMenu(id, idMenu);
    }


}
