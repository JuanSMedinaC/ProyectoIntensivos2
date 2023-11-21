package com.example.sistemaventassid2.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long productId;

    private String description;

    private int quantityAvaliable;

    private double cost;

    private double sellingPrice;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "category_code")
    CategoryProduct categoryProduct;
    @JsonIgnore
    @OneToMany(mappedBy = "product")
    private List<OrderDetail> orderDetails;


    public Product() {
    }

    public Product(Long productId, String description, int quantityAvaliable, double cost, double sellingPrice) {
        this.productId = productId;
        this.description = description;
        this.quantityAvaliable = quantityAvaliable;
        this.cost = cost;
        this.sellingPrice = sellingPrice;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantityAvaliable() {
        return quantityAvaliable;
    }

    public void setQuantityAvaliable(int quantityAvaliable) {
        this.quantityAvaliable = quantityAvaliable;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public CategoryProduct getCategoryProduct() {
        return categoryProduct;
    }

    public void setCategoryProduct(CategoryProduct categoryProduct) {
        this.categoryProduct = categoryProduct;
    }
}
