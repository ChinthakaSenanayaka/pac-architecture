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
import com.example.pac_architecture.model.Order;
import com.example.pac_architecture.model.Product;
import com.example.pac_architecture.model.User;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class OrderControllerTests {

	@LocalServerPort
	private int port;

	@Autowired
	private OrderController orderController;

	@Autowired
	private TestRestTemplate restTemplate;

	@Autowired
	private DummyDBData dbData;

	@Test
	void contextLoads() throws Exception {
		assertThat(orderController).isNotNull();
	}

	// Tests presenting the order sub-page by the controller with all the orders for the seller
	@Test
	void orderControllerSellerTest() {
		int userId = 2;
		User seller = dbData.getUser().get(userId);
		List<Order> orders = dbData.getOrders();
		List<Product> productsForOrder0 = orders.get(0).getProducts();
		List<Product> productsForOrder2 = orders.get(2).getProducts();

		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/order/" + userId,
				String.class))
				.contains("Orders:")
				.contains(productsForOrder0.get(0).getName())
				.contains(productsForOrder2.get(0).getName())
				.contains(orders.get(0).getCustomer().getFirstName())
				.contains(orders.get(2).getCustomer().getFirstName())
				.doesNotContain(dbData.getUser().get(3).getFirstName());
	}

	// Tests presenting the order sub-page by the controller with the orders by the customer
	@Test
	void orderControllerCustomerTest() {
		int userId = 1;
		List<Order> orders = dbData.getOrders();
		List<Product> productsForOrder2 = orders.get(2).getProducts();
		
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/order/" + userId,
				String.class))
				.contains("Orders:")
				.contains(productsForOrder2.get(0).getName())
				.contains(orders.get(1).getCustomer().getFirstName())
				.doesNotContain(dbData.getProducts().get(0).getName())
				.doesNotContain(dbData.getUser().get(0).getFirstName());
	}

}
