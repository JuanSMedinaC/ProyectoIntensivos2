package com.example.sistemaventassid2.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table (name = "orders")
public class Order {
    @Id
    private String orderNumber;
    private Date orderDate;
    private Date shippedDate;
    private Date paymentDate;
    @ManyToOne
    @JoinColumn(name = "customerId")
    Customer customer;

    @OneToMany(mappedBy = "order")
    private List<OrderDetail> orderDetails;

    public Order() {
    }

    public Order(String orderNumber, Date orderDate, Date shippedDate, Date paymentDate) {
        this.orderNumber = orderNumber;
        this.orderDate = orderDate;
        this.shippedDate = shippedDate;
        this.paymentDate = paymentDate;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getShippedDate() {
        return shippedDate;
    }

    public void setShippedDate(Date shippedDate) {
        this.shippedDate = shippedDate;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }
}
