package com.zepolcode.inventory_service.application;

import com.zepolcode.inventory_service.domain.model.dto.BaseResponse;
import com.zepolcode.inventory_service.domain.model.dto.OrderItemRequest;
import com.zepolcode.inventory_service.domain.service.InventoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v5/inventory")
public class InventoryController {

    private final InventoryService inventoryService;

    @GetMapping("/{sku}")
    @ResponseStatus(HttpStatus.OK)
    public Boolean isInStock(@PathVariable("sku") String sku) {
        return inventoryService.isInStock(sku);
    }

    @PostMapping("/in-stock")
    @ResponseStatus(HttpStatus.OK)
    public BaseResponse inStock(@RequestBody List<OrderItemRequest> orderItems ) {
        return inventoryService.isAreInStock(orderItems);
    }
}
