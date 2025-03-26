package com.example.pac_architecture.abstraction;

import java.util.List;
import java.util.ArrayList;

import com.example.pac_architecture.model.Product;

import org.springframework.stereotype.Component;

@Component
public class ProductAbstraction {

    public List<Product> getAllProductsForSeller() {
        return new ArrayList<>();
    }

}
