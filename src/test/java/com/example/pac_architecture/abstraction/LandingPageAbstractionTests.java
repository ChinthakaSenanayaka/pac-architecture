package com.example.pac_architecture.abstraction;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.pac_architecture.db.DummyDBData;
import com.example.pac_architecture.model.User;
import com.example.pac_architecture.model.UserType;

@SpringBootTest
public class LandingPageAbstractionTests {

    @Autowired
    private DummyDBData dummyDBData;

    @Autowired
	private LandingPageAbstraction landingPageAbstraction;

    @BeforeEach
    void beforeEachTest() {
        dummyDBData.init();
    }

    @Test
	void contextLoads() throws Exception {
		assertThat(landingPageAbstraction).isNotNull();
	}

    // Test retrieving a customer
    @Test
	void customerTest() throws Exception {
        int customerId = 0;
        User customer = landingPageAbstraction.getUser(customerId);
        assertEquals(customerId, customer.getId());
        assertEquals(UserType.CUSTOMER, customer.getUserType());
	}

    // Test retrieving a seler
    @Test
	void sellerTest() throws Exception {
        int sellerId = 1;
        User seller = landingPageAbstraction.getUser(sellerId);
        assertEquals(sellerId, seller.getId());
        assertEquals(UserType.SELLER, seller.getUserType());
	}

}
