package com.security_start.secure.repository;

import com.security_start.secure.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    // Sort products by price in ascending order
    List<Product> findAllByOrderByCostAsc();

    // Sort products by quantity in ascending order
    List<Product> findAllByOrderByQuantityAsc();
}
