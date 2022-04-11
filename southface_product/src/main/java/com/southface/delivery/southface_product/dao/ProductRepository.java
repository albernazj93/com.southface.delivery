package com.southface.delivery.southface_product.dao;

import java.util.Optional;

import com.southface.delivery.southface_product.dto.Product;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {
    Optional<Product> findById(int productId);
}
