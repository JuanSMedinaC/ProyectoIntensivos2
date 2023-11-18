package com.example.sistemaventassid2.repository;

import com.example.sistemaventassid2.model.OrderDetail;
import com.example.sistemaventassid2.model.OrderDetailId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, OrderDetailId> {
}
