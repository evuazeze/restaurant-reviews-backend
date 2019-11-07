package com.evuazeze.restaurantreviews.service;

import com.evuazeze.restaurantreviews.model.Restaurant;

import java.util.List;

public interface RestaurantService {
    List<Restaurant> listRestaurants();

    List<Restaurant> listFavouriteRestaurants(Boolean value);

    Restaurant findRestaurant(long id);

    void saveRestaurant(Restaurant restaurant);

    void favoriteARestaurant(Long id, Boolean value);
}
