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
    public List<Restaurant> findAll() {
        return restaurantRepository.findAll();
    }

    @Override
    public List<Restaurant> listFavouriteRestaurants(Boolean value) {
        return restaurantRepository.findRestaurantsByIsFavoriteIs(value);
    }

    @Override
    public Optional<Restaurant> findById(Long id) {
        Optional<Restaurant> optionalRestaurant = restaurantRepository.findById(id);

        if (optionalRestaurant.isPresent())
            return optionalRestaurant;
        else
            throw new RestaurantNotFoundException("Restaurant Not Found");
    }

    @Override
    public Restaurant save(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    @Override
    public Boolean favoriteARestaurant(Restaurant restaurant) {
        restaurantRepository.saveAndFlush(restaurant);
        return true;
    }
}
