package com.example.pac_architecture.controller;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class ProductControllerTests {

	@LocalServerPort
	private int port;

	@Autowired
	private ProductController productController;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	void contextLoads() throws Exception {
		assertThat(productController).isNotNull();
	}

	// Tests presenting the product sub-page by the controller with the products listed by the seller
	@Test
	void productControllerSellerTest() {
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/product/1",
				String.class))
				.contains("This is the sample product presenter")
				.contains("Product0")
				.contains("seller 2")
				.contains("Product1")
				.contains("seller 3");
	}

	// Tests presenting the product sub-page by the controller with all the products from all the sellers
	@Test
	void productControllerCustomerTest() {
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/product/2",
				String.class))
				.contains("This is the sample product presenter")
				.contains("Product0")
				.contains("seller 2")
				.contains("Product1")
				.doesNotContain("seller 3");
	}

}
