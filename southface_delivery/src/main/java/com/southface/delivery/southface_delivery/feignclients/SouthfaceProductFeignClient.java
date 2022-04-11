package com.southface.delivery.southface_delivery.feignclients;

import com.southface.delivery.southface_delivery.dto.Product;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("SOUTHFACE-PRODUCT")
public interface SouthfaceProductFeignClient {
    @GetMapping("/api/v1/product/{productId}")
    ResponseEntity<Product> getProduct(@PathVariable int productId);
}
