package com.southface.delivery.southface_delivery.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Test")
@Entity
@Table(name = "deliveries")
public class Delivery implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotNull(message="Can not be null")
    @Size(min=1)
    @Column(nullable=false)
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "delivery_products",
            joinColumns = @JoinColumn(name = "delivery_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<Product> products;

    @NotNull(message="Can not be null")
    @NotBlank(message="Can not be empty")
    @Column(nullable=false)
    private String address;

    @Column(nullable=true)
    private String eircode;

    public Delivery(){}

    public Delivery(int id, String address){
        this.id = id;
        this.address = address;
    }

    public Delivery(int id, String address, String eircode){
        this.id = id;
        this.address = address;
        this.eircode = eircode;
    }

    public Delivery(int id, String address, String eircode, List<Product> products){
        this.id = id;
        this.address = address;
        this.eircode = eircode;
        this.products = products;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEircode() {
        return eircode;
    }

    public void setEircode(String eircode) {
        this.eircode = eircode;
    }
}
