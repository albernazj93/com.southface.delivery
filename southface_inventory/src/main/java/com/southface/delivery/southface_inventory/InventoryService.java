package com.southface.delivery.southface_inventory;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.southface.delivery.southface_inventory.dao.ProductRepository;
import com.southface.delivery.southface_inventory.entity.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@Service
public class InventoryService {
    List<Product> productList = new ArrayList<Product>();

    @Autowired
    ProductRepository productRepository;

    @RequestMapping("/")
    public String index() {
        return "SouthFace Inventory";
    }

    @GetMapping("/product/{productId}")
    public ResponseEntity<Product> getProduct(@PathVariable int productId) {
        Optional<Product> optionalProduct = productRepository.findById(productId);
        if (!optionalProduct.isPresent())
            return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
        
        return new ResponseEntity<Product>(optionalProduct.get(), HttpStatus.OK);
    }

    @PostMapping("/product")
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        Product newProduct = productRepository.save(product);
        return new ResponseEntity<Product>(newProduct, HttpStatus.OK);
    }

    @PutMapping("/product/{productId}")
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
    public ResponseEntity<Product> deleteProduct(@PathVariable int productId) {
        Optional<Product> optionalProduct = productRepository.findById(productId);
        if (!optionalProduct.isPresent())
            return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
            
        Product existingProduct = optionalProduct.get();
        productRepository.delete(existingProduct);

        return new ResponseEntity<Product>(existingProduct, HttpStatus.OK);
    }
}
