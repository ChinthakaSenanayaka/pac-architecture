package com.example.pac_architecture.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.pac_architecture.abstraction.ProductAbstraction;
import com.example.pac_architecture.model.Product;
import com.example.pac_architecture.model.User;
import com.example.pac_architecture.model.UserType;

/**
 * Controller responsible for managing products,  
 * providing methods to retrieve and create products based on user roles.
 */
@Controller
public class ProductController {

    /**  
     * Abstraction layer for handling product-related operations.  
     */
    @Autowired
    private ProductAbstraction productAbstraction;

    /**
     * Retrieves a list of products based on the user's role.  
     * If the user is a customer, it returns all available products.  
     * If the user is a seller, it returns only the products they own.
     * 
     * @param user The user requesting the product list.
     * @return A list of products corresponding to the user's role.
     */
    public List<Product> getProductsForUser(User user) {
        if(user.getUserType() == UserType.CUSTOMER) {
            return productAbstraction.getAllProducts();
        } else {
            return productAbstraction.getProductsForSeller(user);
        }
    }

    /**
     * Creates a new product and adds it to the database.
     * 
     * @param product The product to be created.
     */
    public void createProduct(Product product) {
        productAbstraction.createProduct(product);
    }

}
