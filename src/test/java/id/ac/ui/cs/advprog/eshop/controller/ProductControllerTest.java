package id.ac.ui.cs.advprog.eshop.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import id.ac.ui.cs.advprog.eshop.repository.ProductRepository;
import org.mockito.*;

import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.ui.Model;

import java.util.Arrays;
import java.util.List;

public class ProductControllerTest {

    @Mock
    private ProductService productService;

    @Mock
    private Model model;

    @InjectMocks
    private ProductController productController;

    @InjectMocks
    ProductRepository productRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateProductPage() {
        String expectedViewName = "createProduct";
        Product expectedProduct = new Product(); // Initialize with necessary fields
        when(model.addAttribute(eq("product"), any(Product.class))).thenReturn(model);

        String actualViewName = productController.createProductPage(model);

        assertEquals(expectedViewName, actualViewName);
        verify(model, times(1)).addAttribute(eq("product"), any(Product.class));
    }

    @Test
    void TestProductListPage() {
        Product product1 = new Product();
        product1.setId("hq719e9f-1hs7-sjs7-9222-10hd0aj27sp6");
        product1.setName("Love bonito white short");
        product1.setQuantity(15);
        productRepository.create(product1);

        Product product2 = new Product();
        product2.setId("k1g7pp00-sh28-sjs8-k871-s7102jjs8269");
        product2.setName("Nike dunk");
        product2.setQuantity(10);
        productRepository.create(product2);

        List<Product> expectedProducts = Arrays.asList(product1, product2);

        when(productService.findAll()).thenReturn(expectedProducts);

        // When
        String actualViewName = productController.productListPage(model);

        // Then
        assertEquals("productList", actualViewName);
        verify(model, times(1)).addAttribute(eq("products"), anyList());
        verify(productService, times(1)).findAll();
    }
}
