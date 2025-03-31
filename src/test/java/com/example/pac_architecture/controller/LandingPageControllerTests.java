package com.example.pac_architecture.controller;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import com.example.pac_architecture.db.DummyDBData;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class LandingPageControllerTests {

	@LocalServerPort
	private int port;

	@Autowired
	private LandingPageController landingPageController;

	@Autowired
	private TestRestTemplate restTemplate;

	@Autowired
	private DummyDBData dbData;

	@Test
	void contextLoads() throws Exception {
		assertThat(landingPageController).isNotNull();
	}

	// Tests presenting the landing page by the controller for the seller based on the login
	@Test
	void landingPageControllerSellerTest() {
		int userId = 2;
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/" + userId,
				String.class))
				.contains("Welcome")
				.contains(dbData.getUser().get(userId).getFirstName())
				.contains(dbData.getUser().get(userId).getUserType().name());
	}

	// Tests presenting the landing page by the controller for the customer based on the login
	@Test
	void getLandingPageControllerCustomerTest() {
		int userId = 1;
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/" + userId,
				String.class))
				.contains("Welcome")
				.contains(dbData.getUser().get(userId).getFirstName())
				.contains(dbData.getUser().get(userId).getUserType().name());
	}

}
