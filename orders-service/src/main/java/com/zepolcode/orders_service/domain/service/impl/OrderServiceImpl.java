package com.zepolcode.orders_service.domain.service.impl;

import com.zepolcode.orders_service.domain.model.dto.response.BaseResponse;
import com.zepolcode.orders_service.domain.model.dto.OrderRequest;
import com.zepolcode.orders_service.domain.model.dto.response.OrderItemsResponse;
import com.zepolcode.orders_service.domain.model.dto.response.OrderResponse;
import com.zepolcode.orders_service.domain.model.entities.Order;
import com.zepolcode.orders_service.domain.model.entities.OrderItems;
import com.zepolcode.orders_service.domain.service.OrderService;
import com.zepolcode.orders_service.infrastructure.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final WebClient.Builder webClientBuilder;

    @Override
    public void placeOrder(OrderRequest orderRequest) {

        BaseResponse result = webClientBuilder.build()
                .post()
                .uri("http://localhost:9090/api/v5/inventory/in-stock")
                .bodyValue(orderRequest.getOrderItems())
                .retrieve()
                .bodyToMono(BaseResponse.class)
                .block();


        if(result != null && !result.hasErrors()) {
            Order order = new Order();
            order.setOrderNumber(UUID.randomUUID().toString());

            List<OrderItems> orderItems = orderRequest.getOrderItems().stream()
                    .map(orderItemRequest -> new OrderItems(orderItemRequest, order))
                    .collect(Collectors.toList());

            order.setOrderItems(orderItems);

            orderRepository.save(order);
        }else {
            throw new IllegalArgumentException("Some of the products are not in stock");
        }


    }

    @Override
    public List<OrderResponse> getAllOrders() {
        List<Order> orders = orderRepository.findAll();

        return orders.stream().map(OrderResponse::new).toList();

    }


}
