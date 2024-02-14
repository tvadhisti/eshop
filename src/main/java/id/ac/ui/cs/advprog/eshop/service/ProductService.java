package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Product;
import java.util.List;
public interface ProductService {
    Product create(Product product);
    List<Product> findAll();
    Product getProductId(String id);
    void deleteProductById(String id);
    Product editProduct(Product product);
}
