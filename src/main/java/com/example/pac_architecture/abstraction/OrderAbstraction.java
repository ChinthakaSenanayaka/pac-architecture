package com.example.pac_architecture.abstraction;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.pac_architecture.db.DummyDBData;
import com.example.pac_architecture.model.Order;
import com.example.pac_architecture.model.Product;
import com.example.pac_architecture.model.User;

/**
 * Provides abstraction for handling orders,  
 * allowing retrieval and creation of orders for customers and sellers.
 */
@Component
public class OrderAbstraction {

    /**  
     * Database connection providing access to order data.  
     */
    @Autowired
    private DummyDBData dbConnection;

    /**
     * Retrieves all orders placed by a specific customer.
     * 
     * @param customer The customer whose orders are to be retrieved.
     * @return A list of orders associated with the given customer.
     */
    public List<Order> getOrdersForCustomer(User customer) {
        return dbConnection.getOrders().stream()
            .filter(order -> order.getCustomer().getId() == customer.getId())
            .collect(Collectors.toList());
    }

    /**
     * Retrieves all orders that contain products sold by a specific seller.
     * 
     * @param seller The seller whose associated orders are to be retrieved.
     * @return A list of orders that contain products sold by the given seller.
     */
    public List<Order> getOrdersForSeller(User seller) {
        return dbConnection.getOrders().stream()
        .map(order -> {
            List<Product> productsForSellerInOrder = order.getProducts().stream()
                .filter(product -> product.getSeller().getId() == seller.getId())
                .collect(Collectors.toList());
            
            return productsForSellerInOrder.isEmpty() ? null : order;
        })
        .filter(Objects::nonNull)
        .collect(Collectors.toList());
    }

    /**
     * Adds a new order to the database.
     * 
     * @param order The order to be created and stored.
     */
    public void createOrder(Order order) {
        dbConnection.getOrders().add(order);
    }

}
