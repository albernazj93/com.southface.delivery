package com.tus.microservice.southface;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class DeliveryService {
    List<Product> productList = new ArrayList<Product>();

    @RequestMapping("/")
    public String index() {
        return "Hello World 2022......";
    }

    @RequestMapping("/product/{product_id}")
    public Product getProduct(@PathVariable int product_id) {
        for(Product p : productList){
            if(p.getId() == product_id){
                return p;
            }
        }
        return null;
    }

    @PostMapping("/product")
    public Product addProduct(@RequestBody Product product) {
        product.setId(new Random().nextInt(1, 100));
        productList.add(product);
        return product;
    }

    @PutMapping("/product")
    public void updateProduct(@RequestBody Product product) {
        for(Product p : productList){
            if(p.getId() == product.getId()){
                p.setName(product.getName());
                p.setQuantity(product.getQuantity());
            }
        }
    }

    @DeleteMapping("/product/{product_id}")
    public void deleteProduct(@PathVariable int product_id) {
        productList.removeIf(product -> product.getId() == product_id);
    }
}
