package com.examly.springapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.springapp.model.Product;
import com.examly.springapp.repository.ProductRepo;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepo productRepository;

    @Override
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Long id) {
        Optional<Product> opt = productRepository.findById(id);
        return opt.orElse(null);
    }

    @Override
    public Product updateProduct(Product product, Long id) {
        Optional<Product> opt = productRepository.findById(id);
        if(opt.isPresent()){
            Product existing = opt.get();
            existing.setProductName(product.getProductName());
            existing.setDescription(product.getDescription());
            existing.setPrice(product.getPrice());
            existing.setStockQuantity(product.getStockQuantity());
            return productRepository.save(existing);
        }
        return null;
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}