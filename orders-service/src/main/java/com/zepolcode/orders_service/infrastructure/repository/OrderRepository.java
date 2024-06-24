package com.zepolcode.orders_service.infrastructure.repository;


import com.zepolcode.orders_service.domain.model.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
