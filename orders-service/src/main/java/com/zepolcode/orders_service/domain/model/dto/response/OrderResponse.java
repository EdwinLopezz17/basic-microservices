package com.zepolcode.orders_service.domain.model.dto.response;


import com.zepolcode.orders_service.domain.model.entities.Order;
import lombok.Data;

import java.util.List;

@Data
public class OrderResponse{
    private Long id;
    private String orderNumber;
    private List<OrderItemsResponse> orderItems;

    public OrderResponse(Order order) {
        id = order.getId();
        orderNumber = order.getOrderNumber();
        orderItems = order.getOrderItems().stream()
                .map(OrderItemsResponse::new).toList();
    }
}
