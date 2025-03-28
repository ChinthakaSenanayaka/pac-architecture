package com.example.pac_architecture.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {

    private int id;

    private UserType userType;

    private String firstName;

    private String lastName;

    private String address;

    private String accountNo;

}
