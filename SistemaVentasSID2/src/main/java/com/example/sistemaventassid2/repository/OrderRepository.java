package com.example.sistemaventassid2.repository;

import com.example.sistemaventassid2.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
