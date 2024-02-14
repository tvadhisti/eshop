package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Iterator;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ProductRepositoryTest {
    @InjectMocks
    ProductRepository productRepository;

    @BeforeEach
    void setUp() {
    }

    @Test
    void testCreateAndFind() {
        Product product = new Product();
        product.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product.setProductName("Sampo Cap Bambang");
        product.setProductQuantity(100);
        productRepository.create(product);

        Iterator<Product> productIterator = productRepository.findAll();
        assertTrue(productIterator.hasNext());
        Product savedProduct = productIterator.next();
        assertEquals(product.getProductId(), savedProduct.getProductId());
        assertEquals(product.getProductName(), savedProduct.getProductName());
        assertEquals(product.getProductQuantity(), savedProduct.getProductQuantity());
    }

    @Test
    void testFindAllIfEmpty() {
        Iterator<Product> productIterator = productRepository.findAll();
        assertFalse(productIterator.hasNext());
    }

    @Test
    void testFindAllIfMoreThanOneProduct() {
        Product product1 = new Product();
        product1.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product1.setProductName("Sampo Cap Bambang");
        product1.setProductQuantity(100);
        productRepository.create(product1);

        Product product2 = new Product();
        product2.setProductId("a0f9de46-90b1-437d-a0bf-d0821dde9096");
        product2.setProductName("Sampo Cap Usep.");
        product2.setProductQuantity(50);
        productRepository.create(product2);

        Iterator<Product> productIterator = productRepository.findAll();
        assertTrue(productIterator.hasNext());
        Product savedProduct = productIterator.next();
        assertEquals(product1.getProductId(), savedProduct.getProductId());
        savedProduct = productIterator.next();
        assertEquals(product2.getProductId(), savedProduct.getProductId());
        assertFalse(productIterator.hasNext());
    }

    @Test
    void testEditProductWithOneProduct() {
        // Given
        Product originalProduct = new Product();
        originalProduct.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        originalProduct.setProductName("Sampo Cap Bambang");
        originalProduct.setProductQuantity(50);
        productRepository.create(originalProduct);

        Product updatedProduct = new Product();
        updatedProduct.setProductId(originalProduct.getProductId());
        updatedProduct.setProductName("Women's Blouse");
        updatedProduct.setProductQuantity(20);

        // When
        productRepository.editProduct(updatedProduct);

        // Then
        Iterator<Product> productIterator = productRepository.findAll();
        assertTrue(productIterator.hasNext());
        Product savedProduct = productIterator.next();

        assertEquals(updatedProduct.getProductId(), savedProduct.getProductId());
        assertEquals(updatedProduct.getProductName(), savedProduct.getProductName());
        assertEquals(updatedProduct.getProductQuantity(), savedProduct.getProductQuantity());
        assertFalse(productIterator.hasNext());
    }

    @Test
    void testEditNonExistingProduct() {
        // Given
        Product editedProduct = new Product();
        editedProduct.setProductId("not-exist");
        editedProduct.setProductName("White Dress");
        editedProduct.setProductQuantity(300);

        // When
        Product result = productRepository.editProduct(editedProduct);

        // Then
        assertNull(result);
    }

    @Test
    void testDeleteProduct() {
        Product product1 = new Product();
        product1.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product1.setProductId("Sampo Cap Bambang");
        product1.setProductQuantity(100);
        productRepository.create(product1);

        productRepository.delete(product1.getProductId());

        Iterator<Product> productIterator = productRepository.findAll();
        assertFalse(productIterator.hasNext());
    }

    @Test
    void testEditWithMultipleProducts() {
        Product product1 = new Product();
        product1.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product1.setProductName("Sampo Cap Bambang");
        product1.setProductQuantity(100);
        productRepository.create(product1);

        Product product2 = new Product();
        product2.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product2.setProductName("Dress");
        product2.setProductQuantity(50);
        productRepository.create(product2);

        Product product3 = new Product();
        product3.setProductId(product1.getProductId());
        product3.setProductName("Dress");
        product3.setProductQuantity(50);
        productRepository.editProduct(product3);

        Product product4 = new Product();
        product4.setProductId(product2.getProductId());
        product4.setProductName("Dress");
        product4.setProductQuantity(50);
        productRepository.editProduct(product4);

        Iterator<Product> productIterator = productRepository.findAll();

        assertTrue(productIterator.hasNext());
        Product savedProduct = productIterator.next();
        assertEquals(product1.getProductId(), savedProduct.getProductId());
        assertEquals(product3.getProductId(), savedProduct.getProductId());
        assertEquals(product3.getProductName(), savedProduct.getProductName());
        assertEquals(product3.getProductQuantity(), savedProduct.getProductQuantity());

        assertTrue(productIterator.hasNext());
        savedProduct = productIterator.next();
        assertEquals(product2.getProductId(), savedProduct.getProductId());
        assertEquals(product4.getProductId(), savedProduct.getProductId());
        assertEquals(product4.getProductName(), savedProduct.getProductName());
        assertEquals(product4.getProductQuantity(), savedProduct.getProductQuantity());
        assertFalse(productIterator.hasNext());
    }

}