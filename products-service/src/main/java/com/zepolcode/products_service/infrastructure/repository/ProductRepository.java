package com.zepolcode.products_service.infrastructure.repository;

import com.zepolcode.products_service.domain.model.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
