package com.zepolcode.products_service.domain.model.entities;

import com.zepolcode.products_service.domain.model.dto.ProductRequest;
import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String sku;
    private String name;
    private String description;
    private Double price;
    private Boolean status;

    public Product(ProductRequest productRequest) {
        sku = productRequest.getSku();
        name = productRequest.getName();
        description = productRequest.getDescription();
        price = productRequest.getPrice();
        status = productRequest.getStatus();
    }

}