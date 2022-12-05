package com.example.productms.service;

import com.example.productms.entity.Product;
import com.example.productms.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public Product findUserById(Long id) {
        return productRepository.findByProdId(id);
    }
}
