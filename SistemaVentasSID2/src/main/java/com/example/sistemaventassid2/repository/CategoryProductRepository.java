package com.example.sistemaventassid2.repository;

import com.example.sistemaventassid2.model.CategoryProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryProductRepository extends JpaRepository<CategoryProduct, String> {
}
