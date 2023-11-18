package com.example.sistemaventassid2.model;

import jakarta.persistence.*;

@Entity
@Table(name="order_detail")
public class OrderDetail {

    private int quantity;
    private double price;
    @Id
    @ManyToOne
    @JoinColumn(name = "productId")
    Product product;
    @Id
    @ManyToOne
    @JoinColumn(name = "orderNumber")
    Order order;

    public OrderDetail() {
    }

    public OrderDetail(int quantity, double price) {
        this.quantity = quantity;
        this.price = price;
    }


}
