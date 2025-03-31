package com.example.pac_architecture.abstraction;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.pac_architecture.db.DummyDBData;
import com.example.pac_architecture.model.User;
import com.example.pac_architecture.model.Product;
import com.example.pac_architecture.model.Order;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class OrderAbstractionTests {

    @Autowired
    private DummyDBData dbData;

    @Autowired
	private LandingPageAbstraction landingPageAbstraction;

    @Autowired
	private OrderAbstraction orderAbstraction;

    @BeforeEach
    void beforeEachTest() {
        dbData.init();
    }

    @Test
	void contextLoads() throws Exception {
		assertThat(orderAbstraction).isNotNull();
	}

    // Test retrieving orders made by a customer for the customer sub-view
    @Test
	void getOrdersForCustomerTest() throws Exception {
        int customerId = 0;
        User customer = landingPageAbstraction.getUser(customerId);
        List<Order> orders = orderAbstraction.getOrdersForCustomer(customer);
        assertEquals(customerId, orders.get(0).getCustomer().getId());
        assertEquals(dbData.getProducts().get(0).getName(), 
                    orders.get(0).getProducts().get(0).getName());
	}

    // Test retrieving orders made to a seller for the seller sub-view
    @Test
	void getOrdersForSellerTest() throws Exception {
        int sellerId = 3;
        User seller = landingPageAbstraction.getUser(sellerId);
        List<Order> orders = orderAbstraction.getOrdersForSeller(seller);
        assertEquals(3, orders.size());
        assertEquals(sellerId, orders.get(0).getProducts().get(1).getSeller().getId());
	}

    // Test creating an order from a customer for a product listed by a seller
    @Test
	void createOrderTest() throws Exception {
        int customerId = 0;
        User customer = landingPageAbstraction.getUser(customerId);
        int sellerId = 1;
        User seller = landingPageAbstraction.getUser(sellerId);
        Product product = new Product(4, "Product4", 100, seller);
        List<Product> products = new ArrayList<>();
        products.add(product);
        Order order = new Order(3, customer, products);

        orderAbstraction.createOrder(order);
        List<Order> ordersForCustomer = orderAbstraction.getOrdersForCustomer(customer);
        int orderIndex = ordersForCustomer.size() - 1;
        assertEquals(customerId, ordersForCustomer.get(orderIndex).getCustomer().getId());
        assertEquals(product.getName(), 
                ordersForCustomer.get(orderIndex).getProducts().get(0).getName());
        
        List<Order> ordersForSeller = orderAbstraction.getOrdersForSeller(seller);
        orderIndex = ordersForSeller.size() - 1;
        assertEquals(product.getName(), ordersForSeller.get(orderIndex).getProducts().get(0).getName());
        assertEquals(sellerId, ordersForSeller.get(orderIndex).getProducts().get(0).getSeller().getId());
	}

}
