package com.zepolcode.orders_service.domain.service;

import com.zepolcode.orders_service.domain.model.dto.OrderRequest;
import com.zepolcode.orders_service.domain.model.dto.response.OrderResponse;
import com.zepolcode.orders_service.domain.model.entities.Order;

import java.util.List;

public interface OrderService {

    void placeOrder(OrderRequest orderRequest);

    List<OrderResponse> getAllOrders();
}
