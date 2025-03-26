package com.project_using_ehcache.cache.service;

import com.project_using_ehcache.cache.entity.Restaurant;
import com.project_using_ehcache.cache.repository.ResRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResService {

    private static final Logger logger = LoggerFactory.getLogger(ResService.class);

    private final ResRepo repository;
    private final CacheManager cacheManager;

    public ResService(ResRepo repository, CacheManager cacheManager) {
        this.repository = repository;
        this.cacheManager = cacheManager;
    }

    // Cache a single restaurant by ID
    public Restaurant getRestaurantById(Long id) {
        Cache cache = cacheManager.getCache("restaurantCache");
        if (cache != null) {
            Restaurant cachedRestaurant = cache.get(id, Restaurant.class);
            if (cachedRestaurant != null) {
                logger.info("Fetching restaurant with ID: {} from Cache...", id);
                return cachedRestaurant;
            }
        }

        logger.info("Fetching restaurant with ID: {} from Database...", id);
        Restaurant restaurant = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Restaurant not found!"));

        if (cache != null) {
            cache.put(id, restaurant);
            logger.info("Caching restaurant with ID: {}", id);
        }

        return restaurant;
    }

    // Cache all restaurants
    public List<Restaurant> getAllRestaurants() {
        logger.info("Fetching all restaurants from Database...");
        List<Restaurant> restaurants = repository.findAll();

        Cache cache = cacheManager.getCache("restaurantCache");
        if (cache != null) {
            restaurants.forEach(restaurant -> {
                cache.put(restaurant.getId(), restaurant);
                logger.info("Caching restaurant with ID: {}", restaurant.getId());
            });
        }

        return restaurants;
    }

    // Update cache after saving
    @CachePut(value = "restaurantCache", key = "#restaurant.id")
    public Restaurant saveRestaurant(Restaurant restaurant) {
        logger.info("Saving restaurant with ID: {} into the Database...", restaurant.getId());
        return repository.save(restaurant);
    }

    // Evict (remove) a restaurant by ID
    @CacheEvict(value = "restaurantCache", key = "#id")
    public void deleteRestaurant(Long id) {
        logger.info("Deleting restaurant with ID: {} from Database and Cache...", id);
        repository.deleteById(id);
    }

    // Clear all cache entries for restaurantCache
    @CacheEvict(value = "restaurantCache", allEntries = true)
    public void clearCache() {
        logger.info("Clearing all entries from restaurantCache...");
    }
}