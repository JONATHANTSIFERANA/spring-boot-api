package com.api.Spring.api.service;

import com.api.Spring.api.models.Product;
import lombok.AllArgsConstructor;

import java.util.List;

public interface ProductService {
    Product createProduct(Product product);
    List<Product> getProduct();
    Product updateProduct(int id,Product product);
    String deleteProduct(int id);
}
