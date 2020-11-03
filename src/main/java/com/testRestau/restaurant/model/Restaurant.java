package com.testRestau.restaurant.model;


import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Restaurant {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;

    private String name;
    private String adress;

    @OneToMany(cascade = CascadeType.ALL)
    Set<RestauMenu> menus = new HashSet<>();

}
