package com.multilevel.multi_level_cache.service;
import com.multilevel.multi_level_cache.entity.Product;
import com.multilevel.multi_level_cache.repository.ProductRepository;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // Multi-Level Caching: First checks L1 (Ehcache), then L2 (Redis), then DB
    @Cacheable(value = "productCache", key = "#id")
    public Product getProductById(Long id) {
        System.out.println("Fetching from DB...");
        return productRepository.findById(id).orElse(null);
    }

    // Fetch all products (No caching here)
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // Save Product - Updates both caches
    @CachePut(value = "productCache", key = "#product.id")
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    // Delete Product - Removes from both caches
    @CacheEvict(value = "productCache", key = "#id")
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
