package com.example.pac_architecture.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import com.example.pac_architecture.abstraction.LandingPageAbstraction;
import com.example.pac_architecture.db.DummyDBData;
import com.example.pac_architecture.model.User;
import com.example.pac_architecture.model.Product;
import com.example.pac_architecture.model.Order;

@Controller
public class LandingPageController {

    @Autowired
    private DummyDBData dummyDBData;

    @Autowired
    private LandingPageAbstraction landPageAbs;

    @Autowired
    private ProductController productController;

    @Autowired
    private OrderController orderController;

    @RequestMapping("/{userId}")
    public String getLandingPagePresenter(@PathVariable int userId,
            HttpServletRequest request, HttpServletResponse response) {
        
        // This is to save initial data to DB
        dummyDBData.init();

        User user = landPageAbs.getUser(userId);
        request.setAttribute("user", user);

        return "LandingPagePresenter";
    }

    @RequestMapping("/order/{userId}")
    public String getOrderPresenter(@PathVariable int userId,
    HttpServletRequest request, HttpServletResponse response) {

        System.out.println("order userId: " + userId);
        User user = landPageAbs.getUser(userId);
        List<Order> orders = orderController.getOrdersForUser(user);

        request.setAttribute("user", user);
        request.setAttribute("orders", orders);

        return "OrderPresenter";
    }

    @RequestMapping("/product/{userId}")
    public String getProductPresenter(@PathVariable int userId,
    HttpServletRequest request, HttpServletResponse response) {

        System.out.println("product userId: " + userId);
        User user = landPageAbs.getUser(userId);
        List<Product> products = productController.getProductsForUser(user);

        request.setAttribute("user", user);
        request.setAttribute("products", products);
        
        return "ProductPresenter";
    }

}

