package com.examly.springapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examly.springapp.model.Product;
import com.examly.springapp.service.ProductService;

@RequestMapping("/api")
@RestController
public class ProductController {

@Autowired
private ProductService productService;

// CREATE PRODUCT
@PostMapping("/products")
public ResponseEntity<Product> createProduct(@RequestBody(required = false) Product product) {
if (product == null) {
return ResponseEntity.badRequest().build();
}
Product savedProduct = productService.addProduct(product);
return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
}

// GET ALL PRODUCTS
@GetMapping("/products")
public ResponseEntity<List<Product>> getAllProduct() {
List<Product> products = productService.getAllProducts();
if (products.isEmpty()) {
return ResponseEntity.noContent().build();
}
return new ResponseEntity<>(products, HttpStatus.OK);
}

// GET PRODUCT BY ID
@GetMapping("/products/{id}")
public ResponseEntity<Product> getProductById(@PathVariable Long id) {
Product product = productService.getProductById(id);

if (product == null) {
return ResponseEntity.notFound().build();
}

return new ResponseEntity<>(product, HttpStatus.OK);
}

// UPDATE PRODUCT
@PutMapping("/products/{id}")
public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product product) {

Product updatedProduct = productService.updateProduct(product, id);

if (updatedProduct == null) {
return ResponseEntity.notFound().build();
}

return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
}

// DELETE PRODUCT
@DeleteMapping("/products/{id}")
public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
productService.deleteProduct(id);
return ResponseEntity.noContent().build();
}
}