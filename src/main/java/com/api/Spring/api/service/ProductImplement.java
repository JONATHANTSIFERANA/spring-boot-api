package com.api.Spring.api.service;

import com.api.Spring.api.models.Product;
import com.api.Spring.api.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ProductImplement implements ProductService {
    private ProductRepository productRepository;

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> getProduct() {
        return productRepository.findAll();
    }

    @Override
    public Product updateProduct(int id, Product product) {
        return productRepository.findById(id)
                .map(prod -> {
                    prod.setName(product.getName());
                    prod.setDescription(product.getDescription());
                    prod.setSale(product.getSale());
                    return productRepository.save(prod);
                })
                .orElseThrow(() -> new RuntimeException("Product not found !"));
    }

    @Override
    public String deleteProduct(int id) {
        productRepository.deleteById(id);
        return "Product deleted !";
    }
}
