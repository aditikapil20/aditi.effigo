package com.start.initial.controller;

import com.start.initial.entity.ProductsEntity;
import com.start.initial.repository.ProductRepository;
import com.start.initial.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
// kyuki json me deal krna hai
@RequestMapping("/products-operations")  // sb endpoint "....." isse start honge  // end point ka base path

public class ProductController {
    @Autowired  // service se
    private ProductService productService;

    @PostMapping("/add-product")    // http request handle krne k liye add krne k liye
    public ProductsEntity addProduct(@RequestBody ProductsEntity productsEntity) {
        // RequestBody : http request ke data ko fetch krle
        //jo hum json me likh rhe the vo hume mil jaye
        return productService.addProduct(productsEntity);

    }

    @GetMapping("/fetch-all-products")
    public List<ProductsEntity> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/fetch-by-id/{id}")    // {id}: this url part is dynamic
    public Optional<ProductsEntity> getProductById(@PathVariable String id) {
        return productService.getProductById(id);
    }

    @DeleteMapping("/delete-product/{id}")
    public void deleteProduct(@PathVariable String id) {
        productService.deleteProduct(id);
    }

    @PutMapping("/update-product/{id}")
    public ProductsEntity updateProduct(@PathVariable String id, @RequestBody ProductsEntity productsEntity) {
        ProductsEntity updateProduct = productService.updateProduct(id, productsEntity);
        return updateProduct;

    }

    @GetMapping("/rating")       // ....................../rating?rating=5    ............. query parameter
    public List<ProductsEntity> getProductsByRating(@RequestParam("rating") int rating) {
        return productService.getProductsByRating(rating);
    }
}
