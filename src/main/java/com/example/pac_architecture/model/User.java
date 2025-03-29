package com.example.pac_architecture.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Represents a user in the system, which can either be a customer or a seller.
 * Contains information about the user's ID, type, name, address, and account number.
 */
@Data
@AllArgsConstructor
public class User {

    /** The unique identifier for the user. */
    private int id;

    /** The type of user (either CUSTOMER or SELLER). */
    private UserType userType;

    /** The first name of the user. */
    private String firstName;

    /** The last name of the user. */
    private String lastName;

    /** The address of the user. */
    private String address;

    /** The account number of the user. */
    private String accountNo;

}
