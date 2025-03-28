package com.example.pac_architecture.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Order {

    private int id;

    private User customer;

    private List<Product> products;

}
