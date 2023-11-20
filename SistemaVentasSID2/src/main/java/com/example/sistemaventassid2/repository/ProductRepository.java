package com.example.sistemaventassid2.repository;

import com.example.sistemaventassid2.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
