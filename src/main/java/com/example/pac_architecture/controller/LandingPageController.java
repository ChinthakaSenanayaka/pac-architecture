package com.example.pac_architecture.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.pac_architecture.abstraction.LandingPageAbstraction;
import com.example.pac_architecture.db.DummyDBData;
import com.example.pac_architecture.model.Order;
import com.example.pac_architecture.model.Product;
import com.example.pac_architecture.model.User;

/**
 * Controller responsible for handling landing page requests  
 * and managing interactions between users, products, and orders.
 */
@Controller
public class LandingPageController {

    /**  
     * Dummy database instance used to initialize and store data.  
     */
    @Autowired
    private DummyDBData dummyDBData;

    /**  
     * Abstraction layer for handling user retrieval.  
     */
    @Autowired
    private LandingPageAbstraction landPageAbs;

    /**  
     * Controller for handling product-related requests.  
     */
    @Autowired
    private ProductController productController;

    /**  
     * Controller for handling order-related requests.  
     */
    @Autowired
    private OrderController orderController;

    /**
     * Handles requests to load the landing page for a given user.  
     * Initializes database data if necessary.
     * 
     * @param userId  The ID of the user requesting the landing page.
     * @param request The HTTP request object.
     * @param response The HTTP response object.
     * @return The name of the landing page view.
     */
    @RequestMapping("/{userId}")
    public String getLandingPagePresenter(@PathVariable int userId,
            HttpServletRequest request, HttpServletResponse response) {
        
        // This is to save initial data to DB
        dummyDBData.init();

        User user = landPageAbs.getUser(userId);
        request.setAttribute("user", user);

        return "LandingPagePresenter";
    }

    /**
     * Handles requests to load the order page for a given user.  
     * Retrieves the user's orders and sets them in the request attributes.
     * 
     * @param userId  The ID of the user requesting the order page.
     * @param request The HTTP request object.
     * @param response The HTTP response object.
     * @return The name of the order page view.
     */
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

    /**
     * Handles requests to load the product page for a given user.  
     * Retrieves the user's available products and sets them in the request attributes.
     * 
     * @param userId  The ID of the user requesting the product page.
     * @param request The HTTP request object.
     * @param response The HTTP response object.
     * @return The name of the product page view.
     */
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

    /**
     * Handles HTTP POST requests to create a new order.
     * 
     * @param order The order data received in the request body.
     * @return A response message indicating the result.
     */
    @PostMapping("/order")
    public @ResponseBody String createOrder(@RequestBody Order order) {

        System.out.println("Create order Id: " + order.getId());
        orderController.createOrder(order);

        return "Order Created";
    }

    /**
     * Handles HTTP POST requests to create a new product.
     * 
     * @param product The product data received in the request body.
     * @return A response message indicating the result.
     */
    @PostMapping("/product")
    public @ResponseBody String createProduct(@RequestBody Product product) {

        System.out.println("Create product Id: " + product.getId());
        productController.createProduct(product);
        
        return "Product Created";
    }

}
