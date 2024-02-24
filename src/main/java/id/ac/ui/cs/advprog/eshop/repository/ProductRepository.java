package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

@Repository
public class ProductRepository implements ProductRepo{
    private List<Product> productData = new ArrayList<>();

    public Product create(Product product) {
        if(product.getId() == null){
            UUID uuid = UUID.randomUUID();
            product.setId(uuid.toString());
        }
        productData.add(product);
        return product;
    }

    public Iterator<Product> findAll() {
        return productData.iterator();
    }

    public Product findById(String productId) {
        for (Product product : productData) {
            if (product.getId().equals(productId)) {
                return product;
            }
        }
        return null;
    }

    public Product update(Product updatedProduct) {
        for (Product existingProduct : productData) {
            if (existingProduct.getId().equals(updatedProduct.getId())) {
                existingProduct.setName(updatedProduct.getName());
                existingProduct.setQuantity(updatedProduct.getQuantity());
                return updatedProduct;
            }
        }
        return null;
    }

    public void delete(String productId) {
        productData.removeIf(product -> product.getId().equals(productId));
    }
}