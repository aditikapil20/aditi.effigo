package com.start.initial.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data  // phle setter getter generate karenge
@Entity
@Table(name = "product_details")   // table ka naam define krne k liye

public class ProductsEntity {
    @Id //(primary key)
    @GeneratedValue(strategy = GenerationType.UUID) // id(primary key) ki value generate hogi idhr vo bhi auto.
    @Column(name = "Product_id")  // table me aise show hoga name
    private String id;
    @Column(name = "Product_name" ,nullable = false) // kbhi null value nhi hogi
    private String productName;
    @Column(name = "Product_price",nullable = false)
    private double productPrice;  //var : camelCase
    @Column(name = "Rating_of_product",nullable = false)
    private int rating;

}
