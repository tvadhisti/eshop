package id.ac.ui.cs.advprog.eshop;

import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.repository.ProductRepository;
import id.ac.ui.cs.advprog.eshop.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ProductEditDeleteTest {
    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    private Product product;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        product = new Product();
        product.setId("testProductId");
        product.setName("Test Product");
        product.setQuantity(10);
    }

//    @Test
//    void editProduct_Success() {
//        when(productRepository.editProduct(product)).thenReturn(product);
//        Product editedProduct = productService.editProduct(product);
//        assertEquals(product.getProductId(), editedProduct.getProductId());
//        verify(productRepository, times(1)).editProduct(product);
//    }

//    @Test
//    void deleteProductById_Success() {
//        when(productRepository.deleteProduct(product)).thenReturn(true);
//        boolean isDeleted = productService.deleteProductById(product.getProductId());
//        assertTrue(isDeleted);
//        verify(productRepository, times(1)).deleteProduct(product);
//    }

//    @Test
//    void deleteProductById_Failure() {
//        when(productRepository.deleteProduct(product)).thenReturn(false);
//        boolean isDeleted = productService.deleteProductById("nonExistingProductId");
//        assertFalse(isDeleted);
//        verify(productRepository, times(1)).deleteProduct(any(Product.class));
//    }
}
