package com.evuazeze.restaurantreviews.exception;

public class ReviewNotFoundException extends RuntimeException{
    public ReviewNotFoundException(String exception) {
        super(exception);
    }
}
