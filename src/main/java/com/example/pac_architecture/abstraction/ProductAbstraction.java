package com.example.pac_architecture.abstraction;

import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;

import com.example.pac_architecture.db.DummyDBData;
import com.example.pac_architecture.model.Product;
import com.example.pac_architecture.model.User;
import com.example.pac_architecture.model.UserType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductAbstraction {

    @Autowired
    private DummyDBData dbConnection;

    public List<Product> getAllProducts() {
        // Customer sees all the products
        return dbConnection.getProducts();
    }

    public List<Product> getProductsForSeller(User seller) {
        // Seller sees only his products
        return dbConnection.getProducts().stream()
            .filter(product -> product.getSeller().getId() == seller.getId())
            .collect(Collectors.toList());
    }

}
