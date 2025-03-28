package com.example.pac_architecture.abstraction;

import com.example.pac_architecture.db.DummyDBData;
import com.example.pac_architecture.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LandingPageAbstraction {

    @Autowired
    private DummyDBData dbConnection;

    public User getUser(int id) {
        return dbConnection.getUser().stream()
            .filter(user -> user.getId() == id).findFirst().get();
    }

}
