package com.southface.delivery.southface_delivery.dao;

import java.util.Optional;

import com.southface.delivery.southface_delivery.entity.Delivery;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryRepository extends CrudRepository<Delivery, Integer> {
    Optional<Delivery> findById(int deliveryId);
}
