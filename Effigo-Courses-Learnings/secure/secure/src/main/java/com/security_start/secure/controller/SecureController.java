package com.security_start.secure.controller;

import com.security_start.secure.entity.Product;
import com.security_start.secure.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class SecureController {

    @Autowired
    private ProductService productService;

    @GetMapping("/")
    public String homePage() {
        return "home";
    }

    @GetMapping("/about")
    public String aboutPage() {
        return "about";
    }

    @GetMapping("/contact")
    public String contactPage() {
        return "contact";
    }

    @GetMapping("/dashboard")
    public String dashboardPage() {
        return "dashboard";
    }

    @GetMapping("/product")
    public String productPage() {
        return "product";
    }

    @PostMapping("/addProduct")
    public String addProduct(@RequestParam String name,
                             @RequestParam String description,
                             @RequestParam int quantity,
                             @RequestParam double cost,
                             Model model) {
        Product product = new Product(name, description, quantity, cost);
        productService.saveProduct(product);

        model.addAttribute("message", "Product added successfully!");
        return "redirect:/productList";
    }

    @GetMapping("/productList")
    public String productListPage(@RequestParam(value = "sort", required = false) String sort, Model model) {
        try {
            List<Product> products;

            if ("price".equals(sort)) {
                products = productService.sortByPrice();
            } else if ("quantity".equals(sort)) {
                products = productService.sortByQuantity();
            } else {
                products = productService.getAllProducts();
            }

            model.addAttribute("products", products);
            return "productList";
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("errorMessage", "Error fetching products.");
            return "error";
        }
    }
}
