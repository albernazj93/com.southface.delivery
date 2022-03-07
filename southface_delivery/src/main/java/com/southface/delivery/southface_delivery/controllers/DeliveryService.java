package com.southface.delivery.southface_delivery.controllers;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.southface.delivery.southface_delivery.dao.DeliveryRepository;
import com.southface.delivery.southface_delivery.dto.Delivery;

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
@Tag(name = "Deliveries", description = "Endpoints for managing deliveries")
public class DeliveryService {
    @Autowired
    DeliveryRepository deliveryRepository;

    @GetMapping("/deliveries")
    @Operation(
        summary = "Lists deliveries",
        description = "Lists deliveries availables",
        tags = { "Deliveries" }
    )
    public ResponseEntity<List<Delivery>> getDelivery() {
        List<Delivery> listDelivery = (List<Delivery>)deliveryRepository.findAll();

        return new ResponseEntity<List<Delivery>>(listDelivery, HttpStatus.OK);
    }

    @GetMapping("/deliveries/{deliveryId}")
    @Operation(
        summary = "Finds a delivery",
        description = "Finds a delivery by their Id.",
        tags = { "Deliveries" }
    )
    public ResponseEntity<Delivery> getDelivery(@PathVariable int deliveryId) {
        Optional<Delivery> optionalDelivery = deliveryRepository.findById(deliveryId);
        if (!optionalDelivery.isPresent())
            return new ResponseEntity<Delivery>(HttpStatus.NOT_FOUND);

        return new ResponseEntity<Delivery>(optionalDelivery.get(), HttpStatus.OK);
    }

    @PostMapping("/deliveries")
    @Operation(
        summary = "Creates a delivery",
        description = "Creates a new delivery.",
        tags = { "Deliveries" }
    )
    public ResponseEntity<Delivery> addDelivery(@Valid @RequestBody Delivery delivery) {
        Delivery newDelivery = deliveryRepository.save(delivery);

        URI location = ServletUriComponentsBuilder
                    .fromCurrentRequest().path("/{deliveryId}")
                    .buildAndExpand(newDelivery.getId())
                    .toUri();

        return ResponseEntity.created(location).body(newDelivery);
    }

    @PutMapping("/deliveries/{deliveryId}")
    @Operation(
        summary = "Updates a delivery",
        description = "Updates a delivery by their Id.",
        tags = { "Deliveries" }
    )
    public ResponseEntity<Delivery> updateDelivery(@PathVariable int deliveryId, @RequestBody Delivery delivery) {
        Optional<Delivery> optionalDelivery = deliveryRepository.findById(deliveryId);
        if (!optionalDelivery.isPresent())
            return new ResponseEntity<Delivery>(HttpStatus.NOT_FOUND);

        Delivery existingDelivery = optionalDelivery.get();

        existingDelivery.setAddress(delivery.getAddress());
        
        return new ResponseEntity<Delivery>(deliveryRepository.save(existingDelivery), HttpStatus.OK);
    }

    @DeleteMapping("/deliveries/{deliveryId}")
    @Operation(
        summary = "Deletes a delivery",
        description = "Deletes a delivery by their Id.",
        tags = { "Deliveries" }
    )
    public ResponseEntity<Delivery> deleteDelivery(@PathVariable int deliveryId) {
        Optional<Delivery> optionalDelivery = deliveryRepository.findById(deliveryId);
        if (!optionalDelivery.isPresent())
            return new ResponseEntity<Delivery>(HttpStatus.NOT_FOUND);

        Delivery existingDelivery = optionalDelivery.get();
        deliveryRepository.delete(existingDelivery);

        return new ResponseEntity<Delivery>(existingDelivery, HttpStatus.NO_CONTENT);
    }
}
