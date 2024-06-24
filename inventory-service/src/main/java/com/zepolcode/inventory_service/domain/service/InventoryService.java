package com.zepolcode.inventory_service.domain.service;

import com.zepolcode.inventory_service.domain.model.dto.BaseResponse;
import com.zepolcode.inventory_service.domain.model.dto.OrderItemRequest;
import com.zepolcode.inventory_service.domain.model.entities.Inventory;

import java.util.List;

public interface InventoryService {

    Boolean isInStock(String sku);
    BaseResponse isAreInStock(List<OrderItemRequest> orderItems);
}
