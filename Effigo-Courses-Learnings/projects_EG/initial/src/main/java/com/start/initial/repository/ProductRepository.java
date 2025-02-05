package com.start.initial.repository;

import com.start.initial.entity.ProductsEntity;
import org.springframework.data.jpa.repository.JpaRepository;  //CRUD operations provide krta hai
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductsEntity,String>{
    // <entity ki cls,primary key ka datatype(wrapper ki form me)>
    // db se jpa repo interact krti h , CRUD operations handle krti hai
    // repo hamesha I hogi

    // custom query :  Custom SQL likhne ke liye
    @Query("SELECT p FROM ProductsEntity p WHERE p.rating = :rating")
    List<ProductsEntity> findProductsByRating(@Param("rating") int rating);
    // URL se rating ko fetch karne ke liye : @Param("rating")
}
