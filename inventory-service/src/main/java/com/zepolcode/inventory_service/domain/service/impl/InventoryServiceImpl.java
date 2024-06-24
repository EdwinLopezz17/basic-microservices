package com.zepolcode.inventory_service.domain.service.impl;

import com.zepolcode.inventory_service.domain.model.dto.BaseResponse;
import com.zepolcode.inventory_service.domain.model.dto.OrderItemRequest;
import com.zepolcode.inventory_service.domain.model.entities.Inventory;
import com.zepolcode.inventory_service.domain.service.InventoryService;
import com.zepolcode.inventory_service.infrastructure.repository.InventoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class InventoryServiceImpl implements InventoryService {

    private final InventoryRepository inventoryRepository;

    @Override
    public Boolean isInStock(String sku) {
        Inventory inventory = inventoryRepository.findBySku(sku);

        return inventory.getQuantity()>0;
    }

    @Override
    public BaseResponse isAreInStock(List<OrderItemRequest> orderItems) {
        var errorList = new ArrayList<String>();
        List<String> skus = orderItems.stream().map(OrderItemRequest::getSku).toList();

        List<Inventory> inventoryList = inventoryRepository.findBySkuIn(skus);

        orderItems.forEach(orderItem -> {
            var inventory = inventoryList.stream().filter(value->value.getSku().equals(orderItem.getSku())).findFirst();
            if(inventory.isEmpty()) {
                errorList.add("Product with SKU " + orderItem.getSku() + " not found");
            }else if(inventory.get().getQuantity() < orderItem.getQuantity()) {
                errorList.add("Product with SKU " + orderItem.getSku() + " has insufficient stock");
            }
        });

        return errorList.size()>0 ? new BaseResponse(errorList.toArray(new String[0])) : new BaseResponse(null);
    }
}
