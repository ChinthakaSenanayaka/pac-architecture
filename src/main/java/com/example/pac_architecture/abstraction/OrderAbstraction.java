package com.example.pac_architecture.abstraction;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import com.example.pac_architecture.db.DummyDBData;
import com.example.pac_architecture.model.Order;
import com.example.pac_architecture.model.Product;
import com.example.pac_architecture.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderAbstraction {

    @Autowired
    private DummyDBData dbConnection;

    public List<Order> getOrdersForCustomer(User customer) {
        return dbConnection.getOrders().stream()
            .filter(order -> order.getCustomer().getId() == customer.getId())
            .collect(Collectors.toList());
    }

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

}
