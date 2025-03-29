package com.example.pac_architecture.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Represents a product being sold by a seller, containing information about the product's ID, name, quantity, and the seller.
 */
@Data
@AllArgsConstructor
public class Product {

    /** The unique identifier for the product. */
    private int id;

    /** The name of the product. */
    private String name;

    /** The quantity available for the product. */
    private int quantity;

    /** The seller offering the product for sale. */
    private User seller;

}
