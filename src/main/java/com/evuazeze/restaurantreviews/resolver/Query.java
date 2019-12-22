//package com.evuazeze.restaurantreviews.resolver;
//
//import com.coxautodev.graphql.tools.GraphQLQueryResolver;
//import com.evuazeze.restaurantreviews.model.Restaurant;
//import com.evuazeze.restaurantreviews.service.RestaurantService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//@Component
//public class Query implements GraphQLQueryResolver {
//
//    @Autowired
//    private RestaurantService restaurantService;
//
//    public Iterable<Restaurant> findAllRestaurants() {
//        return restaurantService.findAll();
//    }
//}
