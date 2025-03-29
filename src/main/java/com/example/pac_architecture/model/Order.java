package com.example.pac_architecture.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Represents an order placed by a customer, containing information about the order's ID, customer, and products.
 */
@Data
@AllArgsConstructor
public class Order {

    /** The unique identifier for the order. */
    private int id;

    /** The customer who placed the order. */
    private User customer;

    /** The list of products included in the order. */
    private List<Product> products;

}
