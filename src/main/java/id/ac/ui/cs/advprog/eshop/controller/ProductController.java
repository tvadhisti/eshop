package id.ac.ui.cs.advprog.eshop.controller;

import id.ac.ui.cs.advprog.eshop.model.Car;
import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.service.CarServiceImpl;

import id.ac.ui.cs.advprog.eshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService service;

    @GetMapping("/create")
    public String createProductPage(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        return "createProduct";
    }

    @PostMapping("/create")
    public String createProductPost(@ModelAttribute Product product, Model model) {
        service.create(product);
        return "redirect:list";
    }

    @GetMapping("/list")
    public String productListPage(Model model) {
        List<Product> allProducts = service.findAll();
        model.addAttribute("products", allProducts);
        return "productList";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute Product product) {
        service.editProduct(product);
        return "redirect:list";
    }

    @GetMapping("/edit/{productId}")
    public String editPage(Model model, @PathVariable String productId) {
        Product item = service.getProductId(productId);
        model.addAttribute("product", item);
        return "EditProduct";
    }

    @GetMapping("/delete/{productId}")
    public String deleteProduct(@PathVariable String productId) {
        service.deleteProductById(productId);
        return "redirect:/product/list";
    }
}

