package com.zepolcode.inventory_service.domain.utils;

import com.zepolcode.inventory_service.domain.model.entities.Inventory;
import com.zepolcode.inventory_service.infrastructure.repository.InventoryRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@Slf4j
@Component
public class DataLoader implements CommandLineRunner {
    private final InventoryRepository inventoryRepository;


    @Override
    public void run(String... args) throws Exception {
        log.info("Loading data...");
        if(inventoryRepository.findAll().size() == 0) {
            inventoryRepository.saveAll(
                    List.of(
                            Inventory.builder().sku("00001").quantity(10L).build(),
                            Inventory.builder().sku("00002").quantity(20L).build(),
                            Inventory.builder().sku("00003").quantity(30L).build(),
                            Inventory.builder().sku("00004").quantity(0L).build()
                    )
            );
        }
        log.info("Loading data complete.");
    }
}
