package com.example.pac_architecture.db;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Component;

import com.example.pac_architecture.model.Order;
import com.example.pac_architecture.model.Product;
import com.example.pac_architecture.model.User;
import com.example.pac_architecture.model.UserType;

/**
 * Simulated database storage using in-memory lists.  
 * Provides initialization and access to dummy users, products, and orders.
 */
@Component
public class DummyDBData {

    /** List of customers in the system. */
    private List<User> customers;

    /** List of sellers in the system. */
    private List<User> sellers;

    /** Combined list of all users (customers and sellers). */
    private List<User> users;

    /** List of available products. */
    private List<Product> products;

    /** List of recorded orders. */
    private List<Order> orders;

    /**
     * Initializes the dummy database by populating users, products, and orders.
     */
    public void init() {
        initUsers();
        initProducts();
        initOrders();
    }

    /**
     * Initializes dummy users (customers and sellers).
     */
    private void initUsers() {
        if(customers == null) {
            customers = new ArrayList<>();
            customers.add(
                new User(0, UserType.CUSTOMER, "customer 0", 
                "Doe", "customer address 0", "123456"));
            customers.add(
                new User(1, UserType.CUSTOMER, "customer 1", 
                "Williams", "customer address 1", "234567"));
        }

        if(sellers == null) {
            sellers = new ArrayList<>();
            sellers.add(
                new User(2, UserType.SELLER, "seller 2", 
                "Taylor", "seller address 2", "345678"));
            sellers.add(
                new User(3, UserType.SELLER, "seller 3", 
                "Wilson", "sellerAddr1", "456789"));
        }

        if(users == null) {
            users = Stream.concat(customers.stream(), sellers.stream())
                         .collect(Collectors.toList());
        }
    }

    /**
     * Initializes dummy products associated with sellers.
     */
    private void initProducts() {
        if(products == null) {
            products = new ArrayList<>();
            products.add(
                new Product(0, "Product0", 100, sellers.get(0)));
            products.add(
                new Product(1, "Product1", 100, sellers.get(0)));
            
            products.add(
                new Product(2, "Product2", 100, sellers.get(1)));
            products.add(
                new Product(3, "Product3", 100, sellers.get(1)));
        }
    }

    /**
     * Initializes dummy orders made by customers.
     * Each order contains multiple products from different sellers.
     */
    private void initOrders() {
        if(orders == null) {
            orders = new ArrayList<>();

            List<Product> productsForOrder0 = new ArrayList<>();
            productsForOrder0.add(products.get(0));
            productsForOrder0.add(products.get(3));
            orders.add(
                new Order(0, customers.get(0), productsForOrder0));

            List<Product> productsForOrder1 = new ArrayList<>();
            productsForOrder1.add(products.get(1));
            productsForOrder1.add(products.get(3));
            orders.add(
                new Order(1, customers.get(1), productsForOrder1));

            List<Product> productsForOrder2 = new ArrayList<>();
            productsForOrder2.add(products.get(1));
            productsForOrder2.add(products.get(2));
            orders.add(
                new Order(2, customers.get(1), productsForOrder2));
        }
    }

    /**
     * Retrieves the list of all users (customers and sellers).
     * 
     * @return A list of all users.
     */
    public List<User> getUser() {
        return users;
    }

    /**
     * Retrieves the list of sellers.
     * 
     * @return A list of sellers.
     */
    public List<User> getSellers() {
        return sellers;
    }

    /**
     * Retrieves the list of customers.
     * 
     * @return A list of customers.
     */
    public List<User> getCustomers() {
        return customers;
    }

    /**
     * Retrieves the list of available products.
     * 
     * @return A list of products.
     */
    public List<Product> getProducts() {
        return products;
    }

    /**
     * Retrieves the list of recorded orders.
     * 
     * @return A list of orders.
     */
    public List<Order> getOrders() {
        return orders;
    }

}
