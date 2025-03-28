package com.example.pac_architecture.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product {

    private int id;

    private String name;

    private int quantity;

    private User seller;

}
