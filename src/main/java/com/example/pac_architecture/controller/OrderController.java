package com.example.pac_architecture.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.pac_architecture.abstraction.OrderAbstraction;
import com.example.pac_architecture.model.Order;
import com.example.pac_architecture.model.User;
import com.example.pac_architecture.model.UserType;

@Controller
public class OrderController {

    @Autowired
    private OrderAbstraction orderAbstraction;

    public List<Order> getOrdersForUser(User user) {
        if(user.getUserType() == UserType.CUSTOMER) {
            return orderAbstraction.getOrdersForCustomer(user);
        } else {
            return orderAbstraction.getOrdersForSeller(user);
        }
    }

}