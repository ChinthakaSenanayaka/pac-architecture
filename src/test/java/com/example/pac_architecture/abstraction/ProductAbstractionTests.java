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

import java.util.List;

@SpringBootTest
public class ProductAbstractionTests {

    @Autowired
    private DummyDBData dbData;

    @Autowired
	private LandingPageAbstraction landingPageAbstraction;

    @Autowired
	private ProductAbstraction productAbstraction;

    @BeforeEach
    void beforeEachTest() {
        dbData.init();
    }

    @Test
	void contextLoads() throws Exception {
		assertThat(productAbstraction).isNotNull();
	}

    // Test retrieving all products for the customer sub-view
    @Test
	void getAllProductsForCustomerTest() throws Exception {
        List<Product> products = productAbstraction.getAllProducts();
        assertEquals(dbData.getProducts().get(0).getName(), products.get(0).getName());
        assertEquals(dbData.getSellers().get(0).getFirstName(), 
                    products.get(0).getSeller().getFirstName());
	}

    // Test retrieving products listed by a seller for the seller sub-view
    @Test
	void getProductsForSellerTest() throws Exception {
        int sellerId = 3;
        User seller = landingPageAbstraction.getUser(sellerId);
        List<Product> productsForSeller = productAbstraction.getProductsForSeller(seller);
        assertEquals(dbData.getProducts().get(2).getName(), productsForSeller.get(0).getName());
        assertEquals(sellerId, productsForSeller.get(0).getSeller().getId());
	}

    // Test creating a product from a seller
    @Test
	void createProductTest() throws Exception {
        int sellerId = 1;
        User seller = landingPageAbstraction.getUser(sellerId);
        Product product = new Product(4, "Product4", 100, seller);

        productAbstraction.createProduct(product);
        List<Product> productsForSeller = productAbstraction.getProductsForSeller(seller);
        int productIndex = productsForSeller.size() - 1;
        assertEquals(product.getName(), productsForSeller.get(productIndex).getName());
        assertEquals(sellerId, productsForSeller.get(productIndex).getSeller().getId());
	}

}
