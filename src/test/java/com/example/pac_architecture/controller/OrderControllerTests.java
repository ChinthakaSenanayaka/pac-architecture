package com.example.pac_architecture.controller;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class OrderControllerTests {

	@LocalServerPort
	private int port;

	@Autowired
	private OrderController orderController;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	void contextLoads() throws Exception {
		assertThat(orderController).isNotNull();
	}

	// Tests presenting the order sub-page by the controller with all the orders for the seller
	@Test
	void orderControllerSellerTest() {
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/order/1",
				String.class))
				.contains("This is the sample order presenter")
				.contains("Product1")
				.contains("customer 1")
				.doesNotContain("Product0")
				.doesNotContain("customer 0");
	}

	// Tests presenting the order sub-page by the controller with the orders by the customer
	@Test
	void orderControllerCustomerTest() {
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/order/2",
				String.class))
				.contains("This is the sample order presenter")
				.contains("Product0")
				.contains("Product1")
				.contains("customer 0")
				.contains("customer 1")
				.doesNotContain("customer 2");
	}

}
