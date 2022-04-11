package com.southface.delivery.southface_product.controllers;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.southface.delivery.southface_product.dao.ProductRepository;
import com.southface.delivery.southface_product.dto.Product;

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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/v1")
@Tag(name = "Products", description = "Endpoints for managing products")
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    @GetMapping("/products")
    @Operation(
        summary = "Lists products",
        description = "Lists products availables",
        tags = { "Products" }
    )
    public ResponseEntity<List<Product>> getProduct() {
        List<Product> listProduct = (List<Product>)productRepository.findAll();

        return new ResponseEntity<List<Product>>(listProduct, HttpStatus.OK);
    }

    @GetMapping("/product/{productId}")
    @Operation(
        summary = "Finds a product",
        description = "Finds a product by their Id.",
        tags = { "Products" }
    )
    public ResponseEntity<Product> getProduct(@PathVariable int productId) {
        Optional<Product> optionalProduct = productRepository.findById(productId);
        if (!optionalProduct.isPresent())
            return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
        
        return new ResponseEntity<Product>(optionalProduct.get(), HttpStatus.OK);
    }

    @PostMapping("/product")
    @Operation(
        summary = "Creates a product",
        description = "Creates a new product.",
        tags = { "Products" }
    )
    public ResponseEntity<Product> addProduct(@Valid @RequestBody Product product) {
        Product newProduct = productRepository.save(product);

        URI location = ServletUriComponentsBuilder
                    .fromCurrentRequest().path("/{productId}")
                    .buildAndExpand(newProduct.getId())
                    .toUri();

        return ResponseEntity.created(location).body(newProduct);
    }

    @PutMapping("/product/{productId}")
    @Operation(
        summary = "Updates a product",
        description = "Updates a product by their Id.",
        tags = { "Products" }
    )
    public ResponseEntity<Product> updateProduct(@PathVariable int productId, @RequestBody Product product) {
        Optional<Product> optionalProduct = productRepository.findById(productId);
        if (!optionalProduct.isPresent())
            return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);

        Product existingProduct = optionalProduct.get();

        existingProduct.setName(product.getName());
        existingProduct.setQuantity(product.getQuantity());
        
        return new ResponseEntity<Product>(productRepository.save(existingProduct), HttpStatus.OK);
    }

    @DeleteMapping("/product/{productId}")
    @Operation(
        summary = "Deletes a product",
        description = "Deletes a product by their Id.",
        tags = { "Products" }
    )
    public ResponseEntity<Product> deleteProduct(@PathVariable int productId) {
        Optional<Product> optionalProduct = productRepository.findById(productId);
        if (!optionalProduct.isPresent())
            return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
            
        Product existingProduct = optionalProduct.get();
        productRepository.delete(existingProduct);

        return new ResponseEntity<Product>(existingProduct, HttpStatus.NO_CONTENT);
    }
}
