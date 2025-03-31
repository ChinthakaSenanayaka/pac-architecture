package com.example.pac_architecture.controller;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class LandingPageControllerTests {

	@LocalServerPort
	private int port;

	@Autowired
	private LandingPageController landingPageController;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	void contextLoads() throws Exception {
		assertThat(landingPageController).isNotNull();
	}

	// Tests presenting the landing page by the controller for the seller based on the login
	@Test
	void landingPageControllerSellerTest() {
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/1",
				String.class))
				.contains("This is the sample landing page presenter")
				.contains("user ID: 1")
				.contains("User role: CUSTOMER");
	}

	// Tests presenting the landing page by the controller for the customer based on the login
	@Test
	void getLandingPageControllerCustomerTest() {
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/2",
				String.class))
				.contains("This is the sample landing page presenter")
				.contains("user ID: 2")
				.contains("User role: SELLER");
	}

}
