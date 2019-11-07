package com.evuazeze.restaurantreviews.exception;

public class RestaurantNotFoundException extends RuntimeException {

    public RestaurantNotFoundException(String exception) {
        super(exception);
    }
}
