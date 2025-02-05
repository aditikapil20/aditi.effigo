package com.start.initial.service;

import com.start.initial.entity.ProductsEntity;
import com.start.initial.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service     // service hum CRUD logic likhte hai
public class ProductService {
    @Autowired // isse sb interface(repo) ka isme aa gya
    private ProductRepository productRepository;

    public ProductsEntity addProduct(ProductsEntity productsEntity){
        // entity me jo table banaya ussi me hi to add karenge

        return productRepository.save(productsEntity);
        // save 1 jpa repo ka built-in method hai , jo data ko db me insert krdeta hai ya update krdeta hai

    }
    public List<ProductsEntity> getAllProducts()
    {
        return productRepository.findAll();
    }
    public Optional<ProductsEntity> getProductById(String id){
        // contains an object if one is found with the provided id , or it may be empty if no matching record exists.
        return productRepository.findById(id);
    }
    public void deleteProduct(String id){
        productRepository.deleteById(id);
    }
    public ProductsEntity updateProduct(String id , ProductsEntity productDetails){
        ProductsEntity existingProduct = productRepository.findById(id).orElse(null);
        existingProduct.setProductPrice(productDetails.getProductPrice());
        existingProduct.setProductName(productDetails.getProductName());
        existingProduct.setRating(productDetails.getRating());
        return productRepository.save(existingProduct);
    }
    public List<ProductsEntity> getProductsByRating(int rating) {
        return productRepository.findProductsByRating(rating);
    }
}
