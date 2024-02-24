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
        product.setId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product.setName("Sampo Cap Bambang");
        product.setQuantity(100);
        productRepository.create(product);

        Iterator<Product> productIterator = productRepository.findAll();
        assertTrue(productIterator.hasNext());
        Product savedProduct = productIterator.next();
        assertEquals(product.getId(), savedProduct.getId());
        assertEquals(product.getName(), savedProduct.getName());
        assertEquals(product.getQuantity(), savedProduct.getQuantity());
    }

    @Test
    void testFindAllIfEmpty() {
        Iterator<Product> productIterator = productRepository.findAll();
        assertFalse(productIterator.hasNext());
    }

    @Test
    void testFindAllIfMoreThanOneProduct() {
        Product product1 = new Product();
        product1.setId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product1.setName("Sampo Cap Bambang");
        product1.setQuantity(100);
        productRepository.create(product1);

        Product product2 = new Product();
        product2.setId("a0f9de46-90b1-437d-a0bf-d0821dde9096");
        product2.setName("Sampo Cap Usep.");
        product2.setQuantity(50);
        productRepository.create(product2);

        Iterator<Product> productIterator = productRepository.findAll();
        assertTrue(productIterator.hasNext());
        Product savedProduct = productIterator.next();
        assertEquals(product1.getId(), savedProduct.getId());
        savedProduct = productIterator.next();
        assertEquals(product2.getId(), savedProduct.getId());
        assertFalse(productIterator.hasNext());
    }

    @Test
    void testEditProductWithOneProduct() {
        // Given
        Product originalProduct = new Product();
        originalProduct.setId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        originalProduct.setName("Sampo Cap Bambang");
        originalProduct.setQuantity(50);
        productRepository.create(originalProduct);

        Product updatedProduct = new Product();
        updatedProduct.setId(originalProduct.getId());
        updatedProduct.setName("Women's Blouse");
        updatedProduct.setQuantity(20);

        // When
        productRepository.update(updatedProduct);

        // Then
        Iterator<Product> productIterator = productRepository.findAll();
        assertTrue(productIterator.hasNext());
        Product savedProduct = productIterator.next();

        assertEquals(updatedProduct.getId(), savedProduct.getId());
        assertEquals(updatedProduct.getName(), savedProduct.getName());
        assertEquals(updatedProduct.getQuantity(), savedProduct.getQuantity());
        assertFalse(productIterator.hasNext());
    }

    @Test
    void testEditNonExistingProduct() {
        // Given
        Product editedProduct = new Product();
        editedProduct.setId("not-exist");
        editedProduct.setName("White Dress");
        editedProduct.setQuantity(300);

        // When
        Product result = productRepository.update(editedProduct);

        // Then
        assertNull(result);
    }

    @Test
    void testDeleteProduct() {
        Product product1 = new Product();
        product1.setId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product1.setId("Sampo Cap Bambang");
        product1.setQuantity(100);
        productRepository.create(product1);

        productRepository.delete(product1.getId());

        Iterator<Product> productIterator = productRepository.findAll();
        assertFalse(productIterator.hasNext());
    }

    @Test
    void testEditWithMultipleProducts() {
        Product product1 = new Product();
        product1.setId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product1.setName("Sampo Cap Bambang");
        product1.setQuantity(100);
        productRepository.create(product1);

        Product product2 = new Product();
        product2.setId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product2.setName("Dress");
        product2.setQuantity(50);
        productRepository.create(product2);

        Product product3 = new Product();
        product3.setId(product1.getId());
        product3.setName("Dress");
        product3.setQuantity(50);
        productRepository.update(product3);

        Product product4 = new Product();
        product4.setId(product2.getId());
        product4.setName("Dress");
        product4.setQuantity(50);
        productRepository.update(product4);

        Iterator<Product> productIterator = productRepository.findAll();

        assertTrue(productIterator.hasNext());
        Product savedProduct = productIterator.next();
        assertEquals(product1.getId(), savedProduct.getId());
        assertEquals(product3.getId(), savedProduct.getId());
        assertEquals(product3.getName(), savedProduct.getName());
        assertEquals(product3.getQuantity(), savedProduct.getQuantity());

        assertTrue(productIterator.hasNext());
        savedProduct = productIterator.next();
        assertEquals(product2.getId(), savedProduct.getId());
        assertEquals(product4.getId(), savedProduct.getId());
        assertEquals(product4.getName(), savedProduct.getName());
        assertEquals(product4.getQuantity(), savedProduct.getQuantity());
        assertFalse(productIterator.hasNext());
    }

}