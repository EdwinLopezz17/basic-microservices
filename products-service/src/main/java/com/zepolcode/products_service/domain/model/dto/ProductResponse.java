package com.zepolcode.products_service.domain.model.dto;

import com.zepolcode.products_service.domain.model.entities.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse {

    private Long id;
    private String sku;
    private String name;
    private String description;
    private Double price;
    private Boolean status;

    public ProductResponse(Product product) {
        id = product.getId();
        sku = product.getSku();
        name = product.getName();
        description = product.getDescription();
        price = product.getPrice();
        status = product.getStatus();
    }
}
