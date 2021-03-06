package com.southface.delivery.southface_delivery.dto;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Products")
@Entity
@Table(name = "products")
public class Product implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToMany(mappedBy = "products")
    @JsonIgnore
    private List<Delivery> deliveries;

    private String name;
    private int quantity;
    private int extProductId;

    private String description;

    public Product(){}

    public Product(int extProductId, int quantity){
        this.extProductId = extProductId;
        this.quantity = quantity;
    }

    public Product(int id, int extProductId, int quantity){
        this.id = id;
        this.extProductId = extProductId;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getExtProductId() {
        return extProductId;
    }

    public void setExtProductId(int extProductId) {
        this.extProductId = extProductId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
