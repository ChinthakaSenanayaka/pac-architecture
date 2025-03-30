package com.example.pac_architecture.abstraction;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.pac_architecture.db.DummyDBData;
import com.example.pac_architecture.model.Product;
import com.example.pac_architecture.model.User;


/**
 * Provides abstraction for handling products,  
 * allowing retrieval and creation of products for both customers and sellers.
 */
@Component
public class ProductAbstraction {

    /**  
     * Database connection providing access to product data.  
     */
    @Autowired
    private DummyDBData dbConnection;

    /**
     * Retrieves all available products.
     * Customers have access to all products in the database.
     * 
     * @return A list of all available products.
     */
    public List<Product> getAllProducts() {
        // Customer sees all the products
        return dbConnection.getProducts();
    }

    /**
     * Retrieves all products that belong to a specific seller.
     * Sellers can only view their own products.
     * 
     * @param seller The seller whose products are to be retrieved.
     * @return A list of products owned by the given seller.
     */
    public List<Product> getProductsForSeller(User seller) {
        // Seller sees only his products
        return dbConnection.getProducts().stream()
            .filter(product -> product.getSeller().getId() == seller.getId())
            .collect(Collectors.toList());
    }

    /**
     * Adds a new product to the database.
     * 
     * @param product The product to be created and stored.
     */
    public void createProduct(Product product) {
         dbConnection.getProducts().add(product);
    }

}
