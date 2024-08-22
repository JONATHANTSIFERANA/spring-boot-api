package com.api.Spring.api.controller;

import com.api.Spring.api.models.Product;
import com.api.Spring.api.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@AllArgsConstructor
public class ProductController {
    private ProductService productService;

    @PostMapping("/create")
    public Product createProduct(@RequestBody Product product){
        return productService.createProduct(product);
    }

    @GetMapping("/getProduct")
    public List<Product> getProduct(){
        return productService.getProduct();
    }

    @PutMapping("/updateProduct/{id}")
    public Product updateProduct(@PathVariable int id,@RequestBody Product product){
        return productService.updateProduct(id, product);
    }

    @DeleteMapping("/deleteProduct/{id}")
    public String deleteProduct(@PathVariable int id){
        return productService.deleteProduct(id);
    }
}
