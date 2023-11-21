package com.example.sistemaventassid2.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name="order_detail")
public class OrderDetail {

    private int quantity;
    private double price;
    @EmbeddedId
    private OrderDetailId id;

    @ManyToOne
    @MapsId("productId")
    private Product product;
    @JsonIgnore
    @ManyToOne
    @MapsId("orderId")
    private Order order;

    public OrderDetail(int quantity, double price) {
        this.quantity = quantity;
        this.price = price;
    }

    public OrderDetail() {

    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public OrderDetailId getId() {
        return id;
    }

    public void setId(OrderDetailId id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
