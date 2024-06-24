package com.zepolcode.orders_service.domain.model.entities;

import com.zepolcode.orders_service.domain.model.dto.OrderItemRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "order_items")
public class OrderItems {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String sku;
    private Double price;
    private Long quantity;

    @ManyToOne()
    @JoinColumn(name="order_id")
    private Order order;

    public OrderItems(OrderItemRequest orderItemRequest, Order order) {
        id = orderItemRequest.getId();
        sku = orderItemRequest.getSku();
        price = orderItemRequest.getPrice();
        quantity = orderItemRequest.getQuantity();
        this.order = order;
    }

}
