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

@Component
public class DummyDBData {

    private List<User> customers;

    private List<User> sellers;

    private List<User> users;

    private List<Product> products;

    private List<Order> orders;

    public void init() {
        initUsers();
        initProducts();
        initOrders();
    }

    private void initUsers() {
        customers = new ArrayList<>();
        customers.add(
            new User(0, UserType.CUSTOMER, "custFName0", 
            "custLName0", "custAddr0", "custAccNo0"));
        customers.add(
            new User(2, UserType.CUSTOMER, "custFName1", 
            "custLName1", "custAddr1", "custAccNo1"));
        
        sellers = new ArrayList<>();
        sellers.add(
            new User(1, UserType.SELLER, "sellerFName0", 
            "sellerLName0", "sellerAddr0", "sellerAccNo0"));
        sellers.add(
            new User(3, UserType.SELLER, "sellerFName1", 
            "sellerLName1", "sellerAddr1", "sellerAccNo1"));

        users = Stream.concat(customers.stream(), sellers.stream())
                         .collect(Collectors.toList());
    }

    private void initProducts() {
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

    private void initOrders() {
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

    public List<User> getUser() {
        return users;
    }

    public List<User> getSellers() {
        return sellers;
    }

    public List<User> getCustomers() {
        return customers;
    }

    public List<Product> getProducts() {
        return products;
    }

    public List<Order> getOrders() {
        return orders;
    }

}
