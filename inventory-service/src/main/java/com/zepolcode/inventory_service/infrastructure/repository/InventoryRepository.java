package com.zepolcode.inventory_service.infrastructure.repository;

import com.zepolcode.inventory_service.domain.model.entities.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {

    Inventory findBySku(String sku);
    List<Inventory> findBySkuIn(List<String> skus);

}
