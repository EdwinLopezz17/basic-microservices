package com.zepolcode.orders_service.domain.model.dto.response;

import com.zepolcode.orders_service.domain.model.entities.OrderItems;
import lombok.Data;

@Data
public class OrderItemsResponse{
    private Long id;
    private String sku;
    private Double price;
    private Long quantity;

    public OrderItemsResponse(OrderItems orderItems) {
        id = orderItems.getId();
        sku = orderItems.getSku();
        price = orderItems.getPrice();
        quantity = orderItems.getQuantity();
    }
}



