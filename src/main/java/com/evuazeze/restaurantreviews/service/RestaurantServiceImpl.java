package com.evuazeze.restaurantreviews.service;

import com.evuazeze.restaurantreviews.exception.RestaurantNotFoundException;
import com.evuazeze.restaurantreviews.model.Restaurant;
import com.evuazeze.restaurantreviews.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestaurantServiceImpl implements RestaurantService {
    @Autowired
    private RestaurantRepository restaurantRepository;

    @Override
    public List<Restaurant> listRestaurants() {
        return restaurantRepository.findAll();
    }

    @Override
    public List<Restaurant> listFavouriteRestaurants(Boolean value) {
        return restaurantRepository.findRestaurantsByIsFavoriteIs(value);
    }

    @Override
    public Restaurant findRestaurant(long id) {
        Optional<Restaurant> optionalRestaurant = restaurantRepository.findById(id);

        if (optionalRestaurant.isPresent())
            return optionalRestaurant.get();
        else
            throw new RestaurantNotFoundException("Restaurant Not Found");
    }

    @Override
    public void saveRestaurant(Restaurant restaurant) {
        restaurantRepository.save(restaurant);
    }

    @Override
    public void favoriteARestaurant(Long id, Boolean value) {
        Restaurant restaurant = findRestaurant(id);
        restaurant.setIsFavorite(value);
        restaurantRepository.saveAndFlush(restaurant);
    }
}
