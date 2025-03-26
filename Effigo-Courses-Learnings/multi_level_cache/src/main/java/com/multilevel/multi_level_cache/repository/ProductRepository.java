package com.multilevel.multi_level_cache.repository;
import com.multilevel.multi_level_cache.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
