package com.openclassrooms.dataLayer.service;

import java.util.Optional;

import com.openclassrooms.dataLayer.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openclassrooms.dataLayer.model.Product;
import com.openclassrooms.dataLayer.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Iterable<Product> getProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(Integer id) {
        return productRepository.findById(id);
    }

    public Iterable<Product> getProductsByName(String name) {
        return productRepository.findByName(name);
    }

    public Iterable<Product> getProductsByCategoryName(String name) {
        return productRepository.findByCategoriesName(name);
    }

    public Iterable<Product> getProductsByCostLessThan(Integer cost) {
        return productRepository.findByCostLessThan(cost);
    }

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public void deleteProductById(Integer id) {
        productRepository.deleteById(id);
    }

}