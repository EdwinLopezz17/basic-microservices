package com.zepolcode.orders_service.domain.model.dto;

import com.zepolcode.orders_service.domain.model.entities.Order;

import lombok.Data;

@Data
public class OrderItemRequest {

    private Long id;
    private String sku;
    private Double price;
    private Long quantity;
}
