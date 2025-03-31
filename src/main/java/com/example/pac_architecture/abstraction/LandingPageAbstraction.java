package com.example.pac_architecture.abstraction;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.pac_architecture.db.DummyDBData;
import com.example.pac_architecture.model.User;

/**
 * This class serves as an abstraction layer for the landing page,  
 * providing methods to interact with user data.
 */
@Component
public class LandingPageAbstraction {

    /**  
     * Database connection providing access to user data.  
     */
    @Autowired
    private DummyDBData dbConnection;

    /**
     * Retrieves a user from the database based on the given ID.
     * 
     * @param id The unique identifier of the user to search for.
     * @return The user corresponding to the given ID.
     * @throws NoSuchElementException if no user with the given ID is found.
     */
    public User getUser(int id) {
        return dbConnection.getUser().stream()
            .filter(user -> user.getId() == id).findFirst().get();
    }

}
