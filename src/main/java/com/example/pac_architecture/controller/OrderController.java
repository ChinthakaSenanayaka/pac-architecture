package com.example.pac_architecture.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.pac_architecture.abstraction.OrderAbstraction;
import com.example.pac_architecture.model.Order;
import com.example.pac_architecture.model.User;
import com.example.pac_architecture.model.UserType;

/**
 * Controller responsible for managing orders,  
 * providing methods to retrieve and create orders for users.
 */
@Controller
public class OrderController {

    /**  
     * Abstraction layer for handling order-related operations.  
     */
    @Autowired
    private OrderAbstraction orderAbstraction;

    /**
     * Retrieves a list of orders associated with a given user.  
     * If the user is a customer, it returns their placed orders.  
     * If the user is a seller, it returns orders containing their products.
     * 
     * @param user The user whose orders are to be retrieved.
     * @return A list of orders corresponding to the user's role.
     */
    public List<Order> getOrdersForUser(User user) {
        if(user.getUserType() == UserType.CUSTOMER) {
            return orderAbstraction.getOrdersForCustomer(user);
        } else {
            return orderAbstraction.getOrdersForSeller(user);
        }
    }

    /**
     * Creates a new order and adds it to the database.
     * 
     * @param order The order to be created.
     */
    public void createOrder(Order order) {
        orderAbstraction.createOrder(order);
    }

}
