package com.evuazeze.restaurantreviews.service;

import com.evuazeze.restaurantreviews.model.Restaurant;
import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.List;
import java.util.Optional;

public interface RestaurantService {
    List<Restaurant> findAll();

    List<Restaurant> listFavouriteRestaurants(Boolean value);

    Optional<Restaurant> findById(Long id);

    Restaurant save(Restaurant restaurant);

    Boolean favoriteARestaurant(Restaurant restaurant);
}
