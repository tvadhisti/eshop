package id.ac.ui.cs.advprog.eshop.model;

import id.ac.ui.cs.advprog.eshop.repository.ProductRepository;
import id.ac.ui.cs.advprog.eshop.service.ProductService;
import id.ac.ui.cs.advprog.eshop.service.ProductServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ProductServiceImplTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductServiceImpl productService;

    @BeforeEach
    void setUp() {

        MockitoAnnotations.initMocks(this);

        List<Product> productList = new ArrayList<>();
        Product product1 = new Product();
        product1.setProductId("1");
        product1.setProductName("1");
        productList.add(product1);

        Product product2 = new Product();
        product2.setProductId("2");
        product2.setProductName("2");
        productList.add(product2);

        Product product3 = new Product();
        product3.setProductId("3");
        product3.setProductName("3");
        productList.add(product3);


        when(productRepository.findAll()).thenReturn(productList.iterator());
    }

    @Test
    void testAddingProduct() {
        Product product = new Product();
        product.setProductName("Test Item");

        when(productRepository.create(product)).thenReturn(product);

        Product createdProduct = productService.create(product);

        assertNotNull(createdProduct.getProductId());
        assertEquals(product.getProductName(), createdProduct.getProductName());

        verify(productRepository, times(1)).create(product);
    }

    @Test
    void testFetchingProductById() {
        // Test getting a product by ID
        Product result1 = productService.getProductId("1");
        Product result2 = productService.getProductId("2");
        Product result3 = productService.getProductId("3");
        Product result4 = productService.getProductId("4"); // Non-existing ID

        // Assert the results
        assertEquals("1", result1.getProductName());
        assertEquals("2", result2.getProductName());
        assertEquals("3", result3.getProductName());
        assertNull(result4); // No product found for ID "4"
    }
    @Test
    void testCreateAndFind(){
        Product product = new Product();
        product.setProductId("eb5shi9f-1c39-460e-si82-7128shf63bd6");
        product.setProductName("Sample Clothing");
        Product prodRep = productRepository.create(product);

    }

    @Test
    void testFindAll() {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product());
        productList.add(new Product());

        when(productRepository.findAll()).thenReturn(productList.iterator());

        List<Product> foundProducts = productService.findAll();

        assertEquals(productList.size(), foundProducts.size());

        int i = 0;
        for (Product expectedProduct : productList) {
            assertEquals(expectedProduct, foundProducts.get(i));
            i++;
        }

        verify(productRepository, times(1)).findAll();
    }



    @Test
    void testEditProduct() {

        Product mockProduct = new Product();
        mockProduct.setProductId("7");
        mockProduct.setProductName("Product");


        when(productRepository.editProduct(mockProduct)).thenReturn(mockProduct);


        Product editedProduct = productService.editProduct(mockProduct);

        assertNotNull(editedProduct);
        assertEquals("7", editedProduct.getProductId());
        assertEquals("Product", editedProduct.getProductName());


        verify(productRepository, times(1)).editProduct(mockProduct);
    }




    @Test
    void testDeleteProduct() {
        String productId = "a2sj8719k-02h7-111k-28js-d0hs7dde9096";

        productService.deleteProductById(productId);

        verify(productRepository, times(1)).delete(productId);
    }

}