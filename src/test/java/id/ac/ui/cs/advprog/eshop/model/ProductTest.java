package id.ac.ui.cs.advprog.eshop.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class ProductTest {
    Product product;
    @BeforeEach
    void setUp() {
        this.product = new Product();
        this.product.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        this.product.setProductName("Sampo Cap Bambang");
        this.product.setProductQuantity(100);
    }
    @Test
    void testGetProductId() {
        assertEquals ( "eb558e9f-1c39-460e-8860-71af6af63bd6", this.product.getId());
    }
    @Test
    void testGetProductName() {
        assertEquals( "Sampo Cap Bambang", this.product.getProductName());
    }
    @Test
    void testGetProductQuantity() {
        assertEquals(100, this.product.getProductQuantity());
    }

    @Test
    void testSetProductId() {
        String newProductId = "new-product-id";
        this.product.setId(newProductId);
        assertEquals(newProductId, this.product.getId());
    }

    @Test
    void testSetProductName() {
        String newProductName = "New Product Name";
        this.product.setProductName(newProductName);
        assertEquals(newProductName, this.product.getProductName());
    }

    @Test
    void testSetProductQuantity() {
        int newProductQuantity = 200;
        this.product.setProductQuantity(newProductQuantity);
        assertEquals(newProductQuantity, this.product.getProductQuantity());
    }
}
