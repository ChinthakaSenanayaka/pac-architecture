package com.example.pac_architecture.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import com.example.pac_architecture.db.DummyDBData;
import com.example.pac_architecture.model.Product;
import com.example.pac_architecture.model.User;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class ProductControllerTests {

	@LocalServerPort
	private int port;

	@Autowired
	private ProductController productController;

	@Autowired
	private TestRestTemplate restTemplate;

	@Autowired
	private DummyDBData dbData;

	@Test
	void contextLoads() throws Exception {
		assertThat(productController).isNotNull();
	}

	// Tests presenting the product sub-page by the controller with the products listed by the seller
	@Test
	void productControllerSellerTest() {
		int userId = 2;
		List<User> users = dbData.getUser();
		List<Product> products = dbData.getProducts();
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/product/" + userId,
				String.class))
				.contains("Products:")
				.contains(products.get(0).getName())
				.contains(users.get(userId).getFirstName())
				.contains(products.get(1).getName())
				.doesNotContain(users.get(3).getFirstName());
	}

	// Tests presenting the product sub-page by the controller with all the products from all the sellers
	@Test
	void productControllerCustomerTest() {
		int userId = 1;
		List<User> users = dbData.getUser();
		List<Product> products = dbData.getProducts();
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/product/" + userId,
				String.class))
				.contains("Products:")
				.contains(products.get(0).getName())
				.contains(products.get(0).getSeller().getFirstName())
				.contains(products.get(1).getName())
				.contains(users.get(3).getFirstName());
	}

}
