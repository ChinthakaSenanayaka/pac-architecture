package com.example.pac_architecture.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.pac_architecture.abstraction.ProductAbstraction;
import com.example.pac_architecture.model.User;
import com.example.pac_architecture.model.UserType;
import com.example.pac_architecture.model.Product;

@Controller
public class ProductController {

    @Autowired
    private ProductAbstraction productAbstraction;

    public List<Product> getProductsForUser(User user) {
        if(user.getUserType() == UserType.CUSTOMER) {
            return productAbstraction.getAllProducts();
        } else {
            return productAbstraction.getProductsForSeller(user);
        }
    }

    public void createProduct(Product product) {
        productAbstraction.createProduct(product);
    }

}

