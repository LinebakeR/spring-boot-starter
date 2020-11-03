package com.testRestau.restaurant.utils;


public class checkUtil {

    public static <T> T checkResto(T object) throws Exception {
        if (object == null) {
            throw new Exception("Don't found restau");
        }
        return object;
    }
}
