package com.example.sistemaventassid2.repository;

import com.example.sistemaventassid2.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, String> {
}
