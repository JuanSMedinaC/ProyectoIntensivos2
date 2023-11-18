package com.example.sistemaventassid2.controller;

import com.example.sistemaventassid2.model.Customer;
import com.example.sistemaventassid2.model.Order;
import com.example.sistemaventassid2.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/sql")
public class SqlController {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final CustomerRepository customerRepository;
    private final OrderDetailRepository orderDetailRepository;
    private final CategoryProductRepository categoryProductRepository;

    @Autowired
    public SqlController(OrderRepository orderRepository, ProductRepository productRepository, CustomerRepository customerRepository, OrderDetailRepository orderDetailRepository, CategoryProductRepository categoryProductRepository) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
        this.customerRepository = customerRepository;
        this.orderDetailRepository = orderDetailRepository;
        this.categoryProductRepository = categoryProductRepository;
    }

    @PostMapping(value = "/orders", consumes = "application/json")
    public ResponseEntity<String> placeOrder(@RequestBody Order order) {
        orderRepository.save(order);
        return ResponseEntity.ok("Order placed successfully.");
    }

    @PostMapping(value = "/customers", consumes = "application/json")
    public ResponseEntity<String> registerCustomer(@RequestBody Customer customer) {
        customerRepository.save(customer);
        return ResponseEntity.ok("Customer registered successfully.");
    }

}
