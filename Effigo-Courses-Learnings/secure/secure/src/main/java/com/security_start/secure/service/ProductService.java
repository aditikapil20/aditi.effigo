package com.security_start.secure.service;

import com.security_start.secure.entity.Product;
import com.security_start.secure.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    // Save Product
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    // Get All Products
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // Sort Products by Price (Ascending)
    public List<Product> sortByPrice() {
        return productRepository.findAllByOrderByCostAsc();
    }

    // Sort Products by Quantity (Ascending)
    public List<Product> sortByQuantity() {
        return productRepository.findAllByOrderByQuantityAsc();
    }
}
